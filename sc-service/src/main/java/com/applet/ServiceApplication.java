package com.applet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import tk.mybatis.spring.annotation.MapperScan;

/**
  * @Description(功能描述): 小程序
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/4/16 11:24
  **/
@Controller
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.commons.config",
		"com.applet.controller",
		"com.applet.service",
		"com.applet.service.impl",
})
@MapperScan(basePackages = "com.applet.mapper")
public class ServiceApplication implements CommandLineRunner {
	@Autowired
	private Environment env;
	private Logger logger = LoggerFactory.getLogger(ServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		logger.info("小程序服务启动完成!--->>>端口:"+env.getProperty("server.port"));
	}
}
