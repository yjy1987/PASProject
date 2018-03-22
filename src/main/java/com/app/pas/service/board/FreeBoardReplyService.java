package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.FreeBoardReplyDao;
import com.app.pas.dto.board.FreeBoardReplyVo;

public class FreeBoardReplyService {

   private FreeBoardReplyDao freeBoardReplyDao;

	public void setFreeboardReplyDao(FreeBoardReplyDao freeBoardReplyDao) {
		this.freeBoardReplyDao = freeBoardReplyDao;
	}
	
	
	public void insertFreeBoardReply(FreeBoardReplyVo freeBoardReplyVo) throws SQLException{
		freeBoardReplyDao.insertFreeBoardReply(freeBoardReplyVo);
	}
	
	public List<FreeBoardReplyVo> selectFreeBoardReply(int frb_Article_Num) throws SQLException{
		List<FreeBoardReplyVo> list = freeBoardReplyDao.selectFreeBoardReply(frb_Article_Num);
		return list;
	}
	public FreeBoardReplyVo selectFRBR(int frb_Reply_Num) throws SQLException {
		FreeBoardReplyVo freeBoardReplyVo = freeBoardReplyDao.selectFRBR(frb_Reply_Num);
		return freeBoardReplyVo;
	}
	
	public void updateFreeBoardReply(FreeBoardReplyVo freeBoardReplyVo)
			throws SQLException {
		freeBoardReplyDao.updateFreeBoardReply(freeBoardReplyVo);
	}
	public void deleteFreeBoradReply(int frb_Reply_Num) throws SQLException {
		freeBoardReplyDao.deleteFreeBoradReply(frb_Reply_Num);
	}
	public int selectFRBReplyTotalCount() throws SQLException {
		int totalCount = freeBoardReplyDao.selectFRBReplyTotalCount();
		return totalCount;
	}
	
	
}

