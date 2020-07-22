package com.zdxj.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdxj.constant.SystemCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.DepartmentMapper;
import com.zdxj.model.DepartmentEntity;
import com.zdxj.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentMapper,DepartmentEntity> implements DepartmentService {

	public DepartmentServiceImpl() {
		super(SystemCacheConstant.DEPARTMENT);
	}
}