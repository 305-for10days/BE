package jy.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenAuthenticationException extends AuthenticationException {

    public TokenAuthenticationException(String msg) {
        super(msg);
    }

}
