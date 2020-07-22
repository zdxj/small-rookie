package com.zdxj.feignclient;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zdxj.core.Result;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.RoleMenuRelHystrix;
import com.zdxj.model.RoleMenuRelEntity;

@FeignClient(value = "gateway-server",path="/systemApi/roleMenuRel", fallback = RoleMenuRelHystrix.class)
public interface RoleMenuRelFeignClient extends BaseFeignClient<RoleMenuRelEntity>{

	/**
	 * 获取角色和权限的对应关系
	 * @author zhaodx
	 * @date 2020-07-20 18:13
	 * @return
	 */
	@GetMapping("listRoleMenu")
    Result<Map<String, List<String>>> listRoleMenu();
}