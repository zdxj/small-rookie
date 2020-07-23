package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import com.zdxj.hystrix.AdHystrix;

@FeignClient(value = "gateway-server",path="/cmsV1/ad", fallback = AdHystrix.class)
public interface ApiAdFeignClient{

}