package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.SystemCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.SystemMenuMapper;
import com.zdxj.model.SystemMenuEntity;
import com.zdxj.service.SystemMenuService;

@Service
@Transactional
public class SystemMenuServiceImpl extends BaseServiceImpl<SystemMenuMapper,SystemMenuEntity> implements SystemMenuService {

	public SystemMenuServiceImpl() {
		super(SystemCacheConstant.SYSTEM_MENU);
	}
}