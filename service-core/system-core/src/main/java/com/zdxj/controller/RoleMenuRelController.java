package com.zdxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdxj.core.Result;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.RoleMenuRelEntity;
import com.zdxj.service.RoleMenuRelService;


@RestController
@RequestMapping("/roleMenuRel")
public class RoleMenuRelController extends BaseController<RoleMenuRelService,RoleMenuRelEntity>{

	@Autowired
	private RoleMenuRelService myService ;
	
	/**
	 * 初始化角色和权限的对应关系
	 * @author zhaodx
	 * @date 2020-07-20 18:13
	 * @return
	 */
	@GetMapping("initRoleMenuRel")
    Result<Object> initRoleMenuRel(){
		return myService.initRoleMenuRel(true);
	}
}
