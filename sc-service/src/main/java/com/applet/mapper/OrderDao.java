package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.OrderDTO;
import com.commons.entity.Order;

import java.util.List;

public interface OrderDao extends MyMapper<Order>{

	List<Order> findOrders(OrderDTO advertDTO);

}