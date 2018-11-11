package com.applet.service.impl;

import com.commons.dto.applet.OrderDTO;
import com.commons.message.ResultMessage;
import com.applet.mapper.OrderDao;
import com.applet.service.OrderService;
import com.commons.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;


	@Override
	public ResultMessage saveOrder(Order Order) {
		return ResultMessage.build(orderDao.insert(Order));
	}

	@Override
	public ResultMessage updateOrder(Order Order) {
		return ResultMessage.build(orderDao.updateByPrimaryKeySelective(Order));
	}

	@Override
	public ResultMessage findOrders(OrderDTO orderDTO) {
		return ResultMessage.build(orderDao.findOrders(orderDTO));
	}
}
