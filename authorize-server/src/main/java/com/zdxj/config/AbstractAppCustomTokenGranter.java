package com.zdxj.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.Map;

public abstract class AbstractAppCustomTokenGranter extends AbstractTokenGranter {

    protected AbstractAppCustomTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = tokenRequest.getRequestParameters();
        UserDetails customUser = getCustomUserByAppId(parameters);
        if (customUser == null) {
            throw new InvalidGrantException("用户不存在");
        }
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(client);
        Authentication userAuth = new UsernamePasswordAuthenticationToken(customUser, null, customUser.getAuthorities());
        OAuth2Authentication authentication = new OAuth2Authentication(oAuth2Request, userAuth);
        authentication.setDetails(customUser);
        authentication.setAuthenticated(true);
        return authentication;
    }

    /**
     * 自定义获取用户信息接口-appId
     * @param parameters
     * @return
     */
    protected abstract UserDetails getCustomUserByAppId(Map<String, String> parameters);

}
