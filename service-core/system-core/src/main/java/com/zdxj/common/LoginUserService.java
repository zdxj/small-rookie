package com.zdxj.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zdxj.model.SystemManagerEntity;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;

/**
 * 获取登录用户信息
 * @author zhaodx
 * @date 2020-07-21 18:42
 */
@Component
public class LoginUserService {

    public SystemManagerEntity getCurrentManager(){
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);
        SystemManagerEntity userDTO = new SystemManagerEntity();
        userDTO.setLoginName(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toInt(userJsonObject.get("id")));
        return userDTO;
    }
}
