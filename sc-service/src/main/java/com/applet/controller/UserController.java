package com.applet.controller;

import com.commons.message.ResponseMessage;
import com.applet.service.UserService;
import com.commons.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
  * @Description(功能描述): 小程序用户
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 22:19
  **/
@RestController
@RequestMapping("user")
@Api(tags ="用户信息")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "保存用户信息")
	@ResponseBody
	@PatchMapping(value = "/addUser")
	public ResponseMessage addUser(@Valid User user) {
		return ResponseMessage.result(userService.saveUser(user));
	}
}
