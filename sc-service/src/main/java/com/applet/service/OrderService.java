package com.applet.service;

import com.commons.dto.applet.OrderDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Order;

/**
  * @Description(功能描述): 订单
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/20 19:26
  **/
public interface OrderService {

	ResultMessage saveOrder(Order Order);
	ResultMessage updateOrder(Order Order);
	ResultMessage findOrders(OrderDTO orderDTO);

}
