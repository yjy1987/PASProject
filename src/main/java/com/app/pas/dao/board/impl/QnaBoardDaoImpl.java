package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.QnaBoardDao;
import com.app.pas.dto.board.QnaBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;
import com.sun.security.ntlm.Client;

public class QnaBoardDaoImpl implements QnaBoardDao{
	
	private SqlMapClient client;
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<QnaBoardVo> selectQnaBoardList(QnaBoardVo qnaBoarVo) throws SQLException {
		List<QnaBoardVo> list = client.queryForList("selectQnaBoardList",qnaBoarVo);
		return list;
	}
//리스트전체 조회
	@Override
	public List<QnaBoardVo> selectAllQna() throws SQLException {
		List<QnaBoardVo>list =client.queryForList("selectAllQna");
		return null;
	}
	
	@Override
	public QnaBoardVo selectQnaBoard(int qb_Article_Num) throws SQLException {
		QnaBoardVo qnaBoardVo = (QnaBoardVo) client.queryForObject("selectQnaBoard",qb_Article_Num);
		return qnaBoardVo;
	}

	@Override
	public void insertQnaBoard(QnaBoardVo qnaBoardVo) throws SQLException {
		client.insert("insertQnaBoard",qnaBoardVo);
	}

	@Override
	public void updateQnaBoard(QnaBoardVo qnaBoardVo) throws SQLException {	
		client.update("updateQnaBoard",qnaBoardVo);
	}

	@Override
	public void deleteQnaBoard(int qb_Article_Num) throws SQLException {
		System.out.println("^^^^^^^^^^^^^"+qb_Article_Num);
		client.delete("deleteQnaBoard",qb_Article_Num);
		System.out.println("^^^^^^^^^^^^^"+qb_Article_Num);
	}

	@Override
	public int QnaSelectTotalCount() throws SQLException {
		int totalCount = (Integer) client.queryForObject("QnaSelectTotalCount");
		return totalCount;
		
	}
	@Override
	public int QnaSearchTotalCount(QnaBoardVo qnaBoardVo) throws SQLException {
		int totalCount = (Integer)client.queryForObject("QnaSearchTotalCount",qnaBoardVo);
		return	totalCount;
	}

	@Override
	public void QnaBoardCount(int qb_Article_Num) throws SQLException {
		client.update("QnaBoardCount",qb_Article_Num);
		
	}
	@Override
	public void updateQnaYN(int qb_Article_Num) throws SQLException {
		System.out.println("dao"+qb_Article_Num);
		client.update("updateQnaYN", qb_Article_Num);
		
	}

	@Override
	public void deleteQnaYN(int qb_Article_Num) throws SQLException {
		client.update("deleteQnaYN",qb_Article_Num);
		
	}

	@Override
	public List<QnaBoardVo> myPostList(QnaBoardVo qnaBoardVo) throws SQLException {
			List<QnaBoardVo> list = client.queryForList("myPostList",qnaBoardVo);
		return list;
	}

	@Override
	public int myPostListCount(QnaBoardVo qnaBoardVo) throws SQLException {
		int totalCount = (Integer) client.queryForObject("myPostListCount", qnaBoardVo);
		return totalCount;
	}

	@Override
	public int selectNCount() throws SQLException {
		int NCount = (Integer) client.queryForObject("selectNCount");
		return NCount;
	}



	
}
