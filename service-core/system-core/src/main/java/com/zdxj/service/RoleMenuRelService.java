package com.zdxj.service;

import java.util.List;
import java.util.Map;

import com.zdxj.core.service.BaseService;
import com.zdxj.model.RoleMenuRelEntity;

public interface RoleMenuRelService extends BaseService<RoleMenuRelEntity>{

	/**
	 * 获取角色和权限的对应关系
	 * @author zhaodx
	 * @date 2020-07-20 18:13
	 * @return
	 */
	Map<String, List<String>> listRoleMenu();
}
	