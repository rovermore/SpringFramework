package com.bolsadeideas.springboot.form.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("TimingInterceptor")
public class TimingInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TimingInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		long timeInit = System.currentTimeMillis();
		logger.info("TimingInterceptor: preHandle() executing...");
		request.setAttribute("timeInit", timeInit);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		logger.info("TimingInterceptor: postHandle() executing...");
		long timeEnd = System.currentTimeMillis();
		long timeInit = (Long) request.getAttribute("timeInit");
		long totalTime = timeEnd - timeInit;
		String totalTimeString = String.valueOf(totalTime);
		logger.info("TimingInterceptor: the interceptor took " + totalTimeString );
		if (modelAndView != null) {
			modelAndView.addObject("totalTime", totalTimeString);
		}

	}

}
