package com.example.roy.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.roy.com.filter.UserHandlerInterceptor;



//拦截器
@Configuration
public class InterceptorAdapter extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserHandlerInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/","/login","/logout","toLogin","/error/**");
		super.addInterceptors(registry);
	}
	
}
