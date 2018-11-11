package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 账户表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 16:48
  **/
@Data
@Table(name="t_account")
public class Account extends BaseEntity {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 账户余额(分)
     */
    private String balance;

    /**
     * 状态(0正常，1冻结)
     */
    private String status;


}