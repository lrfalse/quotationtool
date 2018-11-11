package com.applet.service.impl;

import com.commons.dto.applet.AdvertDTO;
import com.commons.message.ResultMessage;
import com.applet.mapper.AdvertDao;
import com.commons.entity.Advert;
import com.applet.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertDao advertDao;


	@Override
	public ResultMessage saveAdvert(Advert advert) {
		return ResultMessage.build(advertDao.insert(advert));
	}

	@Override
	public ResultMessage updateAdvert(Advert advert) {
		return ResultMessage.build(advertDao.updateByPrimaryKeySelective(advert));
	}

	@Override
	public ResultMessage findAdverts(AdvertDTO advertDTO) {
		return ResultMessage.build(advertDao.findAdverts(advertDTO));
	}
}
