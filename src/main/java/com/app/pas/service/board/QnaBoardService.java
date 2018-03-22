package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.app.pas.dao.board.QnaBoardDao;
import com.app.pas.dto.board.QnaBoardVo;

public class QnaBoardService {
	// db에서 받아온 값 :dao
	// dao에서 받아온 값을 가공처리 하는곳이 serviece
	// 가공처리 ex) if문 줘서 로그인 아이디가 null이면

	private QnaBoardDao qnaBoardDao;

	public void setQnaBoardDao(QnaBoardDao qnaBoardDao) {
		this.qnaBoardDao = qnaBoardDao;
	}


	public List<QnaBoardVo> selectQnaBoardList(QnaBoardVo qnaBoarVo ) throws SQLException {
		List<QnaBoardVo> list = new ArrayList<QnaBoardVo>();
		list = qnaBoardDao.selectQnaBoardList(qnaBoarVo);
		return list;
	}
	//리스트 전체 조회 
	public List<QnaBoardVo> selectAllQna()throws SQLException{
		List<QnaBoardVo>list = new ArrayList<QnaBoardVo>();
		return list;
	}
	
	//내가 쓴 글 조회 
	public List<QnaBoardVo> myPostList(QnaBoardVo qnaBoardVo) throws SQLException{
		List<QnaBoardVo> list = qnaBoardDao.myPostList(qnaBoardVo);
		return list;
	}
	//내가 쓴글 카운트 
	public int myPostListCount (QnaBoardVo qnaBoardVo) throws SQLException{
		int totalCount = qnaBoardDao.myPostListCount(qnaBoardVo);
		return totalCount;
	}
	

	public void insertQnaBoard(QnaBoardVo qnaBoardVo) throws SQLException {
		qnaBoardDao.insertQnaBoard(qnaBoardVo);
	}

	public QnaBoardVo selectQnaBoard(int qb_Article_Num) throws SQLException {
		QnaBoardVo qnaboardVo = null;
		qnaboardVo = qnaBoardDao.selectQnaBoard(qb_Article_Num);

		return qnaboardVo;
	}

	public void updateQnaBoard(QnaBoardVo qnaBoardVo) throws SQLException {
		qnaBoardDao.updateQnaBoard(qnaBoardVo);
	}
	
	public void deleteQnaBoard(int qb_Article_Num) throws SQLException{
		qnaBoardDao.deleteQnaBoard(qb_Article_Num);
	}
//페이지
	public int QnaSelectTotalCount() throws SQLException {
		int totalCount = qnaBoardDao.QnaSelectTotalCount();	
		return totalCount;
	}
//검색 결과에 따른 페이지
	public int QnaSearchTotalCount(QnaBoardVo qnaBoardVo) throws SQLException{
		int totalCount = qnaBoardDao.QnaSearchTotalCount(qnaBoardVo);
		return totalCount;
	}
//조횟수	
	public void QnaBoardCount(int qb_Article_Num) throws SQLException{
		qnaBoardDao.QnaBoardCount(qb_Article_Num);
	}
	
	public int selectNCount() throws SQLException {
		int NCount = qnaBoardDao.selectNCount();
		return NCount;
	}
	
	


}
