package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdxj.core.Result;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.SystemManagerHystrix;
import com.zdxj.model.SystemManagerEntity;

@FeignClient(value = "gateway-server",path="/systemApi/systemManager", fallback = SystemManagerHystrix.class)
public interface SystemManagerFeignClient extends BaseFeignClient<SystemManagerEntity>{

	/**
	 * 根据用户名获取管理员
	 * @author zhaodx
	 * @date 2020-07-16 18:42
	 * @param loginName
	 * @return
	 */
	@GetMapping("getByLoginName")
    Result<SystemManagerEntity> getByLoginName(@RequestParam("loginName") String loginName);
}