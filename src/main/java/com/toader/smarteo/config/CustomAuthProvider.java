package com.toader.smarteo.config;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@NoArgsConstructor
public class CustomAuthProvider implements AuthenticationProvider {

    @Value("${spring.security.user.name}")
    private String user;
    @Value("${spring.security.user.password}")
    private String pwd;

    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        return name.equals(user) && password.equals(pwd) ? new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>()) : null;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
