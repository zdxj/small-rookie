package com.zdxj.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdxj.core.Result;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.RoleMenuRelFeignClient;
import com.zdxj.model.RoleMenuRelEntity;

@Component
public class RoleMenuRelHystrix extends BaseHystrix<RoleMenuRelEntity> implements RoleMenuRelFeignClient {

	/**
	 * 获取角色和权限的对应关系
	 * @author zhaodx
	 * @date 2020-07-20 18:13
	 * @return
	 */
	@Override
	public Result<Map<String, List<String>>> listRoleMenu() {
		return Result.failed("dddddddddddddddddddddddddd");
	}

}
