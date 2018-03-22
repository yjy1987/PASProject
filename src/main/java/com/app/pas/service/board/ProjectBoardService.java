package com.app.pas.service.board;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.board.ProjectBoardDao;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.ProjectBoardVo;

public class ProjectBoardService {

	private ProjectBoardDao projectboardDao;

	public void setProjectboardDao(ProjectBoardDao projectboardDao) {
		this.projectboardDao = projectboardDao;
	}
//boardList	
	public List<ProjectBoardVo> selectProjectBoardList(int proj_Num) throws SQLException{
		List<ProjectBoardVo> list = projectboardDao.selectProjectBoardList(proj_Num);
	
		return list;
	}
	
	public ProjectBoardVo selectProjectBoardDetail(int pb_Article_Num)throws SQLException{
		ProjectBoardVo projectBoardVo = null;
		projectBoardVo = projectboardDao.selectProjectBoardDetail(pb_Article_Num);
		return projectBoardVo;
	}
	
	
	public void insertProjectBoard(ProjectBoardVo projectBoardVo)throws SQLException{
		projectboardDao.insertProjectBoard(projectBoardVo);
		
	}
//내가쓴글 보기 
	public List<ProjectBoardVo> myProjectList (String mem_Email) throws SQLException{
		List <ProjectBoardVo> pbList = projectboardDao.myProjectList(mem_Email);
	
		return pbList;
	}
	
	public void deleteProjectBoard(int pb_Article_Num)throws SQLException{
		projectboardDao.deleteProjectBoard(pb_Article_Num);
	}
//글 수정 폼
	public ProjectBoardVo updateFormProjectBoard(int pb_Article_Num)throws SQLException{
		ProjectBoardVo projectBoardVo = projectboardDao.updateFormProjectBoard(pb_Article_Num);
		
		return projectBoardVo;
		
	}
	
//글수정	
	public void updateProjectBoard(ProjectBoardVo projectBoardVo)throws SQLException{
		projectboardDao.updateProjectBoard(projectBoardVo);
	}
	
	public List<ProjectBoardVo> selectProjectBoardListV(int pb_Article_Num) throws SQLException{
		List<ProjectBoardVo> list = projectboardDao.selectProjectBoardListV(pb_Article_Num);
		return list;
	}
	public int selectPBTotalCount() throws SQLException{
		int pbTotalCount = projectboardDao.selectPBTotalCount();
		return pbTotalCount;
	}
}
