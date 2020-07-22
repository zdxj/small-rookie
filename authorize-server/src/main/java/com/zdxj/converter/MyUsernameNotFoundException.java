package com.zdxj.converter;

import org.springframework.security.core.AuthenticationException;

public class MyUsernameNotFoundException extends AuthenticationException{

	private static final long serialVersionUID = 2335250434660006995L;

	public MyUsernameNotFoundException(String msg) {
		super(msg);
	}

	public MyUsernameNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
