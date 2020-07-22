package com.zdxj.service;

import com.zdxj.core.service.BaseService;
import com.zdxj.model.SystemManagerEntity;

public interface SystemManagerService extends BaseService<SystemManagerEntity>{

	/**
	 * 根据用户名获取管理员
	 * @author zhaodx
	 * @date 2020-07-16 18:42
	 * @param loginName
	 * @return
	 */
	SystemManagerEntity getByLoginName(String loginName);
}
	