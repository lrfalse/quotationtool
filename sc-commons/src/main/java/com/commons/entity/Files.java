package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 文件表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 16:51
  **/
@Data
@Table(name="t_files")
public class Files extends BaseEntity {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文件类型(0图片，1语音)
     */
    private Integer type;

    /**
     * 地址
     */
    private String url;

    /**
     * 需求状态(0可用，1正常)
     */
    private Integer status;

    /**
     * 业务类型(0聊天，1评论)
     */
    private Integer businessType;


}