package cn.xry.system.controller;

import cn.xry.common.annotation.Log;
import cn.xry.common.config.PlatProperies;
import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.ResponseBo;
import cn.xry.common.util.MD5Utils;
import cn.xry.common.util.vcode.Captcha;
import cn.xry.common.util.vcode.GifCaptcha;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private PlatProperies platProperies;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, String code, Boolean rememberMe) {
        if (!StringUtils.isNotBlank(code)) {
            return ResponseBo.warn("验证码不能为空！");
        }
        Session session = super.getSession();
        String sessionCode = (String) session.getAttribute("_code");
        System.out.println("获取二维码："+sessionCode);
        session.removeAttribute("_code");
        if (!code.toLowerCase().equals(sessionCode)) {
            return ResponseBo.warn("验证码错误！");
        }
        // 密码 MD5 加密
        password = MD5Utils.encrypt(username.toLowerCase(), password);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            super.login(token);
            this.userService.updateLoginTime(username);
            return ResponseBo.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(
                    platProperies.getValidateCode().getWidth(),
                    platProperies.getValidateCode().getHeight(),
                    platProperies.getValidateCode().getLength());
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);
            session.removeAttribute("_code");
            session.setAttribute("_code", captcha.text().toLowerCase());

            String sessionCode = (String) session.getAttribute("_code");
            System.out.println("生成二维码："+sessionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @Log("访问系统")
    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过 Subject 获取登录的用户信息
        AdminUser user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
