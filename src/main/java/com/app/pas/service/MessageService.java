package com.app.pas.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.MessageDao;
import com.app.pas.dto.MessageVo;

public class MessageService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	
	public List<MessageVo> selectReceiveMessageList(MessageVo messageVo) throws SQLException{

		List<MessageVo> list = new ArrayList<MessageVo>();
		list = messageDao.selectReceiveMessageList(messageVo);
			
		return list;
		
	}
	public List<MessageVo> selectSendMessageList(MessageVo messageVo) throws SQLException{

		List<MessageVo> list = new ArrayList<MessageVo>();
		list = messageDao.selectSendMessageList(messageVo);
			
		return list;
		
	}


	public MessageVo selectSendMessage(int msg_Article_Num) throws SQLException {
		MessageVo messageVo = null;
		messageVo = messageDao.selectMessage(msg_Article_Num);
		return messageVo;
	}

	
	public MessageVo selectMessage(int msg_Article_Num) throws SQLException{
		MessageVo messageVo = null;
		messageVo = messageDao.selectMessage(msg_Article_Num);
		return messageVo;
	}
	
	public void insertMessage(MessageVo messageVo) throws SQLException{
		messageDao.insertMessage(messageVo);
	}
	public void updateReceiveMessageReadYN(int msg_Article_Num) throws SQLException{
		messageDao.updateReceiveMessageReadYN(msg_Article_Num);
	}
	public void updateReceiveMessageReadTime(int msg_Article_Num) throws SQLException{
		messageDao.updateReceiveMessageReadTime(msg_Article_Num);
	}
	
	public MessageVo selectReceiveMessageDetail(int msg_Article_Num) throws SQLException{
		MessageVo messageVo = null;
		messageVo = messageDao.selectMessage(msg_Article_Num);
		messageDao.updateReceiveMessageReadYN(msg_Article_Num);
		if((messageVo.getMsg_rm_Read_yn().toString().equals("n"))){
			messageDao.updateReceiveMessageReadTime(msg_Article_Num);	
		}else{
			System.out.println("업데이트 안되고 있는거?");
		}
		messageDao.selectMessage(msg_Article_Num);
		return messageVo;
	}
	
	public void updateSendMessageDelYN(int msg_Article_Num) throws SQLException{
		messageDao.updateSendMessageDelYN(msg_Article_Num);
	}
	public void updateReceiveMessageDelYN(int msg_Article_Num) throws SQLException{
		messageDao.updateReceiveMessageDelYN(msg_Article_Num);
	}
	
	
}
