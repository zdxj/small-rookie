package com.zdxj.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.zdxj.constant.SystemCacheConstant;
import com.zdxj.core.service.impl.BaseServiceImpl;
import com.zdxj.mapper.SystemManagerMapper;
import com.zdxj.model.SystemManagerEntity;
import com.zdxj.service.SystemManagerService;

@Service
@Transactional
public class SystemManagerServiceImpl extends BaseServiceImpl<SystemManagerMapper,SystemManagerEntity> implements SystemManagerService {

	public SystemManagerServiceImpl() {
		super(SystemCacheConstant.SYSTEM_MANAGER);
	}

	/**
	 * 根据用户名获取管理员
	 * @author zhaodx
	 * @date 2020-07-16 18:42
	 * @param loginName
	 * @return
	 */
	@Override
	public SystemManagerEntity getByLoginName(String loginName) {
		Map<String,Object> maps = Maps.newHashMap();
		maps.put("loginName", loginName);
		List<SystemManagerEntity> list = this.listByConditionWithPage(maps, 0, 1);
		if(CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}