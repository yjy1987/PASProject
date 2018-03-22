package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;


public interface SkillSharingBoardReplyDao {
	
	public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReplyList()throws SQLException;
	public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReply(int ssb_Article_Num)throws SQLException;
	public SkillSharingBoardReplyVo selectSSBR(int ssb_Reply_Num)throws SQLException;
	public void insertSkillSharingBoardReply(SkillSharingBoardReplyVo skillSharingBoardReplyVo)throws SQLException;
	public void updateSkillSharingBoardReply(SkillSharingBoardReplyVo skillSharingBoardReplyVo)throws SQLException;
	public void deleteSkillSharingBoardReply(int ssb_Article_Num)throws SQLException;
	
}
