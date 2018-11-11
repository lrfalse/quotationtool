package com.commons.entity.city;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

@Data
@ApiModel
@Table(name="t_provinces")
public class Provinces {
    @ApiModelProperty(value = "主键",dataType = "long")
    private Long id;

    @ApiModelProperty(value = "国家id",dataType = "long")
    private Long countrysid;

    @ApiModelProperty(value = "省份编码",dataType = "string")
    private String code;

    @ApiModelProperty(value = "省份名称",dataType = "string")
    private String name;

    @ApiModelProperty(value = "是否可用",dataType = "int")
    private Integer isvalid;

}