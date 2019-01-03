package com.commons.dto.applet;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description(功能描述) :产品类型
 * @author(作者) :lrfalse<wangliyou>
 * @date (开发日期) :2018/10/14 22:01
 **/
@Data
public class ProductTypeAddDTO {
	/**
	 * 类型名称
	 */
	@ApiModelProperty(value = "类型名称",name = "name",dataType = "String")
	private String name;

	/**
	 * 单位（如个，包，袋等）
	 */
	@ApiModelProperty(value = "单位（如个，包，袋等）",name = "unit",dataType = "String")
	private String unit;
	@ApiModelProperty(value = "备注",name = "remark",dataType = "String")
	private String remark;
}
