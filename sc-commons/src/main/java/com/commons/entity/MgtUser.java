package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "mgt_user")
@ApiModel
@Data
public class MgtUser extends BaseEntity {

    /**
     * 账号
     */
    private String username;

    /**
     * 用户名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;


    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 部门ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 账户类型（1超管，0普通）
     */
    private Integer type;


    @Transient
    private String token;
    private String deptName;

    private String jobName;


}