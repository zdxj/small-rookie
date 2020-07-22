package com.zdxj.config;

import java.util.Date;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

public class MyRedisTokenStoreService extends RedisTokenStore{

	private ClientDetailsService clientDetailsService;
	
	public MyRedisTokenStoreService(RedisConnectionFactory connectionFactory,ClientDetailsService clientDetailsService) {
		super(connectionFactory);
		this.clientDetailsService = clientDetailsService;
	}

	@Override
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		OAuth2Authentication result = readAuthentication(token.getValue());
		if (result != null) {
			
			OAuth2Request oAuth2Request = result.getOAuth2Request();
			String clientId = oAuth2Request.getClientId();
			//只有api服务器为小程序提供的客户端才会自动刷新token时间
			if(!"appclient".equals(clientId)) {
				return result ;
			}
			// 如果token没有失效  更新AccessToken过期时间
			DefaultOAuth2AccessToken oAuth2AccessToken = (DefaultOAuth2AccessToken) token;
 
			//重新设置过期时间
			int validitySeconds = getAccessTokenValiditySeconds(clientId);
			if (validitySeconds > 0) {
				oAuth2AccessToken.setExpiration(new Date(System.currentTimeMillis() + (validitySeconds * 1000L)));
			}
 
			//将重新设置过的过期时间重新存入redis, 此时会覆盖redis中原本的过期时间
			storeAccessToken(token, result);
		}
		return result;
	}
 
	protected int getAccessTokenValiditySeconds(String clientId) {
		if (clientDetailsService != null) {
			ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
			Integer validity = client.getAccessTokenValiditySeconds();
			if (validity != null) {
				return validity;
			}
		}
		// default 30 minutes.
		int accessTokenValiditySeconds = 60 * 30;
		return accessTokenValiditySeconds;
	}
}
