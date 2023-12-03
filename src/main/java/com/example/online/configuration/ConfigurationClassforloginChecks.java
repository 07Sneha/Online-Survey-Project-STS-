package com.example.online.configuration;

import org.springframework.security.core.Authentication;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class ConfigurationClassforloginChecks extends WebSecurityConfigurerAdapter{


	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
	        .antMatchers("/candidate/**").hasAuthority("ROLE_EMPLOYEE")
	        .and()
	        .formLogin()
	        .loginPage("/Signin")
	        .successHandler((request, response, authentication) -> {
	            String targetUrl = determineTargetUrl(authentication);
	            response.sendRedirect(targetUrl);
	        })
	        .and()
	        .logout()
	        .logoutSuccessUrl("/Signin?logout")
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/access-denied");
	    }

	    
	    private String determineTargetUrl(Authentication authentication) {
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	            return "/admin/home";
	        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))) {
	            return "/candidate/home";
	        }
	        return "/access-denied"; // Default redirect
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	}
/*
 * In Spring Security, roles are typically prefixed with "ROLE_" automatically by the framework.
 *  For example, if you have a role named "ADMIN" in your code, Spring Security will internally treat
 *   it as "ROLE_ADMIN".	
 */

