package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.ImageCommentFeignClient;
import com.zdxj.model.ImageCommentEntity;

@Component
public class ImageCommentHystrix extends BaseHystrix<ImageCommentEntity> implements ImageCommentFeignClient {

}
