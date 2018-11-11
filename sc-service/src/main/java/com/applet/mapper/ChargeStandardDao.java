package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.chargeStandard.ChargeStandardDTO;
import com.commons.entity.ChargeStandard;

import java.util.List;

public interface ChargeStandardDao extends MyMapper<ChargeStandard>{

	List<ChargeStandard> findChargeStandards(ChargeStandardDTO chargeStandardDTO);

}