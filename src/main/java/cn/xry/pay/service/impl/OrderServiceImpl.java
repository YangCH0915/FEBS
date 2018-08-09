package cn.xry.pay.service.impl;

import cn.xry.common.service.impl.BaseService;
import cn.xry.pay.domain.Order;
import cn.xry.pay.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
}
