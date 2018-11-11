package com.applet.service.impl;

import com.commons.dto.applet.PartnersDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Partners;
import com.applet.mapper.PartnersDao;
import com.applet.service.PartnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnersServiceImpl implements PartnersService {

	@Autowired
	private PartnersDao partnersDao;


	@Override
	public ResultMessage savePartners(Partners Partners) {
		return ResultMessage.build(partnersDao.insert(Partners));
	}

	@Override
	public ResultMessage updatePartners(Partners Partners) {
		return ResultMessage.build(partnersDao.updateByPrimaryKeySelective(Partners));
	}

	@Override
	public ResultMessage findPartnerss(PartnersDTO PartnersDTO) {
		return ResultMessage.build(partnersDao.findPartnerss(PartnersDTO));
	}
}
