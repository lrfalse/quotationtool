package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.DemandDTO;
import com.commons.entity.Demand;

import java.util.List;

public interface DemandDao extends MyMapper<Demand>{

	List<Demand> findDemands(DemandDTO demandDTO);

}