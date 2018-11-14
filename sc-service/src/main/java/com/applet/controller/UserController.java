package com.applet.controller;

import com.commons.message.ResponseMessage;
import com.applet.service.UserService;
import com.commons.entity.User;
import com.commons.message.ResultMessage;
import com.commons.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@ApiOperation(value = "获取用户信息",response = UserInfoVO.class)
	@GetMapping(value = "/getUser/{uid}")
	@ApiImplicitParam(name = "uid",type="string",value = "用户id", required = true)
	public ResponseMessage getUser(@PathVariable String uid) {
		ResultMessage result=userService.getUser(uid);
		if(result.isOK()){
			User user=(User)result.getData();
			UserInfoVO userInfoVO=new UserInfoVO();
			BeanUtils.copyProperties(user,userInfoVO);
			return ResponseMessage.okObject(userInfoVO);
		}
		return ResponseMessage.error();
	}

}
