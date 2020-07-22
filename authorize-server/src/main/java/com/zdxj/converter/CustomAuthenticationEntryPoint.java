package com.zdxj.converter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zdxj.core.Result;

/**
 * 自定义无效token的返回信息
 * 当调用接口不传活token无效时会进入该方法
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Throwable cause = e.getCause();
        Gson gson = new Gson();
        System.out.println("cause="+cause);
        String errorMsg = "资源服务器返回：token丢失" ;
        if(cause instanceof InvalidTokenException) {
        	System.out.println("==>>token无效");
        	errorMsg ="资源服务器返回：token无效";
        }else {
        	System.out.println("==>>token丢失");
        }
        httpServletResponse.getWriter().write(gson.toJson(Result.failed(errorMsg)));
    }
}
