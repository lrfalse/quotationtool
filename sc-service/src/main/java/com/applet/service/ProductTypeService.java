package com.applet.service;

import com.commons.dto.applet.ProductTypeDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.ProductType;

/**
  * @Description(功能描述): 产品类型
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/14 22:02
  **/
public interface ProductTypeService {

	ResultMessage saveProductType(ProductType productType);
	ResultMessage findProductType(ProductTypeDTO productTypeDTO);

}
