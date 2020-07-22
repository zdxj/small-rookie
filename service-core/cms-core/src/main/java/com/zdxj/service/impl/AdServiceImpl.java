package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.AdMapper;
import com.zdxj.model.AdEntity;
import com.zdxj.service.AdService;

@Service
@Transactional
public class AdServiceImpl extends BaseServiceImpl<AdMapper,AdEntity> implements AdService {

	public AdServiceImpl() {
		super(CmsCacheConstant.AD);
	}
}