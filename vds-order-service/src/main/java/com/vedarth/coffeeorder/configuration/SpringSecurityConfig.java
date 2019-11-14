package com.vedarth.coffeeorder.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("demo").password("{noop}password").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/v1/order/**").hasRole("USER")
                .mvcMatchers(HttpMethod.GET, "v1/retail/**").hasRole("USER")
                .mvcMatchers(HttpMethod.POST, "v1/retail/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}
