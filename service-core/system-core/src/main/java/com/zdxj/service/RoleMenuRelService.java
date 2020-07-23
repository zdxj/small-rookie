package com.zdxj.service;

import com.zdxj.core.Result;
import com.zdxj.core.service.BaseService;
import com.zdxj.model.RoleMenuRelEntity;

public interface RoleMenuRelService extends BaseService<RoleMenuRelEntity>{

	/**
	 * 初始化角色和权限的对应关系
	 * @author zhaodx
	 * @date 2020-07-20 18:13
	 * @return
	 */
	Result<Object> initRoleMenuRel(boolean isReload);
}
	