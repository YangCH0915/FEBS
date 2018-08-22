package cn.xry.pay.controller;

import cn.xry.common.controller.BaseController;
import cn.xry.common.domain.QueryRequest;
import cn.xry.pay.domain.Order;
import cn.xry.pay.service.OrderService;
import cn.xry.system.domain.AdminUser;
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
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("order")
    @RequiresPermissions("order:list")
    public String index() {

        return "order/order";
    }

    @RequestMapping("order/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request,Model model) {
        AdminUser user = super.getCurrentUser();
        model.addAttribute("user", user);
//        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Order> list = this.orderService.selectAll();
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }
}
