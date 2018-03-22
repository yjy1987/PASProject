package com.app.pas.dao.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.SkillSharingBoardDao;
import com.app.pas.dto.board.SkillSharingBoardLikeVo;
import com.app.pas.dto.board.SkillSharingBoardVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SkillSharingBoardDaoImpl implements SkillSharingBoardDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<SkillSharingBoardVo> selectSkillLikeCountViewList(String ssb_Title)
			throws SQLException {
		List<SkillSharingBoardVo> list = client.queryForList("selectSkillLikeCountViewList",ssb_Title);
		return list;
	}

	@Override
	public SkillSharingBoardVo selectSkillSharingBoard(int ssb_Article_Num)
			throws SQLException {
		SkillSharingBoardVo skillSharingBoardVo = (SkillSharingBoardVo)client.queryForObject("selectSkillSharingBoard",ssb_Article_Num);
		return skillSharingBoardVo;
	}

	@Override
	public SkillSharingBoardVo selectSkillSharingBoardTitle(String ssb_Title)
			throws SQLException {
		SkillSharingBoardVo skillSharingBoardVo = (SkillSharingBoardVo)client.queryForObject("selectSkillSharingBoardTitle",ssb_Title);
		return skillSharingBoardVo;
	}
	
	@Override
	public void insertSkillSharingBoard(SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException {
		client.insert("insertSkillSharingBoard",skillSharingBoardVo);

	}

	@Override
	public void updateSkillSharingBoard(SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException {
		client.update("updateSkillSharingBoard",skillSharingBoardVo);

	}

	@Override
	public void deleteSkillSharingBoard(int ssb_Article_Num) throws SQLException {
		client.delete("deleteSkillSharingBoard",ssb_Article_Num);

	}

	@Override
	public int selectSsbTotalCount() throws SQLException {
		int totalCount = (Integer) client.queryForObject("selectTotalCountSharingBoard");
		return totalCount;
	}

	@Override
	public List<SkillSharingBoardVo> selectSearchSsbTitle(String ssb_title) throws SQLException {
		List<SkillSharingBoardVo> SsbList 
		= (List<SkillSharingBoardVo>)client.queryForList("selectSkillSharingBoardTitle",ssb_title);
		
		return SsbList;
		
	}

	@Override
	public List<SkillSharingBoardVo> selectSearchSsbTitle() throws SQLException {
		List<SkillSharingBoardVo> SsbList 
		= (List<SkillSharingBoardVo>)client.queryForList("selectSkillSharingBoardTitle",null);
		
		return SsbList;
	}

	@Override
	public void updateSkillSharingBoardCount(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		client.update("updateSkillSharingBoardCount",skillSharingBoardVo);
		
	}

	@Override
	public void updateSkillSharingBoardLike(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		client.update("updateSkillSharingBoardLike",skillSharingBoardVo);
		
	}

	@Override
	public void updateSkillSharingBoardCountM(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		client.update("updateSkillSharingBoardCountM",skillSharingBoardVo);
		
	}

	@Override
	public void insertSkillSharingBoardLike(
			SkillSharingBoardLikeVo skillSharingBoardLikeVo) throws SQLException {
		client.update("insertSkillSharingBoardLike",skillSharingBoardLikeVo);
		
	}

	@Override
	public void deleteSkillSharingBoardLike(
			SkillSharingBoardLikeVo skillSharingBoardLikeVo) throws SQLException {
		client.update("deleteSkillSharingBoardLike",skillSharingBoardLikeVo);
		
	}

	@Override
	public int selectCountSharingBoardLike(int ssb_Article_Num)
			throws SQLException {
		int likeCount =(Integer) client.queryForObject("selectCountSharingBoardLike",ssb_Article_Num);
		return likeCount;
	}

	@Override
	public SkillSharingBoardLikeVo selectSkillSharingBoardLikeList(SkillSharingBoardLikeVo skillSharingBoardLikeVo)throws SQLException {
		
		SkillSharingBoardLikeVo skillSharingBoardLike =
				(SkillSharingBoardLikeVo)client.queryForObject("selectSkillSharingBoardLikeList",skillSharingBoardLikeVo);
		return skillSharingBoardLike;
	}

	@Override
	public int skillSharingSearchCount(SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException {
		int totalCount = (Integer)client.queryForObject("skillSharingSearchCount",skillSharingBoardVo);
		return totalCount;
	}

	@Override
	public List<SkillSharingBoardVo> selectSkillSharingBoardList(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		List<SkillSharingBoardVo> list = client.queryForList("selectSkillSharingBoardList",skillSharingBoardVo);
		return list;
	}

	@Override
	public List<SkillSharingBoardVo> skillSharingSearch_Content_Title(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		List<SkillSharingBoardVo>list = client.queryForList("skillSharingSearch_Content_Title",skillSharingBoardVo);
		return list;
	}
//내가 쓴글 
	@Override
	public List<SkillSharingBoardVo> skill_myPostList(
			SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		List<SkillSharingBoardVo>list = client.queryForList("skill_myPostList",skillSharingBoardVo);
		return list;

	}

	@Override
	public int skill_myPostCount(SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException {
		int totalCount = (Integer)client.queryForObject("skill_myPostCount",skillSharingBoardVo);
		return totalCount;
	}

	}

	


