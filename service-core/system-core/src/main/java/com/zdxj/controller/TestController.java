package com.zdxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdxj.common.LoginUserService;
import com.zdxj.model.SystemManagerEntity;

/**
 * 测试类
 * @author zhaodx
 * @date 2020-07-21 18:09
 */
@RestController
@RequestMapping("/test")
public class TestController{

    @Autowired
    private LoginUserService loginUserService;

    @GetMapping("/currentUser")
    public SystemManagerEntity currentUser() {
        return loginUserService.getCurrentManager();
    }

}
