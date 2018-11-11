package com.applet.service;

import com.commons.dto.applet.AdvertDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Advert;

/**
  * @Description(功能描述): 广告
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 22:02
  **/
public interface AdvertService {

	ResultMessage saveAdvert(Advert advert);
	ResultMessage updateAdvert(Advert advert);
	ResultMessage findAdverts(AdvertDTO advertDTO);

}
