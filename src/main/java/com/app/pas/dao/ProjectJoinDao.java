package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectVo;

public interface ProjectJoinDao {
	public List<ProjectJoinVo> selectProjectJoinList()throws SQLException;
	public ProjectJoinVo selectProjectJoin(ProjectJoinVo projectJoinVo)throws SQLException;
	public void insertProjectJoin(ProjectJoinVo projectJoinVo)throws SQLException;
	public void updateProjectJoin(ProjectJoinVo projectJoinVo)throws SQLException;
	public void deleteProjectJoin(ProjectJoinVo projectJoinVo)throws SQLException;
	public void updateProjectJoinColor(ProjectJoinVo projectJoinVo) throws SQLException;
	public void updatePosition(ProjectJoinVo projectJoinVo) throws SQLException;
	public int selectJoinCountMember(int proj_Num) throws SQLException;
}
