package com.zdxj.converter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zdxj.constant.GlobalConstants;

/**
 * web全局异常返回处理器
 */
@Configuration
public class CustomWebResponseExceptionTranslator {

    /**
     * 自定义登录或者鉴权失败时的返回信息
     */
    @Bean(name = "webResponseExceptionTranslator")
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
                OAuth2Exception body = (OAuth2Exception) responseEntity.getBody();
                HttpHeaders headers = new HttpHeaders();
                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
                // do something with header or response
                if ( 400 == responseEntity.getStatusCode().value() ) {
                    if ( "Bad credentials".equals(body.getMessage()) ) {
                    	MyOAuth2Exception exception = new MyOAuth2Exception("", e);
                        return new ResponseEntity<OAuth2Exception>(exception , headers , HttpStatus.OK);
                    }
                }else if(401 == responseEntity.getStatusCode().value()) {
                	if(e instanceof InternalAuthenticationServiceException) {
                		if(e.getCause() instanceof MyUsernameNotFoundException) {
                			MyOAuth2Exception exception = new MyOAuth2Exception(e.getMessage(), e);
                            return new ResponseEntity<OAuth2Exception>(exception , headers , HttpStatus.OK);
                		}
                	}
                }
                return new ResponseEntity<OAuth2Exception>(body , headers , responseEntity.getStatusCode());

            }
        };
    }
    
    
    @JsonSerialize(using = MyOAuthExceptionJacksonSerializer.class)
    public class MyOAuth2Exception extends OAuth2Exception {
		private static final long serialVersionUID = 1L;
		public MyOAuth2Exception(String msg, Throwable t) {
            super(msg, t);

        }
        public MyOAuth2Exception(String msg) {
            super(msg);

        }
    }
    
    public class MyOAuthExceptionJacksonSerializer extends StdSerializer<MyOAuth2Exception> {

		private static final long serialVersionUID = 1L;

		protected MyOAuthExceptionJacksonSerializer() {
            super(MyOAuth2Exception.class);
        }

        @Override
        public void serialize(MyOAuth2Exception value, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
            jgen.writeStartObject();
            jgen.writeObjectField("code",GlobalConstants.NOT_LOGIN);
            jgen.writeStringField("msg", StringUtils.isBlank(value.getMessage())?"您输入的用户名或密码错误":value.getMessage());
            jgen.writeStringField("result",null);
            jgen.writeEndObject();
        }
    }
    
}
