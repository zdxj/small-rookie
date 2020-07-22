package com.zdxj.config;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import com.zdxj.constant.GlobalConstants;

public class CustomTokenGranter extends AbstractAppCustomTokenGranter{

	private CustomUserDetailService userDetailsService;

    public CustomTokenGranter(CustomUserDetailService userDetailsService, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory) {
        super(tokenServices, clientDetailsService, requestFactory, GlobalConstants.OAUTH_GRANT_TYPE_CUSTOM);
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected UserDetails getCustomUserByAppId(Map<String, String> parameters) {
        String loginType = parameters.get("loginType");
        return userDetailsService.loadUserByCustomType(loginType);
    }
}
