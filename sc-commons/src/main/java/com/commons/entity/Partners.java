package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 我的合作商（收藏）
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/20 22:42
  **/
@Data
@ApiModel(value = "Partners", description = "我的收藏")
@Table(name="t_partners")
public class Partners  extends BaseEntity {

    /**
     * 用户id
     */
	@ApiModelProperty(value = "用户id",name = "userId",dataType = "Long")
    private Long userId;

    /**
     * 合作商id
     */
	@ApiModelProperty(value = "合作商id",name = "partnersId",dataType = "Long")
    private Long partnersId;

    /**
     * 需求状态(0关注，1取消关注)
     */
	@ApiModelProperty(value = "需求状态(0关注，1取消关注)",name = "status",dataType = "Long")
    private Integer status;


}