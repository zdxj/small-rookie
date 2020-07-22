package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.SystemCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.SystemRoleMapper;
import com.zdxj.model.SystemRoleEntity;
import com.zdxj.service.SystemRoleService;

@Service
@Transactional
public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRoleMapper,SystemRoleEntity> implements SystemRoleService {

	public SystemRoleServiceImpl() {
		super(SystemCacheConstant.SYSTEM_ROLE);
	}
}