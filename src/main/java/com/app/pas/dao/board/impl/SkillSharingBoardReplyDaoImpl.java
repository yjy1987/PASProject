package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.SkillSharingBoardReplyDao;
import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SkillSharingBoardReplyDaoImpl implements SkillSharingBoardReplyDao{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReplyList()
			throws SQLException {
		List<SkillSharingBoardReplyVo> list = client.queryForList("selectSkillSharingBoardReplyList");
		return list;
	}

	@Override
	public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReply(
			int ssb_Article_Num) throws SQLException {
		List<SkillSharingBoardReplyVo> skillSharingBoardReplyVo = client.queryForList("selectSkillSharingBoardReply",ssb_Article_Num);
		return skillSharingBoardReplyVo;
	}

	@Override
	public void insertSkillSharingBoardReply(
			SkillSharingBoardReplyVo skillSharingBoardReplyVo)
			throws SQLException {
		client.insert("insertSkillSharingBoardReply",skillSharingBoardReplyVo);
		
	}

	@Override
	public void updateSkillSharingBoardReply(
			SkillSharingBoardReplyVo skillSharingBoardReplyVo)
			throws SQLException {
		client.update("updateSkillSharingBoardReply",skillSharingBoardReplyVo);
		
	}

	@Override
	public void deleteSkillSharingBoardReply(int ssb_Article_Num)
			throws SQLException {
		client.delete("deleteSkillSharingBoardReply",ssb_Article_Num);

	}

	@Override
	public SkillSharingBoardReplyVo selectSSBR(int ssb_Reply_Num) throws SQLException {
		SkillSharingBoardReplyVo skillSharingBoardReplyVo = (SkillSharingBoardReplyVo) client.queryForObject("selectSSBR", ssb_Reply_Num);
		return skillSharingBoardReplyVo;
	}
	
}
