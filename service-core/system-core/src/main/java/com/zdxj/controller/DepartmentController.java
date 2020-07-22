package com.zdxj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdxj.core.controller.BaseController;
import com.zdxj.model.DepartmentEntity;
import com.zdxj.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController<DepartmentService,DepartmentEntity>{

}
