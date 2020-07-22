package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.DepartmentFeignClient;
import com.zdxj.model.DepartmentEntity;

@Component
public class DepartmentHystrix extends BaseHystrix<DepartmentEntity> implements DepartmentFeignClient {

}
