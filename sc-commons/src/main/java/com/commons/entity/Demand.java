package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
  * @Description(功能描述): 任务信息表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 22:53
  **/
@Data
@Table(name="t_charge_standard")
public class Demand extends BaseEntity {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",required = true,name = "userId",dataType = "Long")
	private Long userId;

    /**
     * 类型id
     */
	@ApiModelProperty(value = "类型id",required = true,name = "typeId",dataType = "Long")
    private Long typeId;

    /**
     * 交单时间
     */
	@ApiModelProperty(value = "交单时间",required = true,name = "deliveryTime",dataType = "Date")
    private Date deliveryTime;

    /**
     * 提供素材(0想法，电子版，手写板)
     */
	@ApiModelProperty(value = "提供素材(0想法，电子版，手写板)",name = "material",dataType = "Integer")
    private Integer material;

    /**
     * 任务描述
     */
	@ApiModelProperty(value = "任务描述",required = true,name = "desciption",dataType = "String")
    private String desciption;

    /**
     * 需求状态(0等待接单，1已接单，2完成)
     */
	@ApiModelProperty(value = "需求状态(0等待接单，1已接单，2完成)",hidden = true,name = "status",dataType = "Integer")
    private Integer status;
}