package com.commons.exception;

/**
 * @Description(功能描述) :非法请求异常
 * @author(作者) :lrfalse<wangliyou>
 * @date(开发日期) :2018/8/12 20:36
 **/
public class TokenValidationException extends RuntimeException {

	public TokenValidationException(String msg) {
		super(msg);
	}
}
