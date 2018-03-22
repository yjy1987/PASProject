package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.app.pas.dao.board.ProjectBoardReplyDao;
import com.app.pas.dto.board.ProjectBoardReplyVo;



public class ProjectBoardReplyService {

	private ProjectBoardReplyDao projectBoardReplyDao;
	
	public void setProjectBoardReplyDao(ProjectBoardReplyDao projectBoardReplyDao){
		this.projectBoardReplyDao = projectBoardReplyDao;
	}
	
	public List<ProjectBoardReplyVo> insertProjectBoardReply(ProjectBoardReplyVo projectBoardReplyVo)throws SQLException{
		projectBoardReplyDao.insertProjectBoardReply(projectBoardReplyVo);
		
		List<ProjectBoardReplyVo> list = projectBoardReplyDao.selectProjectBoardReply(projectBoardReplyVo.getPb_Article_Num());
		return list;
		
	}
	
	public List<ProjectBoardReplyVo> selectProjectBoardReply(int pb_Article_num) throws SQLException{
		List<ProjectBoardReplyVo> list = projectBoardReplyDao.selectProjectBoardReply(pb_Article_num);
		return list;
	}
	
	public void deleteProjectBoardReply(int pb_Reply_Num) throws SQLException{
		projectBoardReplyDao.deleteProjectBoardReply(pb_Reply_Num);
	}
}
