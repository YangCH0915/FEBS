package cn.xry.system.controller;

import cn.xry.common.annotation.Log;
import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.QueryRequest;
import cn.xry.common.domain.ResponseBo;
import cn.xry.common.util.FileUtils;
import cn.xry.common.util.MD5Utils;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.domain.AdminUserWithRole;
import cn.xry.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	private static final String ON = "on";

	@RequestMapping("user")
	@RequiresPermissions("user:list")
	public String index(Model model) {
		AdminUser user = super.getCurrentUser();
		model.addAttribute("user", user);
		return "system/user/user";
	}

	@RequestMapping("user/checkUserName")
	@ResponseBody
	public boolean checkUserName(String username, String oldusername) {
		if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
			return true;
		}
		AdminUser result = this.userService.findByName(username);
		return result == null;
	}

	@RequestMapping("user/getUser")
	@ResponseBody
	public ResponseBo getUser(Long userId) {
		try {
			AdminUserWithRole user = this.userService.findAdminUserWithRole(userId);
			return ResponseBo.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
		}
	}

	@Log("获取用户信息")
	@RequestMapping("user/list")
	@ResponseBody
	public Map<String, Object> userList(QueryRequest request, AdminUser user) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<AdminUser> list = this.userService.findUser(user);
		PageInfo<AdminUser> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}

	@RequestMapping("user/excel")
	@ResponseBody
	public ResponseBo userExcel(AdminUser user) {
		try {
			List<AdminUser> list = this.userService.findUser(user);
			return FileUtils.createExcelByPOIKit("用户表", list, AdminUser.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/csv")
	@ResponseBody
	public ResponseBo userCsv(AdminUser user) {
		try {
			List<AdminUser> list = this.userService.findUser(user);
			return FileUtils.createCsv("用户表", list, AdminUser.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/regist")
	@ResponseBody
	public ResponseBo regist(AdminUser user) {
		try {
			AdminUser result = this.userService.findByName(user.getUsername());
			if (result != null) {
				return ResponseBo.warn("该用户名已被使用！");
			}
			this.userService.registerUser(user);
			return ResponseBo.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("注册失败，请联系网站管理员！");
		}
	}

	@Log("新增用户")
	@RequiresPermissions("user:add")
	@RequestMapping("user/add")
	@ResponseBody
	public ResponseBo addUser(AdminUser user, Long[] roles) {
		try {
			if (ON.equalsIgnoreCase(user.getStatus()))
				user.setStatus(AdminUser.STATUS_VALID);
			else
				user.setStatus(AdminUser.STATUS_LOCK);
			this.userService.addUser(user, roles);
			return ResponseBo.ok("新增用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("新增用户失败，请联系网站管理员！");
		}
	}

	@Log("修改用户")
	@RequiresPermissions("user:update")
	@RequestMapping("user/update")
	@ResponseBody
	public ResponseBo updateUser(AdminUser user, Long[] rolesSelect) {
		try {
			if (ON.equalsIgnoreCase(user.getStatus()))
				user.setStatus(AdminUser.STATUS_VALID);
			else
				user.setStatus(AdminUser.STATUS_LOCK);
			this.userService.updateUser(user, rolesSelect);
			return ResponseBo.ok("修改用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("修改用户失败，请联系网站管理员！");
		}
	}

	@Log("删除用户")
	@RequiresPermissions("user:delete")
	@RequestMapping("user/delete")
	@ResponseBody
	public ResponseBo deleteUsers(String ids) {
		try {
			this.userService.deleteUsers(ids);
			return ResponseBo.ok("删除用户成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("删除用户失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/checkPassword")
	@ResponseBody
	public boolean checkPassword(String password) {
		AdminUser user = getCurrentUser();
		String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
		return user.getPassword().equals(encrypt);
	}

	@RequestMapping("user/updatePassword")
	@ResponseBody
	public ResponseBo updatePassword(String newPassword) {
		try {
			this.userService.updatePassword(newPassword);
			return ResponseBo.ok("更改密码成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("更改密码失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/profile")
	public String profileIndex(Model model) {
		AdminUser user = super.getCurrentUser();
		user = this.userService.findUserProfile(user);
		model.addAttribute("user", user);
		return "system/user/profile";
	}

	@RequestMapping("user/getUserProfile")
	@ResponseBody
	public ResponseBo getUserProfile(Long userId) {
		try {
			AdminUser user = new AdminUser();
			user.setUserId(userId);
			return ResponseBo.ok(this.userService.findUserProfile(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/updateUserProfile")
	@ResponseBody
	public ResponseBo updateUserProfile(AdminUser user) {
		try {
			this.userService.updateNotNull(user);
			return ResponseBo.ok("更新个人信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
		}
	}

	@RequestMapping("user/changeAvatar")
	@ResponseBody
	public ResponseBo changeAvatar(String imgName) {
		try {
			String[] img = imgName.split("/");
			String realImgName = img[img.length-1];
			AdminUser user = getCurrentUser();
			user.setAvatar(realImgName);
			this.userService.updateNotNull(user);
			return ResponseBo.ok("更新头像成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("更新头像失败，请联系网站管理员！");
		}
	}
}
