package com.zdxj.converter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

/**
 * 自定义CustomerAccessTokenConverter 这个类的作用主要用于AccessToken的转换，
 * 默认使用DefaultAccessTokenConverter 这个装换器
 * DefaultAccessTokenConverter有个UserAuthenticationConverter，这个转换器作用是把用户的信息放入token中，
 * 默认只是放入user_name
 * <p>
 * 自定义了下这个方法，加入了额外的信息
 * <p>
 **/
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    public CustomAccessTokenConverter() {
        super.setUserTokenConverter(new CustomUserAuthenticationConverter());
    }

    private class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
        @Override
        public Map<String, ?> convertUserAuthentication(Authentication authentication) {
            LinkedHashMap<String, Object> response = new LinkedHashMap <>();
//            response.put("details", authentication.getDetails());
//            response.put("test","hello");
            if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
//                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }
            return response;
        }
    }
}
