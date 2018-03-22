package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectVo;

public interface ProjectDao {
	public List<ProjectVo> selectProjectList()throws SQLException;
	public List<ProjectVo> selectProjectList2(String proj_Name)throws SQLException;
	public ProjectVo selectProject(int proj_Num)throws SQLException;
	public void insertProject(ProjectVo projectVo)throws SQLException;
	public void updateProject(ProjectVo projectVo)throws SQLException;
	public void deleteProject(int proj_Num)throws SQLException;
	public List<MemPositionViewVo> selectMemPositionViewListByProjNum(int proj_Num) throws SQLException;
	public List<ProjectVo> selectMyProjectListById(ProjectVo projectVo)throws SQLException;
	public List<ProjectVo> selectOtherProjectListById(ProjectVo projectVo) throws SQLException;
	public ProjectVo selectLastInsertProject(String mem_Email) throws SQLException;
	public void updateProjectImg(ProjectVo projectVo) throws SQLException;
	public int selectProjectTotalCount() throws SQLException;
	public void updateProjectColor(ProjectVo projectVo) throws SQLException;
	public List<Integer> selectInviteProjNumByMemEmail(String mem_Email) throws SQLException; 
	public List<ProjectJoinVo> selectMemberToProjNum(int proj_Num)throws SQLException;
	public List<ProjectVo>selectProjCreateToday()throws SQLException;

}
