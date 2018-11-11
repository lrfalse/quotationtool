package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.PartnersDTO;
import com.commons.entity.Partners;

import java.util.List;

public interface PartnersDao extends MyMapper<Partners>{

	List<Partners> findPartnerss(PartnersDTO partnersDTO);

}