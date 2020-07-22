package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.SystemMenuEntity;
import com.zdxj.service.SystemMenuService;


@RestController
@RequestMapping("/systemMenu")
public class SystemMenuController extends BaseController<SystemMenuService,SystemMenuEntity>{

}
