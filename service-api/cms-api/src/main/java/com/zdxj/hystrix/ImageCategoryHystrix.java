package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.ImageCategoryFeignClient;
import com.zdxj.model.ImageCategoryEntity;

@Component
public class ImageCategoryHystrix extends BaseHystrix<ImageCategoryEntity> implements ImageCategoryFeignClient {

}
