package com.applet.controller;

import com.commons.dto.applet.PartnersDTO;
import com.commons.message.ResponseMessage;
import com.commons.entity.Partners;
import com.commons.vo.UserInfoVO;
import com.github.pagehelper.PageHelper;
import com.applet.service.PartnersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description(功能描述) : 我的收藏合作商
 * @author(作者) :lrfalse<wangliyou>
 * @date (开发日期) :2018/10/20 12:15
 **/
@RestController
@RequestMapping("partners")
@Api(tags ="我的合作商")
public class PartnersController {
	@Autowired
	private PartnersService partnersService;

	@ApiOperation(value = "收藏合作商")
	@PatchMapping(value = "/addPartners")
	public ResponseMessage addPartners(@Valid Partners partners) {
		return ResponseMessage.result(partnersService.savePartners(partners));
	}
	@ApiOperation(value = "取消合作商收藏")
	@PostMapping(value = "/updatePartners")
	public ResponseMessage updatePartners(@Valid Partners partners) {
		return ResponseMessage.result(partnersService.updatePartners(partners));
	}
	@ApiOperation(value = "我的合作商列表",response = Partners.class)
	@GetMapping(value = "/findPartners")
	public ResponseMessage findPartners(PartnersDTO partnersDTO) {
		PageHelper.startPage(partnersDTO.getPageNum(),partnersDTO.getPageSize());
		return ResponseMessage.result(partnersService.findPartnerss(partnersDTO));
	}
}
