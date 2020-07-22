package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.MemberEntity;
import com.zdxj.service.MemberService;


@RestController
@RequestMapping("/member")
public class MemberController extends BaseController<MemberService,MemberEntity>{

}
