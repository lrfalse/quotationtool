package com.applet.service;

import com.commons.dto.applet.DemandDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Demand;

/**
  * @Description(功能描述): 收费标准
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 21:40
  **/
public interface DemandService {

	ResultMessage saveDemand(Demand demand);
	ResultMessage findDemands(DemandDTO demandDTO);
}