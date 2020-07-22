package com.zdxj.hystrix;

import org.springframework.stereotype.Component;
import com.zdxj.core.hystrix.BaseHystrix;
import com.zdxj.feignclient.MemberFeignClient;
import com.zdxj.model.MemberEntity;

@Component
public class MemberHystrix extends BaseHystrix<MemberEntity> implements MemberFeignClient {

}
