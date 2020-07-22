package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.MemberHystrix;
import com.zdxj.model.MemberEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/member", fallback = MemberHystrix.class)
public interface MemberFeignClient extends BaseFeignClient<MemberEntity>{

}