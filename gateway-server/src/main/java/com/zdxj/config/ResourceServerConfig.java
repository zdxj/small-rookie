package com.zdxj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.zdxj.authorization.AuthorizationManager;
import com.zdxj.component.RestAuthenticationEntryPoint;
import com.zdxj.component.RestResourceServerEntryPoint;
import com.zdxj.component.RestfulAccessDeniedHandler;
import com.zdxj.constant.GlobalConstants;

import reactor.core.publisher.Mono;

/**
 * 资源服务器配置
 * @author zhaodx
 * @date 2020-07-22 11:32
 */
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {
	@Autowired
    private AuthorizationManager authorizationManager;
	@Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
	@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	@Autowired
	private RestResourceServerEntryPoint restResourceServerEntryPoint;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    	http.oauth2ResourceServer().jwt()
        .jwtAuthenticationConverter(jwtAuthenticationConverter());
        http.authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll()//白名单配置
                .anyExchange().access(authorizationManager)//鉴权管理器配置
                .and().exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)//处理未授权
                .authenticationEntryPoint(restAuthenticationEntryPoint)//处理未认证
                .and().oauth2ResourceServer()
                .authenticationEntryPoint(restResourceServerEntryPoint)//token错误等信息
                .and().csrf().disable();
        return http.build();
    }

    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(GlobalConstants.AUTHORITY_PREFIX);
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(GlobalConstants.AUTHORITY_CLAIM_NAME);
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
  //security的鉴权排除的url列表
    private static final String[] excludedAuthPages = {
    		//认证服务器获取用户信息
            "/systemApi/systemManager/getByLoginName",
            "/systemApi/managerRoleRel/listRoleIdByManagerId",
            "/systemApi/roleMenuRel/initRoleMenuRel",
            "/authApi/oauth/token",
            "/health",
            "/systemApi/test/**"
    };
}
