package com.commons.entity;

import com.commons.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
  * @Description(功能描述): 用户表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:22
  **/
@Data
@ApiModel
@Table(name="t_user")
public class User extends BaseEntity {
    /**
     * open_id
     */
	@ApiModelProperty(value = "open_id",name = "String",dataType = "openId")
    private String openId;

    /**
     * union_id
     */
	@ApiModelProperty(value = "union_id",name = "unionId",dataType = "String")
    private String unionId;

    /**
     * 用户昵称
     */
	@ApiModelProperty(value = "用户昵称",name = "nickName",dataType = "String")
    private String nickName;

    /**
     * 密码
     */
	@ApiModelProperty(value = "密码",name = "passwd",dataType = "String")
    private String passwd;

    /**
     * 支付密码
     */
	@ApiModelProperty(value = "支付密码",name = "payPasswd",dataType = "String")
    private String payPasswd;

    /**
     * 最后一个数值代表正方形头像大小
     */
	@ApiModelProperty(value = "最后一个数值代表正方形头像大小",name = "avatarUrl",dataType = "String")
    private String avatarUrl;

    /**
     * 0未知，1男，2女
     */
	@ApiModelProperty(value = "0未知，1男，2女",name = "gender",dataType = "Integer")
    private Integer gender;

    /**
     * 城市
     */
	@ApiModelProperty(value = "城市",name = "city",dataType = "String")
    private String city;

    /**
     * 省份
     */
	@ApiModelProperty(value = "省份",name = "province",dataType = "String")
    private String province;

    /**
     * 国家
     */
	@ApiModelProperty(value = "国家",name = "country",dataType = "String")
    private String country;

    /**
     * 0报价员 1供应商
     */
	@ApiModelProperty(value = "0报价员 1供应商",name = "defRole",dataType = "Integer")
    private Integer defRole;

    /**
     * 详细地址
     */
	@ApiModelProperty(value = "详细地址",name = "address",dataType = "String")
    private String address;

    /**
     * 加密key
     */
	@ApiModelProperty(value = "加密key",name = "sessionKey",dataType = "String")
    private String sessionKey;

    /**
     * 电话
     */
	@ApiModelProperty(value = "电话",name = "phone",dataType = "String")
    private String phone;

    /**
     * 邀请码
     */
	@ApiModelProperty(value = "邀请码",name = "inviteCode",dataType = "String")
    private String inviteCode;

    /**
     * 0在线 ，1不在线
     */
	@ApiModelProperty(value = "0在线 ，1不在线",name = "isOnline",dataType = "Integer")
    private Integer isOnline;

    /**
     * 状态(0正常，1不可用)
     */
	@ApiModelProperty(value = "状态(0正常，1不可用)",hidden = true,name = "status",dataType = "Integer")
    private Integer status;

}