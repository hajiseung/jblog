package com.cafe24.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.security.AuthIntercetpor;
import com.cafe24.security.AuthLoginInterceptor;
import com.cafe24.security.AuthLogoutInterceptor;
import com.cafe24.security.AuthUserHandlerMethodArgumentResolver;

@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {

	@Bean
	public AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}

	/*
	 * Intercepter
	 */
	@Bean
	public AuthIntercetpor authIntercetpor() {
		return new AuthIntercetpor();
	}

	@Bean
	public AuthLoginInterceptor authLoginIntercetpor() {
		return new AuthLoginInterceptor();
	}

	@Bean
	public AuthLogoutInterceptor authLogoutIntercetpor() {
		return new AuthLogoutInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authLoginIntercetpor()).addPathPatterns("/user/auth");
		registry.addInterceptor(authLogoutIntercetpor()).addPathPatterns("/user/logout");
		registry.addInterceptor(authIntercetpor()).addPathPatterns("/**").excludePathPatterns("/user/auth")
				.excludePathPatterns("/user/logout").excludePathPatterns("/assets/**")
				.excludePathPatterns("/images/**").excludePathPatterns("/user/**");
	}

}
