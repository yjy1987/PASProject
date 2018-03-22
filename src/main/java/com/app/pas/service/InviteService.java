package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.commons.interceptor.ProjectInterceptor;
import com.app.pas.dao.InviteDao;
import com.app.pas.dao.ProjectJoinDao;
import com.app.pas.dto.InviteVo;
import com.app.pas.dto.MemApplyViewVo;
import com.app.pas.dto.ProjInviteViewVo;
import com.app.pas.dto.ProjectJoinVo;

public class InviteService {
	
	private InviteDao inviteDao;
	private ProjectJoinDao projectJoinDao;
	
	public void setProjectJoinDao(ProjectJoinDao projectJoinDao) {
		this.projectJoinDao = projectJoinDao;
	}

	public void setInviteDao(InviteDao inviteDao) {
		this.inviteDao = inviteDao;
	}
	
	public List<ProjInviteViewVo> selectInviteList(ProjInviteViewVo projInviteViewVo) throws SQLException{
       List<ProjInviteViewVo> list = inviteDao.selectInviteList(projInviteViewVo); 
		return list;
		
	}
	
	public void insertInvite(InviteVo inviteVo) throws SQLException{
		inviteDao.insertInvite(inviteVo);
	}
	
	public void deleteInvite(InviteVo inviteVo) throws SQLException {
		inviteDao.deleteInvite(inviteVo);
	}
	
	public List<ProjInviteViewVo> selectInviteListByMemEmail(String mem_Email) throws SQLException{
		List<ProjInviteViewVo> list = inviteDao.selectInviteListByMemEmail(mem_Email);
		return list;
	}

	public List<ProjInviteViewVo> updataInviteAgree(int invite_Num) throws SQLException{
		InviteVo inviteVo= inviteDao.selectInvite(invite_Num);
		inviteDao.updateInviteCommitCheck(inviteVo);
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		projectJoinVo.setMem_Email(inviteVo.getMem_Email());
		projectJoinVo.setProj_Num(inviteVo.getProj_Num());
		projectJoinVo.setPjj_Per_Num(1);
		projectJoinVo.setPosition_Num(9);
		projectJoinDao.updateProjectJoin(projectJoinVo);
		List<ProjInviteViewVo> list = inviteDao.selectInviteListByMemEmail(inviteVo.getMem_Email());
		
		return list;
	}
	
	public List<ProjInviteViewVo> updataInviteReject(int invite_Num)throws SQLException{
		InviteVo inviteVo= inviteDao.selectInvite(invite_Num);
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		projectJoinVo.setMem_Email(inviteVo.getMem_Email());
		projectJoinVo.setProj_Num(inviteVo.getProj_Num());
		projectJoinDao.deleteProjectJoin(projectJoinVo);
		inviteDao.deleteInvite(inviteVo);
		List<ProjInviteViewVo> list = inviteDao.selectInviteListByMemEmail(inviteVo.getMem_Email());
		
		return list;
	}
	
	public int selectInviteCount(String mem_Email) throws SQLException{
		int count = inviteDao.selectInviteCount(mem_Email);
		return count;
	}
	
	public int selectCountProjInviteView(InviteVo inviteVo) throws SQLException{
		int resultCount = inviteDao.selectCountProjInviteView(inviteVo);
		return resultCount;
	}
}
