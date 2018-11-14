package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.PartnersDTO;
import com.commons.entity.Partners;

import java.util.List;

/**
  * @Description(功能描述): 我的合作商（收藏）
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/11/14 23:20
  **/
public interface PartnersDao extends MyMapper<Partners>{

	List<Partners> findPartnerss(PartnersDTO partnersDTO);

}