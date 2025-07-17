package com.qpassessment.qpgrocery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // Enables method-level security annotations
public class SecurityConfig {

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				
		http.csrf().disable()
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/getAll","/user/public/userLogin", "/user/public/addUser", "/employee/save").permitAll()
				 .requestMatchers("/user/**", "/api/addItem", "/api/update/**", "/api/delete/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
				.httpBasic();

		return http.build();
	}
		
	
	
}
