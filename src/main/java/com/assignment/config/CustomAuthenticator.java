package com.assignment.config;

import com.assignment.entity.DriverEntity;
import com.assignment.service.DriverUnitedAppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class CustomAuthenticator implements AuthenticationProvider {

    @Autowired
    private DriverUnitedAppLoginService service;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        DriverEntity driver = service.login(userName, Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)));

        if (driver == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new UsernamePasswordAuthenticationToken(driver.getUserName(), driver.getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}