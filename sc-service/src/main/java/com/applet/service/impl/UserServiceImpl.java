package com.applet.service.impl;


import com.commons.message.ResultMessage;
import com.applet.service.UserService;
import com.commons.entity.User;
import com.applet.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	  * @Description(功能描述): 保存用户信息
	  * @author(作者): lrfalse<wangliyou>
	  * @date (开发日期): 2018/10/14 22:50
	  **/
	@Override
	public ResultMessage saveUser(User user) {
		return ResultMessage.build(userDao.insert(user));
	}

	@Override
	public ResultMessage getUser(String userId) {
		return ResultMessage.build(userDao.selectByPrimaryKey(userId));
	}
}