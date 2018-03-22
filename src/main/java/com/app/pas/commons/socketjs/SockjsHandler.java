package com.app.pas.commons.socketjs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;


public class SockjsHandler extends TextWebSocketHandler{
	//아이디와 WebSocketSession인 맵
	private Map<String,WebSocketSession> users= new ConcurrentHashMap<String, WebSocketSession>();
	
	
	//클라이언트가 웹소켓서버로  메세지를 전송했을 때 실행되는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
	     Gson gson = new Gson();
	      Map<String,Object> map = new HashMap<String,Object>();
	      map = (Map<String,Object>) gson.fromJson(message.getPayload().toString(), map.getClass());
	      String msg= (String) map.get("push");
	      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@데이터"+msg);
	      System.out.println();
	      if(users.containsKey(msg)){
	    	  session = users.get(msg);
	    	  session.sendMessage(message);
	      }
	      
	  }

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return super.supportsPartialMessages();
	}
	
	
	//클라이언트 연결 이후에 실행되는 메서드
	@Override
	   public void afterConnectionEstablished(WebSocketSession session)
	         throws Exception {
		
		//서버구축 WebSocketSession 찍어보기
	      System.out.println("@@@@@@@@@@@@@@@@@@@@서버 구축후 @@@@@@@@@@@@@@@");
	      System.out.println(session.getId());
	      System.out.println(session.getUri());
	      System.out.println(session.getLocalAddress());
	      System.out.println(session.getRemoteAddress());
	      
	      
	      //Map으로 받기
	      Map<String, Object> attributes= session.getAttributes();
			String loginUserEmail = (String) attributes.get("loginUserEmail");
			users.put(loginUserEmail, session);
			
	   }
	
	
	//클라이언트가 연결을 끊었을 때 실행되는 메서드
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		/*users.put(session.getId(), session);*/
		Map<String,Object> attributes =session.getAttributes();
		String loginUserEmail = (String) attributes.get("loginUserEmail");
		users.remove(loginUserEmail);
		System.out.println("연결 종료호출");
		
	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		System.out.println("에러호출");
	}

}
