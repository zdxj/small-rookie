package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.MemberLevelFeignClient;
import com.zdxj.model.MemberLevelEntity;

@Component
public class MemberLevelHystrix extends BaseHystrix<MemberLevelEntity> implements MemberLevelFeignClient {

}
