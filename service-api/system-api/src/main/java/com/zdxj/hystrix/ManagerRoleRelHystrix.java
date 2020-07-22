package com.zdxj.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zdxj.core.Result;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.ManagerRoleRelFeignClient;
import com.zdxj.model.ManagerRoleRelEntity;

@Component
public class ManagerRoleRelHystrix extends BaseHystrix<ManagerRoleRelEntity> implements ManagerRoleRelFeignClient {

	/**
	 * 获取管理员角色ID
	 * @author zhaodx
	 * @date 2020-07-17 17:43
	 * @param id
	 * @return
	 */
	@Override
	public Result<List<Integer>> listRoleIdByManagerId(Integer managerId) {
		return Result.failed();
	}

}
