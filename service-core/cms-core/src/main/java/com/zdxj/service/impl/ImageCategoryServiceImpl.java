package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.ImageCategoryMapper;
import com.zdxj.model.ImageCategoryEntity;
import com.zdxj.service.ImageCategoryService;

@Service
@Transactional
public class ImageCategoryServiceImpl extends BaseServiceImpl<ImageCategoryMapper,ImageCategoryEntity> implements ImageCategoryService {

	public ImageCategoryServiceImpl() {
		super(CmsCacheConstant.IMAGE_CATEGORY);
	}
}