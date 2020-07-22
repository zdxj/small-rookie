package com.zdxj.converter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.zdxj.config.CustomUser;
import com.zdxj.constant.GlobalConstants;

/**
 * 自定义token生成携带的信息
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        //获取登录信息
        CustomUser user = (CustomUser) oAuth2Authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("code", GlobalConstants.SUCCESS);
        additionalInfo.put("id", user.getUserId());
//        additionalInfo.put("authorities", user.getAuthorities());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
