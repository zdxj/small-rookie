package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.SystemMenuFeignClient;
import com.zdxj.model.SystemMenuEntity;

@Component
public class SystemMenuHystrix extends BaseHystrix<SystemMenuEntity> implements SystemMenuFeignClient {

}
