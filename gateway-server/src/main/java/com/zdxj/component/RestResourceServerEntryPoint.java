package com.zdxj.component;

import java.nio.charset.Charset;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.zdxj.constant.GlobalConstants;
import com.zdxj.core.Result;

import cn.hutool.json.JSONUtil;
import reactor.core.publisher.Mono;

/**
 * token无效提示
 * @author zhaodx
 * @date 2020-07-22 11:28
 */
@Component
public class RestResourceServerEntryPoint implements ServerAuthenticationEntryPoint{

	@Override
	public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
		ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String body= JSONUtil.toJsonStr(Result.result(GlobalConstants.NOT_LOGIN,"token无效",null));
        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Mono.just(buffer));
	}



	

}
