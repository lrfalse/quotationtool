package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/** 
  * @Description(功能描述): 收费标准
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/13 15:22
  **/
@Data
@ApiModel(value = "收费标准参数对象", description = "收费标准")
@Table(name="t_charge_standard")
public class ChargeStandard extends BaseEntity {

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
	private Long userId;

	/**
	 * 商品类型id
	 */
	@ApiModelProperty(value = "商品类型id",name = "typeId",dataType = "Long")
	private Long typeId;

	/**
	 * 单价
	 */
	@ApiModelProperty(value = " 单价",name = "unitPrice",dataType = "String")
	private String unitPrice;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注",name = "remark",dataType = "String")
	private String remark;


}