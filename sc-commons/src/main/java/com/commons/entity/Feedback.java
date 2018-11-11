package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 反馈表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:37
  **/
@Data
@Table(name="t_feedback")
public class Feedback extends BaseEntity {

    /**
     * 问题类型（0基础问题1任务问题2支付问题3优惠券问题）
     */
    private Integer type;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 0未反馈，1已反馈
     */
    private Integer isFeedback;
	/**
	 * 用户id
	 */
	private Long userId;

}