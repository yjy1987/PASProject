package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.QnaBoardReplyVo;

public interface QnaBoardReplyDao {

	public QnaBoardReplyVo selectQnaReply(int qb_Article_Num) throws SQLException;
	public void insertQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo) throws SQLException;
	public void updateQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo) throws SQLException;
	public void deleteQnaBoardReply(int qb_Article_Num) throws SQLException;
	
}
