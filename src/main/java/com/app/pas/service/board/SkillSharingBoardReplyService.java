package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pas.dao.board.SkillSharingBoardReplyDao;
import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;

public class SkillSharingBoardReplyService{
   
   private SkillSharingBoardReplyDao skillSharingBoardReplyDao;
   
   
   
   public void setSkillSharingBoardReplyDao(
         SkillSharingBoardReplyDao skillSharingBoardReplyDao) {
      this.skillSharingBoardReplyDao = skillSharingBoardReplyDao;
   }

   public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReplyList()
         throws SQLException {
      List<SkillSharingBoardReplyVo> list = new ArrayList<SkillSharingBoardReplyVo>();
      
      list = skillSharingBoardReplyDao.selectSkillSharingBoardReplyList();
      
      return list;
   }
   
   public SkillSharingBoardReplyVo selectSSBR(int ssb_Reply_Num) throws SQLException {
	   SkillSharingBoardReplyVo skillSharingBoardReplyVo = skillSharingBoardReplyDao.selectSSBR(ssb_Reply_Num);
		return skillSharingBoardReplyVo;
	}
   
   public List<SkillSharingBoardReplyVo> selectSkillSharingBoardReply(
         int ssb_Article_Num) throws SQLException {
      List<SkillSharingBoardReplyVo> list = new ArrayList<SkillSharingBoardReplyVo>(); 
      list=skillSharingBoardReplyDao.selectSkillSharingBoardReply(ssb_Article_Num);
      return list;
   }
   
   
   public void insertSkillSharingBoardReply(
         SkillSharingBoardReplyVo skillSharingBoardReplyVo)
         throws SQLException {
      
      skillSharingBoardReplyDao.insertSkillSharingBoardReply(skillSharingBoardReplyVo);
      
   }

   
   public void updateSkillSharingBoardReply(
         SkillSharingBoardReplyVo skillSharingBoardReplyVo)
         throws SQLException {
      
      skillSharingBoardReplyDao.updateSkillSharingBoardReply(skillSharingBoardReplyVo);
      
   }

   
   public void deleteSkillSharingBoardReply(int ssb_Article_Num)
         throws SQLException {
      
      skillSharingBoardReplyDao.deleteSkillSharingBoardReply(ssb_Article_Num);
      
   }
   
   
}