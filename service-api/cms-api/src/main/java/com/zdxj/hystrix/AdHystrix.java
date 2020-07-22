package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.AdFeignClient;
import com.zdxj.model.AdEntity;

@Component
public class AdHystrix extends BaseHystrix<AdEntity> implements AdFeignClient {

}
