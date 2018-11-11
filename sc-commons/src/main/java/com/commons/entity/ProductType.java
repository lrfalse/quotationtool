package com.commons.entity;

import com.commons.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

/** 
  * @Description(功能描述): 产品类型
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 21:37
  **/
@Data
@Table(name="t_product_type")
public class ProductType extends BaseEntity {


    /**
     * 类型名称
     */
    private String name;

    /**
     * 单位（如个，包，袋等）
     */
    private String unit;

    /**
     * 备注
     */
    private String remark;

}