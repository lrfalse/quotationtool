package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 评论表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 16:51
  **/
@Data
@Table(name="t_comments")
public class Comments extends BaseEntity {

    /**
     * 评论人id
     */
    private Long commentsId;

    /**
     * 需求id
     */
    private Long demandId;

    /**
     * 评论状态(0显示，1不显示)
     */
    private Integer status;

}