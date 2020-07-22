package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.DepartmentHystrix;
import com.zdxj.model.DepartmentEntity;

@FeignClient(value = "gateway-server",path="/systemApi/department", fallback = DepartmentHystrix.class)
public interface DepartmentFeignClient extends BaseFeignClient<DepartmentEntity>{

}