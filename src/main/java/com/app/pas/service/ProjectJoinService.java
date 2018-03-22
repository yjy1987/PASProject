package com.app.pas.service;

import java.sql.SQLException;

import com.app.pas.dao.ProjectJoinDao;
import com.app.pas.dto.ProjectJoinVo;

public class ProjectJoinService {

	
	private ProjectJoinDao projectjoinDao;

	public void setProjectjoinDao(ProjectJoinDao projectjoinDao) {
		this.projectjoinDao = projectjoinDao;
	}
	public void insertProject(ProjectJoinVo projectjoinVo) throws SQLException{
		projectjoinDao.insertProjectJoin(projectjoinVo);
	}
	
	public void deleteProjectJoin(ProjectJoinVo projectJoinVo) throws SQLException{
		projectjoinDao.deleteProjectJoin(projectJoinVo);
	}
	
	public void updateProjectJoinColor(ProjectJoinVo projectJoinVo) throws SQLException{
		projectjoinDao.updateProjectJoinColor(projectJoinVo);
	}
	
	public void updatePosition(ProjectJoinVo projectJoinVo) throws SQLException{
		projectjoinDao.updatePosition(projectJoinVo);
	}

	public int selectJoinCountMember(int proj_Num) throws SQLException {
		int count = projectjoinDao.selectJoinCountMember(proj_Num);
		return count;
	}

	public ProjectJoinVo selectProjectJoin(ProjectJoinVo projectJoinVo) throws SQLException{
		ProjectJoinVo proj =projectjoinDao.selectProjectJoin(projectJoinVo);
	     return proj;

	}
}
