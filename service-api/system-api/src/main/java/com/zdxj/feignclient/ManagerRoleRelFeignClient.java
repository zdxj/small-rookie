package com.zdxj.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdxj.core.Result;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.ManagerRoleRelHystrix;
import com.zdxj.model.ManagerRoleRelEntity;

@FeignClient(value = "gateway-server",path="/systemApi/managerRoleRel", fallback = ManagerRoleRelHystrix.class)
public interface ManagerRoleRelFeignClient extends BaseFeignClient<ManagerRoleRelEntity>{

	/**
	 * 获取管理员角色ID
	 * @author zhaodx
	 * @date 2020-07-17 17:43
	 * @param id
	 * @return
	 */
	@GetMapping("listRoleIdByManagerId")
    Result<List<Integer>> listRoleIdByManagerId(@RequestParam("id") Integer managerId);
}