package com.commons.dto.applet.feedback;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
  * @Description(功能描述): 反馈表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:37
  **/
@Data
@ApiModel("反馈信息")
public class FeedbackDTO {

    /**
     * 问题类型（0基础问题1任务问题2支付问题3优惠券问题）
     */
	@NotNull(message = "问题类型不能为空")
	@ApiModelProperty(value = "问题类型(0基础问题1任务问题2支付问题3优惠券问题)",name = "type",dataType = "Integer")
    private Integer type;

    /**
     * 反馈内容
     */
	@NotEmpty(message = "反馈内容不能为空")
	@ApiModelProperty(value = "反馈内容",name = "content",dataType = "String")
	private String content;

	/**
	 * 用户id
	 */
	@NotNull(message = "用户id不能为空")
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "long")
	private Long userId;
	/**
	 * 0未反馈，1已反馈
	 */
	@ApiModelProperty(value = "0未反馈，1已反馈",name = "isFeedback",dataType = "Integer")
	private Integer isFeedback=0;

}