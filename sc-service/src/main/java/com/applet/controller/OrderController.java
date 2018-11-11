package com.applet.controller;

import com.commons.dto.applet.OrderDTO;
import com.commons.message.ResponseMessage;
import com.commons.entity.Order;
import com.applet.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
  * @Description(功能描述): 订单板块
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/20 18:15
  **/
@RestController
@RequestMapping("order")
@Api(tags ="订单模块")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "生成订单")
	@ResponseBody
	@PatchMapping(value = "/addOrder")
	public ResponseMessage addOrder(@Valid Order order) {
		return ResponseMessage.result(orderService.saveOrder(order));
	}

	@ApiOperation(value = "修改订单")
	@ResponseBody
	@PatchMapping(value = "/updateOrder")
	public ResponseMessage updateOrder(@Valid Order order) {
		return ResponseMessage.result(orderService.updateOrder(order));
	}
	@ApiOperation(value = "订单列表")
	@ResponseBody
	@PatchMapping(value = "/findOrders")
	public ResponseMessage findOrders(@Valid OrderDTO order) {
		return ResponseMessage.result(orderService.findOrders(order));
	}

}
