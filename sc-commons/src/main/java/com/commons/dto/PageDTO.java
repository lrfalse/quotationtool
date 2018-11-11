package com.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @notes: 分页参数 数据传输对象
 * @author: At
 * @date: 2018/4/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageDTO  {

    /**
     * 页码
     */
    @ApiModelProperty(name = "pageNum",value = "页码", required = true,dataType = "int")
    @Builder.Default
    private int pageNum = 1;

    /**
     * 页大小
     */
    @ApiModelProperty(name = "pageSize",value = "页大小，默认20",dataType = "int")
    @Builder.Default
    private int pageSize = 20;

    /**
     * 排序规则 desc asc
     */
    @ApiModelProperty(name = "order",value = "排序规则 desc asc", dataType = "String")
    private String order;

    /**
     * 排序字段
     */
    @ApiModelProperty(name = "orderBy",value = "排序字段", dataType = "String")
    private String orderBy;

    /**
     * 关键字搜索 单个
     */
    @ApiModelProperty(name = "searchStr",value = "关键字搜索", dataType = "String")
    private String searchStr;
}
