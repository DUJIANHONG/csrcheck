package com.csr.csrcheck.config;


import com.csr.csrcheck.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor=new LoginInterceptor();
		List<String>paths=new ArrayList<String>();
		paths.add("/js/**");
		paths.add("/css/**");
		paths.add("/images/**");
		paths.add("/img/**");
		paths.add("/newsFile/**");
		paths.add("/fonts/**");
		paths.add("/bootstrap3/**");
		paths.add("/districts/**");
		paths.add("/web/login.html");
		paths.add("/users/login");
		paths.add("/company/companylist");
		paths.add("/company/companylist2");
		paths.add("/news/newlist");
		paths.add("/news/byidnews/{id}");
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(paths);
	}
	
}
