package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.ImageMapper;
import com.zdxj.model.ImageEntity;
import com.zdxj.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl extends BaseServiceImpl<ImageMapper,ImageEntity> implements ImageService {

	public ImageServiceImpl() {
		super(CmsCacheConstant.IMAGE);
	}
}