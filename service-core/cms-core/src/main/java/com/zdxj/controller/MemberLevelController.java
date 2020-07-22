package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.MemberLevelEntity;
import com.zdxj.service.MemberLevelService;


@RestController
@RequestMapping("/memberLevel")
public class MemberLevelController extends BaseController<MemberLevelService,MemberLevelEntity>{

}
