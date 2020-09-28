
package com.taskManager.Todo.Basic.Auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

@EnableWebSecurity
public class BasicAuthentication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.cors().and()
		.authorizeRequests()
		.antMatchers(  HttpMethod.OPTIONS, "/**").permitAll()
		.anyRequest().authenticated().and() 
		// .formLogin().and()
				.httpBasic();

	}

}
