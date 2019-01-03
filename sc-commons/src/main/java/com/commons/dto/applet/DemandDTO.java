package com.commons.dto.applet;

import com.commons.dto.PageDTO;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
  * @Description(功能描述): 任务信息表
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 22:53
  **/
@Data
public class DemandDTO extends PageDTO{

	@Id
	private Long id;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 类型id
     */
    private Long typeId;

    /**
     * 交单时间
     */
    private Date deliveryTime;

    /**
     * 提供素材(0想法，电子版，手写板)
     */
    private Integer material;

    /**
     * 任务描述
     */
    private String desciption;

    /**
     * 需求状态(0等待接单，1已接单，2完成)
     */
    private Integer status;
}