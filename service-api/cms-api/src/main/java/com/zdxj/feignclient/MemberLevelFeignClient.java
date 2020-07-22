package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.MemberLevelHystrix;
import com.zdxj.model.MemberLevelEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/memberLevel", fallback = MemberLevelHystrix.class)
public interface MemberLevelFeignClient extends BaseFeignClient<MemberLevelEntity>{

}