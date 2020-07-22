package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.MemberLevelMapper;
import com.zdxj.model.MemberLevelEntity;
import com.zdxj.service.MemberLevelService;

@Service
@Transactional
public class MemberLevelServiceImpl extends BaseServiceImpl<MemberLevelMapper,MemberLevelEntity> implements MemberLevelService {

	public MemberLevelServiceImpl() {
		super(CmsCacheConstant.MEMBER_LEVEL);
	}
}