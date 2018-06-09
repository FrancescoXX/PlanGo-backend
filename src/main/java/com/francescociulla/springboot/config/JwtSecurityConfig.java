package com.francescociulla.springboot.config;

import com.francescociulla.springboot.security.JwtAuthenticationEntryPoint;
import com.francescociulla.springboot.security.JwtAuthenticationProvider;
import com.francescociulla.springboot.security.JwtAuthenticationTokenFilter;
import com.francescociulla.springboot.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

/*
    JWT Security Configuration file:
 */

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    //REGISTERED AREA. any request to this test has an authorization filter
    private String SECRETURL = "/secret/**" ;

    private JwtAuthenticationProvider authenticationProvider; //To Provide Authentication
    private JwtAuthenticationEntryPoint entryPoint; //to handle errors

    @Autowired
    public JwtSecurityConfig(JwtAuthenticationProvider authenticationProvider, JwtAuthenticationEntryPoint entryPoint) {
        this.authenticationProvider = authenticationProvider;
        this.entryPoint = entryPoint;
    }

    //SPRING AuthenticationManager
    // Uses our custom JWT Authentication Provider
    @Bean
    public AuthenticationManager authenticationManager() {

        //override Spring ProvideManager with custom Authentication provider (JWT in this case)
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    /*
        //Authentication ManagerBuilder: to configure authentication method
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
    }
     */

    //Jwt Authentication Filter
    // set Authentication Manager and Success Handler
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {

        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    //Filter Configuration
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); //disable csrf
        http.authorizeRequests().antMatchers("/rest/**").authenticated(); //if i have some request at .../rest/... will need authentication
        http.authorizeRequests().antMatchers(SECRETURL).authenticated(); //if i have some request at .../rest/... will need authentication
        http.exceptionHandling().authenticationEntryPoint(entryPoint); //entry point for exception handling
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //stateless session
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();//will addJwtUser some headers to request
    }
}