package com.commons.dto.applet;

import com.commons.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @Description(功能描述) :广告信息
 * @author(作者) :lrfalse<wangliyou>
 * @date (开发日期) :2018/10/20 12:17
 **/
@Data
public class PartnersDTO extends PageDTO {
	@Id
	private Long id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
	private Long userId;

	/**
	 * 合作商id
	 */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
	private Long partnersId;

	/**
	 * 需求状态(0关注，1取消关注)
	 */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
	private Integer status;
	@ApiModelProperty(value = "创建时间",name = "createTime",dataType = "String")
	private  String createTime;
}
