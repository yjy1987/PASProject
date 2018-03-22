package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.board.QnaBoardDao;
import com.app.pas.dao.board.QnaBoardReplyDao;
import com.app.pas.dto.board.QnaBoardReplyVo;

public class QnaBoardReplyService {
	private QnaBoardReplyDao qnaBoardReplyDao;
	
	private QnaBoardDao qnaBoardDao;

	public void setQnaBoardReply(QnaBoardReplyDao qnaBoardReplyDao) {
		this.qnaBoardReplyDao = qnaBoardReplyDao;
	}
	

	public void setQnaBoardDao(QnaBoardDao qnaBoardDao) {
		this.qnaBoardDao = qnaBoardDao;
	}


	
	 public QnaBoardReplyVo selectQnaReply(int qb_Article_Num) throws
	  SQLException{ 
		 QnaBoardReplyVo qnaBoardReplyVo= null; qnaBoardReplyVo =
	  qnaBoardReplyDao.selectQnaReply(qb_Article_Num);
	  
	  return qnaBoardReplyVo; }
	 
	/*public List<QnaBoardReplyVo> selectQnaReply(int qb_Article_Num) throws SQLException {
		List<QnaBoardReplyVo> list = qnaBoardReplyDao.selectQnaReply(qb_Article_Num);

		return list;

	}*/

	public void insertQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo,int qb_Article_Num)
			throws SQLException {
		System.out.println("dao vo"+qnaBoardReplyVo.toString());
		qnaBoardReplyDao.insertQnaBoardReply(qnaBoardReplyVo);
		qnaBoardDao.updateQnaYN(qb_Article_Num);
	}
	
//답변수정
	public void updateQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo) throws SQLException{
		System.out.println("서비스에 있는 qnaBoardReplyVo" + qnaBoardReplyVo);
		qnaBoardReplyDao.updateQnaBoardReply(qnaBoardReplyVo);
	}
	
//답변 삭제
	public void deleteQnaBoardReply(int qb_Article_Num) throws SQLException {
		qnaBoardDao.deleteQnaYN(qb_Article_Num);
		qnaBoardReplyDao.deleteQnaBoardReply(qb_Article_Num);
		
	}
	
	
	
	
}
