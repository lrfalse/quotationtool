package com.applet.service;

import com.commons.dto.applet.PartnersDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Partners;

/**
  * @Description(功能描述): 合作商
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/20 22:46
  **/
public interface PartnersService {

	ResultMessage savePartners(Partners prtners);
	ResultMessage updatePartners(Partners prtners);
	ResultMessage findPartnerss(PartnersDTO prtnersDTO);

}
