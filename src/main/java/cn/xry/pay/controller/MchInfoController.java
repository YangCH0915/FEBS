package cn.xry.pay.controller;

import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.QueryRequest;
import cn.xry.pay.dto.MchInfoRelation;
import cn.xry.pay.service.MchInfoService;
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
public class MchInfoController extends BaseController {


    @Autowired
    private MchInfoService mchInfoService;

    @RequestMapping("mchInfo")
    @RequiresPermissions("mchInfo:list")
    public String index(Model model) {
        AdminUser user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "system/pay/passageway";
    }

    @RequestMapping("mchInfo/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<MchInfoRelation> list = this.mchInfoService.findMchInfoRelation();
        PageInfo<MchInfoRelation> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }
}
