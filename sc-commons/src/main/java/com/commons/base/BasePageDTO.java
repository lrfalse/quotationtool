package com.commons.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description(功能描述):
 * @author(作者): panpengfei
 * @email panpf@talust.org
 * @date(开发日期): 2018/8/7 20:11
 **/
@ApiModel
@Data
public class BasePageDTO {
    @ApiModelProperty(value = "页码",name = "pageNum",dataType = "int",required = true)
    @NotNull
    private Integer pageNum;

    @ApiModelProperty(value = "条数",name = "pageSize",dataType = "int",required = true)
    @NotNull
    private Integer pageSize;
}
