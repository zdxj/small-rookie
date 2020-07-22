package com.zdxj.config;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdxj.core.Result;

/**
 * 用户退出成功处理控制器
 * @author Administrator
 *
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String accessToken = request.getParameter("access_token");
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(HttpStatus.SC_OK);
        ObjectMapper objectMapper = new ObjectMapper();
        if(StringUtils.isNotBlank(accessToken)){
        	MyRedisTokenStoreService tokenStore = new MyRedisTokenStoreService(connectionFactory, clientDetailsService);
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
            if(oAuth2AccessToken != null){
                tokenStore.removeAccessToken(oAuth2AccessToken);
                OAuth2RefreshToken oAuth2RefreshToken = oAuth2AccessToken.getRefreshToken();
                tokenStore.removeRefreshToken(oAuth2RefreshToken);
                tokenStore.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken);
                objectMapper.writeValue(response.getOutputStream(), Result.success("退出成功",null));
            }
        }
        objectMapper.writeValue(response.getOutputStream(), Result.failed("token丢失，退出失败"));
    }
}
