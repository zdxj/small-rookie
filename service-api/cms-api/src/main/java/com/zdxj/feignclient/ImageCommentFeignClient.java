package com.zdxj.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import com.zdxj.core.feignclient.BaseFeignClient;
import com.zdxj.hystrix.ImageCommentHystrix;
import com.zdxj.model.ImageCommentEntity;

@FeignClient(value = "gateway-server",path="/cmsApi/imageComment", fallback = ImageCommentHystrix.class)
public interface ImageCommentFeignClient extends BaseFeignClient<ImageCommentEntity>{

}