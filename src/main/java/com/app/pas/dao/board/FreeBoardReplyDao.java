package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.FreeBoardReplyVo;

public interface FreeBoardReplyDao {

	public List<FreeBoardReplyVo> selectFreeBoardReply(int frb_Article_Num)throws SQLException;
	public FreeBoardReplyVo selectFRBR(int frb_Reply_Num)throws SQLException;
	public void insertFreeBoardReply(FreeBoardReplyVo freeBoardReplyVo)throws SQLException;
	public void updateFreeBoardReply(FreeBoardReplyVo freeBoardReplyVo)throws SQLException;
	public void deleteFreeBoradReply(int frb_Reply_Num)throws SQLException;
	public int selectFRBReplyTotalCount() throws SQLException;

}

