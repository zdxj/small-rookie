package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.CmsCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.MemberMapper;
import com.zdxj.model.MemberEntity;
import com.zdxj.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper,MemberEntity> implements MemberService {

	public MemberServiceImpl() {
		super(CmsCacheConstant.MEMBER);
	}
}