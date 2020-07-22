package com.zdxj.hystrix;

import org.springframework.stereotype.Component;

import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.SystemRoleFeignClient;
import com.zdxj.model.SystemRoleEntity;

@Component
public class SystemRoleHystrix extends BaseHystrix<SystemRoleEntity> implements SystemRoleFeignClient {

}
