package com.app.pas.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.pas.dto.MemberLogVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.service.MemberLogService;

public class LoginInterceptor  extends HandlerInterceptorAdapter {

	private MemberLogService memberLogService;
	
	public void setMemberLogService(MemberLogService memberLogService) {
		this.memberLogService = memberLogService;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		MemberLogVo memberLogVo = new MemberLogVo();
		if(memberVo!=null){
			String mem_Email = memberVo.getMem_Email();
			memberLogVo.setMem_Email(mem_Email);
			memberLogService.insertMemberLog(memberLogVo);
		}
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
