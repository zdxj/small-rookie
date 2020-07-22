package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.SystemRoleEntity;
import com.zdxj.service.SystemRoleService;


@RestController
@RequestMapping("/systemRole")
public class SystemRoleController extends BaseController<SystemRoleService,SystemRoleEntity>{

}
