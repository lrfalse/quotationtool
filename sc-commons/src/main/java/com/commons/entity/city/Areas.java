package com.commons.entity.city;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

@Data
@ApiModel
@Table(name="t_areas")
public class Areas {

    @ApiModelProperty(value = "主键", dataType = "long")
    private Long id;

    @ApiModelProperty(value = "城市id", dataType = "long")
    private Long cityid;

    @ApiModelProperty(value = "城市code", dataType = "string")
    private String code;

    @ApiModelProperty(value = "城市名称", dataType = "string")
    private String name;

    @ApiModelProperty(value = "是否可用（0可用，1不可用）", dataType = "int")
    private Integer isvalid;

}