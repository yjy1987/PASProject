package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.QnaBoardReplyDao;
import com.app.pas.dto.board.QnaBoardReplyVo;
import com.app.pas.dto.board.QnaBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoardReplyDaoImpl implements QnaBoardReplyDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public QnaBoardReplyVo selectQnaReply(int qb_Article_Num)
			throws SQLException {
		QnaBoardReplyVo qnaBoardReplyVo = (QnaBoardReplyVo)client.queryForObject("selectQnaReply", qb_Article_Num);
		
		return qnaBoardReplyVo;
	}

	@Override
	public void insertQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo)
			throws SQLException {
		client.insert("insertQnaBoardReply", qnaBoardReplyVo);
		System.out.println("다오임플에있는 vo : " + qnaBoardReplyVo);
		
	}

	@Override
	public void updateQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo)
			throws SQLException {
		client.update("updateQnaBoardReply", qnaBoardReplyVo);
		System.out.println("다오임플에 있는 qnaBoardReplyVo : " + qnaBoardReplyVo);
		
	}

	@Override
	public void deleteQnaBoardReply(int qb_Article_Num) throws SQLException {
		client.delete("deleteQnaBoardReply",qb_Article_Num);
		
	}

/*	@Override
	public List<QnaBoardReplyVo> selectQnaReply(int qb_Article_Num) throws SQLException {
		List<QnaBoardReplyVo> list = client.queryForList("selectQnaReply", qb_Article_Num);
		return list;
	}
*/
}
