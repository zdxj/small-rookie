package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.ImageFeignClient;
import com.zdxj.model.ImageEntity;

@Component
public class ImageHystrix extends BaseHystrix<ImageEntity> implements ImageFeignClient {

}
