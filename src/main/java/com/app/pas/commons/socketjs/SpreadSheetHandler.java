package com.app.pas.commons.socketjs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.app.pas.dto.ProjectVo;
import com.google.gson.Gson;

public class SpreadSheetHandler extends TextWebSocketHandler{
	//아이디와 WebSocketSession인 맵
	
		private Map<String,List<WebSocketSession>> roomList ;

		public void setRoomList(Map<String, List<WebSocketSession>> roomList) {
			this.roomList = roomList;
		}

		//클라이언트가 웹소켓서버로  메세지를 전송했을 때 실행되는 메서드
		@Override
		protected void handleTextMessage(WebSocketSession session,
				TextMessage message) throws Exception {
			Map<String, Object> attributes= session.getAttributes();
		     Gson gson = new Gson();
		      Map<String,Object> map = new HashMap<String,Object>();
		      map = (Map<String,Object>) gson.fromJson(message.getPayload().toString(), map.getClass());
				int join_Doc_Num = (Integer) attributes.get("joinDocNum");
		      ArrayList<WebSocketSession> list = (ArrayList<WebSocketSession>) roomList.get(join_Doc_Num+"");
		      for(WebSocketSession x : list){
		    	  if(x.equals(session)){
		    		  continue;
		    	  }
		    	  x.sendMessage(message);
		      }
		  }

		@Override
		public boolean supportsPartialMessages() {
			// TODO Auto-generated method stub
			return false;
		}
		
		
		//클라이언트 연결 이후에 실행되는 메서드
		@Override
		   public void afterConnectionEstablished(WebSocketSession session)
		         throws Exception {
			//서버구축 WebSocketSession 찍어보기
		      System.out.println("여긴 스프레드 씨트다");
		      
		      //Map으로 받기
		      Map<String, Object> attributes= session.getAttributes();
		      /*private Map<String,Map<String,WebSocketSession>> mapList = new HashMap<String, Map<String,WebSocketSession>>();*/
				String loginUserEmail = (String) attributes.get("loginUserEmail");
				int join_Doc_Num = (Integer) attributes.get("joinDocNum");
				ProjectVo projectVo = (ProjectVo) attributes.get("joinProjectVo");
				
				if(!roomList.containsKey(join_Doc_Num+"")){
					List<WebSocketSession> list = new ArrayList<WebSocketSession>();
					list.add(session);
					roomList.put(join_Doc_Num+"",list);
				}else{
					ArrayList<WebSocketSession> list = (ArrayList<WebSocketSession>) roomList.get(join_Doc_Num+"");
					list.add(session);
				}
				
		   }
		
		
		//클라이언트가 연결을 끊었을 때 실행되는 메서드
		@Override
		public void afterConnectionClosed(WebSocketSession session,
				CloseStatus status) throws Exception {
			/*users.put(session.getId(), session);*/
			  Map<String, Object> attributes= session.getAttributes();
			int join_Doc_Num = (Integer) attributes.get("joinDocNum");
			List<WebSocketSession> list = new ArrayList<WebSocketSession>();
			list = roomList.get(join_Doc_Num+"");
			list.remove(session);
			
		}

		@Override
		public void handleTransportError(WebSocketSession session,
				Throwable exception) throws Exception {
			System.out.println("에러호출");
		}
}
