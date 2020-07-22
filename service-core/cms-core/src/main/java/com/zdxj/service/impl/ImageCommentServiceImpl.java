package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.ImageCommentMapper;
import com.zdxj.model.ImageCommentEntity;
import com.zdxj.service.ImageCommentService;

@Service
@Transactional
public class ImageCommentServiceImpl extends BaseServiceImpl<ImageCommentMapper,ImageCommentEntity> implements ImageCommentService {

	public ImageCommentServiceImpl() {
		super(CmsCacheConstant.IMAGE_COMMENT);
	}
}