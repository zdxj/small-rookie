package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.AdEntity;
import com.zdxj.service.AdService;


@RestController
@RequestMapping("/ad")
public class AdController extends BaseController<AdService,AdEntity>{

}
