package com.commons.dto.applet.chargeStandard;

import com.commons.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 
  * @Description(功能描述): 收费标准
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/13 15:22
  **/
@Data
@ApiModel("收费标准")
public class ChargeStandardDTO extends PageDTO{

    /**
     * 用户id
     */
	@ApiModelProperty(value = "用户id",name = "unit",dataType = "Long")
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