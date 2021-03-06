package com.zdxj.authorization;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;

import com.zdxj.constant.GlobalConstants;
import com.zdxj.util.RedisUtils;

import cn.hutool.core.convert.Convert;
import reactor.core.publisher.Mono;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 * @author zhaodx
 * @date 2020-07-21 10:41
 */
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    
	//不需要验证权限的访问路径前缀
	private final List<String> notToAuthPathFix = Arrays.asList("systemV1","cmsV1");
	
	@Autowired
    private RedisUtils redisUtils;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //从Redis中获取当前路径可访问角色列表
        URI uri = authorizationContext.getExchange().getRequest().getURI();
        if(!this.needToAuthentication(uri.getPath())) {
        	return Mono.just(new AuthorizationDecision(true));
        }
        Object obj = redisUtils.get(GlobalConstants.RESOURCE_ROLES_MAP, uri.getPath());
        List<String> authorities = Convert.toList(String.class,obj);
        //认证通过且角色匹配的用户可访问当前路径
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

    /**
     * 是否需要验证权限
     * @author zhaodx
     * @date 2020-07-23 18:12
     * @param path
     * @return
     */
    private boolean needToAuthentication(String path) {
    	String[] split = path.split("\\/");
    	if(split == null || split.length<3) {
    		return true ;
    	}
    	if(!notToAuthPathFix.contains(split[1])) {
    		return true ;
    	}
    	return false ;
    }
}
