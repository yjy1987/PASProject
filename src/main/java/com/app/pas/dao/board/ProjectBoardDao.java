package com.app.pas.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.ProjectBoardVo;

public interface ProjectBoardDao {
	
	public List<ProjectBoardVo> selectProjectBoardList(int proj_Num)throws SQLException;
	public ProjectBoardVo selectProjectBoard(int pb_Article_Num)throws SQLException;
	public ProjectBoardVo updateFormProjectBoard(int pb_Atricle_Num) throws SQLException;
	public List<ProjectBoardVo> selectProjectBoardListV(int pb_Article_Num)throws SQLException;
	public void insertProjectBoard(ProjectBoardVo projectBoardVo)throws SQLException;
	public void updateProjectBoard(ProjectBoardVo projectBoardVo)throws SQLException;
	public void deleteProjectBoard(int pb_Article_Num)throws SQLException;
	public ProjectBoardVo selectProjectBoardDetail(int pb_Article_Num) throws SQLException;
	public int selectPBTotalCount() throws SQLException;
	public List<ProjectBoardVo> myProjectList(String mem_Email)throws SQLException;
}
