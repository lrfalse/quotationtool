package com.commons.dto.applet.feedback;

import com.commons.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @Description(功能描述): 反馈请求列表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:37
  **/
@Data
@ApiModel("反馈信息查询")
public class FeedbackListDTO extends PageDTO{

    /**
     * 问题类型（0基础问题1任务问题2支付问题3优惠券问题）
     */
	@ApiModelProperty(value = "问题类型(0基础问题1任务问题2支付问题3优惠券问题)",name = "type",dataType = "Integer")
    private Integer type;

	/**
	 * 0未反馈，1已反馈
	 */
	@ApiModelProperty(value = "0未反馈，1已反馈",name = "isFeedback",dataType = "Integer")
	private Integer isFeedback=0;

}