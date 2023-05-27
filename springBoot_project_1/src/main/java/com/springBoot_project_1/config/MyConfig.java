package com.springBoot_project_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig  {

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;

	}
  	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	}
	

@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authenticationProvider(authenticationProvider());	
	
	http.csrf().disable().authorizeRequests()
	.requestMatchers("/admin/**").hasAnyRole("ADMIN")
	.requestMatchers("/user/**").hasAnyRole("USER")
	.requestMatchers("/**")
	.permitAll()
	.and()
	.formLogin()
	
	.loginPage("/signin")
	.loginProcessingUrl("/dologin")
	.defaultSuccessUrl("/user/index")
	.failureUrl("/login_fail")
	;
	
	return http.build();
	
	
	}


	
}
