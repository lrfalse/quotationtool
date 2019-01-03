package com.applet.controller;

import com.commons.dto.applet.ProductTypeAddDTO;
import com.commons.dto.applet.ProductTypeDTO;
import com.commons.dto.applet.chargeStandard.ChargeStandardDTO;
import com.commons.message.ResponseMessage;
import com.applet.service.ChargeStandardService;
import com.applet.service.ProductTypeService;
import com.commons.entity.ChargeStandard;
import com.commons.entity.ProductType;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
  * @Description(功能描述): 收费标准
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 21:50
  **/
@RestController
@RequestMapping("chargeStandard")
@Api(tags ="收费标准")
public class ChargeStandardController {
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ChargeStandardService chargeStandardService;

	@ApiOperation(value = "新增收费标准",response =ChargeStandard.class )
	@ResponseBody
	@PatchMapping(value = "/addChargeStandard")
	public ResponseMessage addChargeStandard(@Valid  ChargeStandard chargeStandard) {
		return ResponseMessage.result(chargeStandardService.saveChargeStandard(chargeStandard));
	}
	@ApiOperation(value = "产品收费列表" ,response = ChargeStandard.class)
	@ResponseBody
	@GetMapping(value = "/findChargeStandards")
	public ResponseMessage findChargeStandards(ChargeStandardDTO chargeStandardDTO) {
		PageHelper.startPage(chargeStandardDTO.getPageNum(),chargeStandardDTO.getPageSize());
		return ResponseMessage.result(chargeStandardService.findChargeStandards(chargeStandardDTO));
	}


	@ApiOperation(value = "产品类型列表" ,response = ProductType.class)
	@ResponseBody
	@GetMapping(value = "/findProductTypes")
	public ResponseMessage findProductTypes(ProductTypeDTO productTypeDTO) {
		PageHelper.startPage(productTypeDTO.getPageNum(),productTypeDTO.getPageSize());
		return ResponseMessage.result(productTypeService.findProductType(productTypeDTO));
	}

	@ApiOperation(value = "新增产品类型")
	@ResponseBody
	@GetMapping(value = "/addProductTypes")
	public ResponseMessage addProductTypes(ProductTypeAddDTO productTypeDTO) {
		ProductType productType=new ProductType();
		BeanUtils.copyProperties(productTypeDTO,productType);
		//System.out.println(ResponseMessage.result(productTypeService.saveProductType(productType)));
		return ResponseMessage.result(productTypeService.saveProductType(productType));
	}
}
