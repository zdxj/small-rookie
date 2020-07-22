package com.zdxj.controller;

import java.security.Principal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/me")
    public Principal me(OAuth2Authentication principal) {
        return principal;
    }
    
    public static void main(String[] args) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	  String encodedPassword = passwordEncoder.encode("admin");
    	  System.out.println(encodedPassword);
	}
}
