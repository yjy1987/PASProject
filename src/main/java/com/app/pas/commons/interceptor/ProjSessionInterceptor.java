package com.app.pas.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProjSessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
		if(request.getSession().getAttribute("joinProj") == null){ 
			System.out.println(request.getSession().getAttribute("joinProj")+"이건 조인피알오제!");
		   response.sendRedirect("/index");
		 
		     
			
	}
		
		}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getAttribute("proj_Num")!=request.getSession().getAttribute("joinProj")){
			System.out.println(request.getSession().getAttribute("joinProj")+"이건 조인피알오제!");
			System.out.println(request.getAttribute("proj_Num")+"파파팟!@@@@");
			response.sendRedirect("/index");
			return false;
		}
		return true;
		
	}
	
	
	
}
