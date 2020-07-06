package com.bolsadeideas.springboot.schedule.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("ScheduleInterceptors")
public class ScheduleInterceptors implements HandlerInterceptor{

	private Integer open = 14;
	
	private Integer close = 16;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour >= open && hour <= close) {
			request.setAttribute("message", "El horario de apertura es desde " + open.toString() + " hasta las " + close.toString());
		return true;
		}
		response.sendRedirect(request.getContextPath().concat("/closed"));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
		modelAndView.addObject("message", request.getAttribute("message"));
		}
	}

}
