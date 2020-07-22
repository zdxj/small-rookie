package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.AdHystrix;
import com.zdxj.model.AdEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/ad", fallback = AdHystrix.class)
public interface AdFeignClient extends BaseFeignClient<AdEntity>{

}