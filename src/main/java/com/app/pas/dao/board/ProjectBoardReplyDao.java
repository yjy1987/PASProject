package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.ProjectBoardReplyVo;



public interface ProjectBoardReplyDao {
	
	public List<ProjectBoardReplyVo> selectProjectBoardReply(int pb_Article_num)throws SQLException;
	public void insertProjectBoardReply(ProjectBoardReplyVo projectBoardReplyVo)throws SQLException;
	public void updateProjectBoardReply(ProjectBoardReplyVo projectBoardReplyVo)throws SQLException;
	public void deleteProjectBoardReply(int pb_Reply_Num)throws SQLException;
}
