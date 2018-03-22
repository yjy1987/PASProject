package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.MainDao;
import com.app.pas.dto.MyPostBoardVo;
import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.QnaBoardVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardVo;

public class MainService {
	private MainDao mainDao;
	
	
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	//내가 쓴 Qna게시물 보기 
	public QnaBoardVo myPostBoard_Qna(QnaBoardVo qnaBoardVo)throws SQLException{
		QnaBoardVo list = mainDao.myPostBoard_Qna(qnaBoardVo);
		return list;
		
	}
	//커뮤니티
	public FreeBoardVo myPostBoard_frb(FreeBoardVo freeBoardVo) throws SQLException{
		FreeBoardVo freeBoardVO = mainDao.myPostBoard_frb(freeBoardVo);
		return freeBoardVO;
	}
	
	public void myPostUpdate_frb (FreeBoardVo freeBoardVo) throws SQLException{
		mainDao.myPostUpdate_frb(freeBoardVo);
	}

	
	
	//내가쓴 기술공유게시물 보기
	public SkillSharingBoardVo myPostBoard_Skill(SkillSharingBoardVo skillSharingBoardVo) throws SQLException{
		SkillSharingBoardVo skillSharingBoardVO = (SkillSharingBoardVo)mainDao.myPostBoard_Skill(skillSharingBoardVo); 
		return skillSharingBoardVO;
		
	}
	
//	//수정
//	public void myPostUpdate_skill(SkillSharingBoardVo skillSharingBoardVo)throws SQLException{
//		mainDao.myPostUpdate_skill(skillSharingBoardVo);
//	}

	
	public List<MyPostBoardVo>MyPostBoard(MyPostBoardVo myPostBoardVo)throws SQLException{
		List<MyPostBoardVo>list = mainDao.MyPostBoard(myPostBoardVo);
		return list;
	}
	

}
