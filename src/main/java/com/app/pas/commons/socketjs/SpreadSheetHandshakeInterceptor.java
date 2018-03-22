package com.app.pas.commons.socketjs;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectVo;

//SocketInteceptor
@Component
public class SpreadSheetHandshakeInterceptor extends HttpSessionHandshakeInterceptor{
	
/*	private HttpSession getSession(ServerHttpRequest request) {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
			return serverRequest.getServletRequest().getSession(false);
		}
		return null;
	}*/
	
	
	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		System.out.println("after");
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		super.beforeHandshake(request, response, wsHandler, attributes);
		ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
		HttpSession session = serverRequest.getServletRequest().getSession();
		
		System.out.println("befor");
        System.out.println("URI:"+request.getURI());
        MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
        ProjectVo projectVo = (ProjectVo) session.getAttribute("joinProjetVo");
        int join_Doc_Num = (Integer) session.getAttribute("joinDocNum");
		attributes.put("loginUserEmail",memberVo.getMem_Email());
		attributes.put("joinProjectVo", projectVo);
		attributes.put("joinDocNum", join_Doc_Num);
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

}