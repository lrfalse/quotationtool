package com.applet.service.impl;

import com.commons.dto.applet.ProductTypeDTO;
import com.commons.message.ResultMessage;
import com.applet.service.ProductTypeService;
import com.commons.entity.ProductType;
import com.applet.mapper.ProductTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;


	@Override
	public ResultMessage saveProductType(ProductType productType) {
		return ResultMessage.build(productTypeDao.insert(productType));
	}

	@Override
	public ResultMessage findProductType(ProductTypeDTO productTypeDTO) {
		return ResultMessage.build(productTypeDao.findProductTypes(productTypeDTO));
	}
}
