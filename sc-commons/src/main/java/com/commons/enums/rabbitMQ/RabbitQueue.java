package com.commons.enums.rabbitMQ;

/**
 * @notes: 消息队列 定义
 * @author: At
 * @date: 2018/8/26
 */
public interface RabbitQueue {

    /**
     * 邮件验证码
     */
    String EMAIL_CODE = "email_code";
    /**
     * 短信验证码
     */
    String SMS_CODE = "sms_code";
    /**
     * 邮件通知
     */
    String EMAIL_NOTIFY = "email_notify";

    /**
     * 短信通知
     */
    String SMS_NOTIFY = "sms_notify";
    /**
     * 极光推送通知
     */
    String JPUSH_NOTIFY = "jpush_notify";
}
