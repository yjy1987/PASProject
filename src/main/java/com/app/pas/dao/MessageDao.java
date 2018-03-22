package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.MessageVo;

public interface MessageDao {


	  public List<MessageVo> selectReceiveMessageList(MessageVo messageVo)throws SQLException;
	  public List<MessageVo> selectSendMessageList(MessageVo messageVo)throws SQLException;
/*	  public List<ReceiveMessageVo>selectAllSendMessage()throws SQLException;  */
	  public MessageVo selectMessage(int msg_Article_Num)throws SQLException;
	  public void insertMessage(MessageVo messageVo)throws SQLException;
	  
		  
	  public void updateSendMessageDelYN(int msg_Article_Num) throws SQLException;
	  
	  public void deleteMessage(int msg_Article_Num)throws SQLException;
	  public void updateReceiveMessageReadYN(int msg_Article_Num)throws SQLException;
	  public void updateReceiveMessageDelYN(int msg_Article_Num )throws SQLException;
	  public void updateReceiveMessageReadTime(int msg_Article_Num) throws SQLException;
}
