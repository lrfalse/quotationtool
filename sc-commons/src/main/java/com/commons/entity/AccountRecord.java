package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 账户记录表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 16:49
  **/
@Data
@Table(name="t_account_record")
public class AccountRecord extends BaseEntity {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 账户余额(分)
     */
    private String balance;

    /**
     * 消费金额（进账+，出账-）
     */
    private String money;

    /**
     * 消费标题
     */
    private String title;


}