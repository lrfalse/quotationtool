package com.applet.service;


import com.commons.message.ResultMessage;
import com.commons.entity.User;
import org.springframework.stereotype.Service;

/**
  * @Description(功能描述): 用户
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:36
  **/
@Service
public interface UserService {

	ResultMessage saveUser(User user);

}