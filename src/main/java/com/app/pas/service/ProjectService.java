package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ApplyDao;
import com.app.pas.dao.MemberDao;
import com.app.pas.dao.ProjectDao;
import com.app.pas.dao.ProjectJoinDao;
import com.app.pas.dto.ApplyVo;
import com.app.pas.dto.MemApplyViewVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectVo;

public class ProjectService {

	private ProjectDao projectDao;
	private ApplyDao applyDao;
	private ProjectJoinDao projectJoinDao;
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setProjectJoinDao(ProjectJoinDao projectJoinDao) {
		this.projectJoinDao = projectJoinDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	

	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}
//내가 참여한 프로젝트 리스트 
	public List<ProjectVo> selectMyProjectListById(ProjectVo projectVo)
			throws SQLException {
		List<ProjectVo> list = projectDao.selectMyProjectListById(projectVo);
		return list;
	}

	public List<ProjectVo> selectOtherProjectList() throws SQLException {
		List<ProjectVo> list = projectDao.selectProjectList();
		return list;

	}
	
	public List<ProjectVo> selectProjectList2(String proj_Name) throws SQLException {
		List<ProjectVo> list = projectDao.selectProjectList2(proj_Name);
		return list;
	}
	
	public List<ProjectVo> selectProjectList() throws SQLException{
		List<ProjectVo> list = projectDao.selectProjectList();
		return list;
	}
	public int selectProjectTotalCount() throws SQLException {
		int totalCount = projectDao.selectProjectTotalCount();
		return totalCount;
	}
	
	public List<MemPositionViewVo> selectMemPositionViewListByProjNum(int proj_Num) throws SQLException{
		List<MemPositionViewVo> list = projectDao.selectMemPositionViewListByProjNum(proj_Num);
		return list;
	}

	public List<ProjectVo> selectOtherProjectListById(ProjectVo projectVo) throws SQLException{
		List<ProjectVo> list = projectDao.selectOtherProjectListById(projectVo);
		return list;
	}
	
	public MemApplyViewVo insertApply(ApplyVo applyVo,ProjectJoinVo projectJoinVo,MemApplyViewVo memApplyViewVo) throws SQLException{
		applyDao.insertApply(applyVo);
		projectJoinDao.insertProjectJoin(projectJoinVo);
		memApplyViewVo = memberDao.selectMemApplyViewByMemProj(memApplyViewVo);
		return memApplyViewVo;
	}
	
	public int insertProject(ProjectVo projectVo,ProjectJoinVo projectJoinVo) throws SQLException{
		projectDao.insertProject(projectVo);
		ProjectVo project = projectDao.selectLastInsertProject(projectVo.getMem_Email());
		projectJoinVo.setProj_Num(project.getProj_Num());
		projectJoinDao.insertProjectJoin(projectJoinVo);
		projectJoinDao.updateProjectJoin(projectJoinVo);
		return project.getProj_Num();
	}
	
	public ProjectVo selectProject(int proj_Num) throws SQLException{
		ProjectVo projectVo =projectDao.selectProject(proj_Num);
		return projectVo;
	}
	
	public void updateProjectImg(ProjectVo projectVo) throws SQLException {
		projectDao.updateProjectImg(projectVo);
	}

	public void updateProjectColor(ProjectVo projectVo) throws SQLException{
		projectDao.updateProjectColor(projectVo);

	}
	public void deleteProject(int proj_Num) throws SQLException {
		projectDao.deleteProject(proj_Num);
	}
	
	public List<Integer> selectInviteProjNumByMemEmail(String mem_Email) throws SQLException{ 
		 
	List<Integer> list =	projectDao.selectInviteProjNumByMemEmail(mem_Email);
		return list;
	}
	public List<ProjectJoinVo> selectMemberToProjNum(int proj_Num) throws SQLException {
		List<ProjectJoinVo> list = projectDao.selectMemberToProjNum(proj_Num);
		return list;
	}
	
	public List<ProjectVo>selectProjCreateToday()throws SQLException{
		List<ProjectVo>projCreateList = projectDao.selectProjCreateToday();
		return projCreateList;
		}
	
	
}
