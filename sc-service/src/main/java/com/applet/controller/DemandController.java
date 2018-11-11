package com.applet.controller;

import com.commons.dto.applet.DemandDTO;
import com.commons.message.ResponseMessage;
import com.applet.service.DemandService;
import com.commons.entity.Demand;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
  * @Description(功能描述): 发布任务
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 22:56
  **/
@RestController
@RequestMapping("demand")
@Api(tags ="需求任务信息")
public class DemandController {
	@Autowired
	private DemandService demandServicel;

	@ApiOperation(value = "发布需求任务")
	@ResponseBody
	@PatchMapping(value = "/addDemand")
	public ResponseMessage addDemand(@Valid Demand demand) {
		return ResponseMessage.result(demandServicel.saveDemand(demand));
	}
	@ApiOperation(value = "需求任务列表")
	@ResponseBody
	@GetMapping(value = "/findDemands")
	public ResponseMessage findDemands(DemandDTO demandDTO) {
		PageHelper.startPage(demandDTO.getPageNum(),demandDTO.getPageSize());
		return ResponseMessage.result(demandServicel.findDemands(demandDTO));
	}
}
