package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
  * @Description(功能描述): 订单
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/13 15:15
  **/
@Data
@Table(name="t_order")
public class Order extends BaseEntity {
    /**
     * 用户id
     */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
    private Long userId;

    /**
     * 需求id
     */
	@ApiModelProperty(value = "需求id",name = "demandId",dataType = "Long")
    private Long demandId;

    /**
     * 交单时间
     */
	@ApiModelProperty(value = "交单时间",name = "deliveryTime",dataType = "Date")
    private Date deliveryTime;

    /**
     * 订单状态(0已完成，1处理中，2未完成，3已取消,4待评价)
     */
	@ApiModelProperty(value = "订单状态(0已完成，1处理中，2未完成，3已取消,4待评价)",name = "status",dataType = "Integer")
    private Integer status;
	/**
	 * 报价
	 */
	@ApiModelProperty(value = "报价",name = "money",dataType = "String")
	private String money;


}