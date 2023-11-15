package com.security;

import sun.security.util.Password;

import javax.naming.AuthenticationException;

public class WebSecurity {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager


}
