package com.bolsadeideas.springboot.schedule.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class McvConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier("ScheduleInterceptors")
	private HandlerInterceptor scheduleInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(scheduleInterceptor).excludePathPatterns("/closed");
	}

}
