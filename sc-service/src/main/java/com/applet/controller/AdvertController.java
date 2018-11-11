package com.applet.controller;

import com.commons.dto.applet.AdvertDTO;
import com.commons.message.ResponseMessage;
import com.commons.entity.Advert;
import com.github.pagehelper.PageHelper;
import com.applet.service.AdvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description(功能描述) : 广告信息
 * @author(作者) :lrfalse<wangliyou>
 * @date (开发日期) :2018/10/20 12:15
 **/
@RestController
@RequestMapping("advert")
@Api(tags ="广告")
public class AdvertController {
	@Autowired
	private AdvertService advertService;

	@ApiOperation(value = "新增广告信息")
	@PatchMapping(value = "/addAdvert")
	public ResponseMessage addAdvert(@Valid Advert advert) {
		return ResponseMessage.result(advertService.saveAdvert(advert));
	}
	@ApiOperation(value = "修改广告信息")
	@PostMapping(value = "/updateAdvert")
	public ResponseMessage updateAdvert(@Valid Advert advert) {
		return ResponseMessage.result(advertService.updateAdvert(advert));
	}
	@ApiOperation(value = "广告列表信息")
	@GetMapping(value = "/findAdverts")
	public ResponseMessage findAdverts(AdvertDTO advertDTO) {
		PageHelper.startPage(advertDTO.getPageNum(),advertDTO.getPageSize());
		return ResponseMessage.result(advertService.findAdverts(advertDTO));
	}
}
