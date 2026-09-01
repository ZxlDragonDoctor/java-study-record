package com.example.testdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(Customizer.withDefaults()) //引用CsrfFilter
				.httpBasic(Customizer.withDefaults()) //引用BasicAuthenticationFilter
				.formLogin(Customizer.withDefaults())
//UsernamePasswordAuthenticationFilter
				.authorizeHttpRequests(authorize -> authorize //引用AuthorizeFiltler
						.anyRequest().authenticated()
				);
		return http.build();
	}

}