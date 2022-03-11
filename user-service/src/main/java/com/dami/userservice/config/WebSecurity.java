package com.dami.userservice.config;

import com.dami.userservice.config.filter.AuthenticationFilter;
import com.dami.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /**
     * 권한 관련 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable();
        
        http.authorizeRequests()
            .antMatchers("/**")
            .hasIpAddress("192.168.0.8")
            .and()
            .addFilter(getAuthenticationFilter());
        
        http.headers()
            .frameOptions()
            .disable();
    }
    
    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        
        return filter;
    }
    
    /**
     * 인증 관련 설정
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
