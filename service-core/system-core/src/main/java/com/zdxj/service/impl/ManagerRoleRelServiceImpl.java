package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.SystemCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.ManagerRoleRelMapper;
import com.zdxj.model.ManagerRoleRelEntity;
import com.zdxj.service.ManagerRoleRelService;

@Service
@Transactional
public class ManagerRoleRelServiceImpl extends BaseServiceImpl<ManagerRoleRelMapper,ManagerRoleRelEntity> implements ManagerRoleRelService {

	public ManagerRoleRelServiceImpl() {
		super(SystemCacheConstant.MANAGER_ROLE_REL);
	}
}