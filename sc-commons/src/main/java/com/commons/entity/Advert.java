package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 广告表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 16:50
  **/
@Data
@Table(name="t_advert")
public class Advert extends BaseEntity {

    /**
     * 标题
     */
	@ApiModelProperty(value = "标题",name = "title",dataType = "String")
    private String title;

    /**
     * 内容
     */
	@ApiModelProperty(value = "内容",name = "content",dataType = "String")
    private String content;

    /**
     * 图片地址
     */
	@ApiModelProperty(value = "图片地址",name = "imgUrl",dataType = "String")
    private String imgUrl;

    /**
     * 过期时间
     */
	@ApiModelProperty(value = "过期时间",name = "outTime",dataType = "String")
    private String outTime;

    /**
     * 状态(0正常，1失效)
     */
	@ApiModelProperty(value = "状态(0正常，1失效)",name = "status",dataType = "Integer")
    private Integer status;

    /**
     * 是否置顶(0置顶，1不置顶)
     */
	@ApiModelProperty(value = "是否置顶(0置顶，1不置顶)",name = "isTop",dataType = "Boolean")
    private Boolean isTop;


}