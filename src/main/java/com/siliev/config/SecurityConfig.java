package com.siliev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**").authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/travel/angel/information").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();

        http.csrf().disable();
    }
}