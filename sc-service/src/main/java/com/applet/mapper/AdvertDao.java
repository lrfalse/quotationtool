package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.AdvertDTO;
import com.commons.entity.Advert;

import java.util.List;

public interface AdvertDao extends MyMapper<Advert>{

	List<Advert> findAdverts(AdvertDTO advertDTO);

}