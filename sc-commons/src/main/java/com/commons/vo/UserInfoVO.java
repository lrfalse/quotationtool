package com.commons.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description(功能描述) : 用户对象
 * @author(作者) :lrfalse<wangliyou>
 * @date (开发日期) :2018/11/14 22:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UserInfoVO", description = "用户个人详细信息")
public class UserInfoVO {

	/**
	 * 用户昵称
	 */
	@ApiModelProperty(value = "用户昵称",name = "nickName",dataType = "String")
	private String nickName;
	/**
	 * 最后一个数值代表正方形头像大小
	 */
	@ApiModelProperty(value = "头像地址",name = "avatarUrl",dataType = "String")
	private String avatarUrl;
	/**
	 * 0未知，1男，2女
	 */
	@ApiModelProperty(value = "0未知，1男，2女",name = "gender",dataType = "Integer")
	private Integer gender;
	/**
	 * 详细地址
	 */
	@ApiModelProperty(value = "详细地址",name = "address",dataType = "String")
	private String address;
	/**
	 * 城市
	 */
	@ApiModelProperty(value = "城市",name = "city",dataType = "String")
	private String city;

	/**
	 * 省份
	 */
	@ApiModelProperty(value = "省份",name = "province",dataType = "String")
	private String province;

	/**
	 * 国家
	 */
	@ApiModelProperty(value = "国家",name = "country",dataType = "String")
	private String country;

}
