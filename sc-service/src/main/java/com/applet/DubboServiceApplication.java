package com.applet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import tk.mybatis.spring.annotation.MapperScan;

/**
  * @Description(功能描述):新增工具包
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
public class DubboServiceApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(DubboServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DubboServiceApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		logger.info("dubbo服务启动完成!");
	}
}
