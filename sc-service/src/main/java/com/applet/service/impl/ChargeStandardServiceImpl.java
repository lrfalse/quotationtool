package com.applet.service.impl;


import com.commons.dto.applet.chargeStandard.ChargeStandardDTO;
import com.commons.message.ResultMessage;
import com.applet.mapper.ChargeStandardDao;
import com.applet.service.ChargeStandardService;
import com.commons.entity.ChargeStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeStandardServiceImpl implements ChargeStandardService {

	@Autowired
	private ChargeStandardDao chargeStandardDao;

	@Override
	public ResultMessage saveChargeStandard(ChargeStandard chargeStandard) {
		return ResultMessage.build(chargeStandardDao.insert(chargeStandard));
	}

	@Override
	public ResultMessage findChargeStandards(ChargeStandardDTO chargeStandardDTO) {
		return ResultMessage.build(chargeStandardDao.findChargeStandards(chargeStandardDTO));
	}
}