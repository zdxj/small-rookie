package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.ImageHystrix;
import com.zdxj.model.ImageEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/image", fallback = ImageHystrix.class)
public interface ImageFeignClient extends BaseFeignClient<ImageEntity>{

}