package com.app.pas.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectLogVo;
import com.app.pas.service.ProjectLogService;

public class ProjectInterceptor extends HandlerInterceptorAdapter{
	private ProjectLogService projectLogService;
	
	public void setProjectLogService(ProjectLogService projectLogService) {
		this.projectLogService = projectLogService;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ProjectLogVo projectLogVo = new ProjectLogVo();
		HttpSession session = request.getSession();
		
		if(request.getHeader("referer").contains("myProject")){
			String proj_Num = request.getParameter("proj_Num");
			MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
			String mem_Email = memberVo.getMem_Email();
			projectLogVo.setMem_Email(mem_Email);
			projectLogVo.setProj_Num(Integer.parseInt(proj_Num));
			projectLogService.insertProjectLog(projectLogVo);
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

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
