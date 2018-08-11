package cn.xry.pay.controller;

import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.QueryRequest;
import cn.xry.common.domain.ResponseBo;
import cn.xry.pay.domain.Passageway;
import cn.xry.pay.service.PassagewayService;
import cn.xry.system.domain.AdminUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PassagewayController extends BaseController {

    @Autowired
    private PassagewayService passagewayService;

    @RequestMapping("passageway")
    @RequiresPermissions("passageway:list")
    public String index(Model model) {
        AdminUser user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "system/pay/passageway";
    }

    @RequestMapping("passageway/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Passageway> list = this.passagewayService.findAll();
        PageInfo<Passageway> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @RequiresPermissions("passageway:add")
    @RequestMapping("passageway/add")
    @ResponseBody
    public ResponseBo add(Passageway passageway) {
        try {
            this.passagewayService.add(passageway);
            return ResponseBo.ok("新增通道成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增通道失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("passageway:update")
    @RequestMapping("passageway/update")
    @ResponseBody
    public ResponseBo update(Passageway passageway) {
        try {
            this.passagewayService.update(passageway);
            return ResponseBo.ok("修改通道成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改通道失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("passageway:delete")
    @RequestMapping("passageway/delete")
    @ResponseBody
    public ResponseBo delete(String ids) {
        try {
            this.passagewayService.deletePassageways(ids);
            return ResponseBo.ok("删除通道成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除通道失败，请联系网站管理员！");
        }
    }

    @RequestMapping("passageway/getPassageway")
    @ResponseBody
    public ResponseBo getPassageway(long id) {
        try {
            Passageway passageways = this.passagewayService.findPassagewayById(id);
            return ResponseBo.ok(passageways);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取通道失败");
        }
    }
}
