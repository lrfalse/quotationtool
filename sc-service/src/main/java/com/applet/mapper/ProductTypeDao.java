package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.ProductTypeDTO;
import com.commons.entity.ProductType;

import java.util.List;

public interface ProductTypeDao extends MyMapper<ProductType>{

	List<ProductType> findProductTypes(ProductTypeDTO productTypeDTO);

}