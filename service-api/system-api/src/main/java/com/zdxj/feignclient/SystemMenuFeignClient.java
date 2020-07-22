package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.SystemMenuHystrix;
import com.zdxj.model.SystemMenuEntity;

@FeignClient(value = "gateway-server",path="/systemApi/systemMenu", fallback = SystemMenuHystrix.class)
public interface SystemMenuFeignClient extends BaseFeignClient<SystemMenuEntity>{

}