package com.app.pas.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectLogVo;
import com.app.pas.service.ProjectLogService;

public class WorkListInterceptor extends HandlerInterceptorAdapter{
	private ProjectLogService projectLogService;
	
	public void setProjectLogService(ProjectLogService projectLogService) {
		this.projectLogService = projectLogService;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("joinDocNum")==""||session.getAttribute("joinDocNum")==null){
		}else{
			/*session.removeAttribute("joinDocNum");*/
		}
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
