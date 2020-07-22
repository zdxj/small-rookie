package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.ImageCategoryHystrix;
import com.zdxj.model.ImageCategoryEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/imageCategory", fallback = ImageCategoryHystrix.class)
public interface ImageCategoryFeignClient extends BaseFeignClient<ImageCategoryEntity>{

}