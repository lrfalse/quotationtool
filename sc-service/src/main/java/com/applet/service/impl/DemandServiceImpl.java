package com.applet.service.impl;


import com.commons.dto.applet.DemandDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Demand;
import com.applet.mapper.DemandDao;
import com.applet.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService {

	@Autowired
	private DemandDao demandDao;


	@Override
	public ResultMessage saveDemand(Demand demand) {
		return ResultMessage.build(demandDao.insert(demand));
	}

	@Override
	public ResultMessage findDemands(DemandDTO demandDTO) {
		return ResultMessage.build(demandDao.findDemands(demandDTO));
	}
}