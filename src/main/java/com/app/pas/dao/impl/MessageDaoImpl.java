package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.MessageDao;
import com.app.pas.dto.MessageVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MessageDaoImpl implements MessageDao{

	private SqlMapClient client;
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<MessageVo> selectReceiveMessageList(MessageVo messageVo)
			throws SQLException {
		List<MessageVo> list = client.queryForList("selectReceiveMessageList", messageVo);
		
		return list;
	}
	@Override
	public List<MessageVo> selectSendMessageList(MessageVo messageVo)
			throws SQLException {
		List<MessageVo> list = client.queryForList("selectSendMessageList", messageVo);
		
		return list;
	}


	@Override
	public MessageVo selectMessage(int msg_Article_Num) throws SQLException {
	MessageVo messageVo = (MessageVo) client.queryForObject("selectMessage",msg_Article_Num);
		return messageVo;
	}

	@Override
	public void insertMessage(MessageVo messageVo) throws SQLException {
		client.insert("insertMessage", messageVo);
		
	}

	@Override
	public void updateSendMessageDelYN(int msg_Article_Num) throws SQLException {
		client.update("updateSendMessageDelYN",msg_Article_Num);
		
	}

	@Override
	public void deleteMessage(int msg_Article_Num) throws SQLException {
		client.delete("deleteMessage",msg_Article_Num);
		
	}

	@Override
	public void updateReceiveMessageReadYN(int msg_Article_Num)
			throws SQLException {
		client.update("updateReceiveMessageReadYN", msg_Article_Num);
		
	}

	@Override
	public void updateReceiveMessageDelYN(int msg_Article_Num)
			throws SQLException {
		client.update("updateReceiveMessageDelYN", msg_Article_Num);
		
	}

	@Override
	public void updateReceiveMessageReadTime(int msg_Article_Num) throws SQLException {
		client.update("updateReceiveMessageReadTime",msg_Article_Num);
		
	}
	
	


}
