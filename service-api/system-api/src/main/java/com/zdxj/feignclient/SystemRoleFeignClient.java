package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.SystemRoleHystrix;
import com.zdxj.model.SystemRoleEntity;

@FeignClient(value = "gateway-server",path="/systemApi/systemRole", fallback = SystemRoleHystrix.class)
public interface SystemRoleFeignClient extends BaseFeignClient<SystemRoleEntity>{

}