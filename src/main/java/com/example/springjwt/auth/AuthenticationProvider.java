package com.example.springjwt.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticationProvider {

    Authentication authenticate(Authentication authentication)
            throws AuthenticationException;

}
