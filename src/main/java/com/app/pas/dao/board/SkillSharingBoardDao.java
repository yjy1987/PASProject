package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.SkillSharingBoardLikeVo;
import com.app.pas.dto.board.SkillSharingBoardVo;

public interface SkillSharingBoardDao {
	
	public List<SkillSharingBoardVo> selectSkillLikeCountViewList(String ssb_Title)throws SQLException;
	public SkillSharingBoardVo selectSkillSharingBoard(int ssb_Article_Num)throws SQLException;
	public SkillSharingBoardVo selectSkillSharingBoardTitle(String ssb_Title) throws SQLException;
	public void insertSkillSharingBoard(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public void updateSkillSharingBoard(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public void updateSkillSharingBoardCount(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public void updateSkillSharingBoardCountM(SkillSharingBoardVo SkillSharingBoardVo)throws SQLException;
	public void updateSkillSharingBoardLike(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public void deleteSkillSharingBoard(int ssb_Article_Num)throws SQLException;
	public int selectSsbTotalCount() throws SQLException;
	public List<SkillSharingBoardVo> selectSearchSsbTitle(String ssb_title)throws SQLException;
	public List<SkillSharingBoardVo> selectSearchSsbTitle()throws SQLException;
	public void insertSkillSharingBoardLike(SkillSharingBoardLikeVo skillSharingBoardLikeVo)throws SQLException;
	public void deleteSkillSharingBoardLike(SkillSharingBoardLikeVo skillSharingBoardLikeVo)throws SQLException;
	public int selectCountSharingBoardLike(int ssb_Article_Num) throws SQLException;
	public SkillSharingBoardLikeVo selectSkillSharingBoardLikeList(SkillSharingBoardLikeVo skillSharingBoardLikeVo)throws SQLException;
	
	public List<SkillSharingBoardVo>selectSkillSharingBoardList(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public int skillSharingSearchCount(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public List<SkillSharingBoardVo> skillSharingSearch_Content_Title(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	//내가쓴글
	public List<SkillSharingBoardVo> skill_myPostList(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	public int skill_myPostCount(SkillSharingBoardVo skillSharingBoardVo)throws SQLException;
	

}
