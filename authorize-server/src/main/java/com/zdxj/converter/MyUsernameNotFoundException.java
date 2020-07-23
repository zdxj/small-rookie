package com.zdxj.converter;

import org.springframework.security.core.AuthenticationException;

/**
 * 用户登录时自定义的抛出异常
 * @author zhaodx
 * @date 2020-07-23 12:55
 */
public class MyUsernameNotFoundException extends AuthenticationException{

	private static final long serialVersionUID = 2335250434660006995L;

	public MyUsernameNotFoundException(String msg) {
		super(msg);
	}

	public MyUsernameNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
