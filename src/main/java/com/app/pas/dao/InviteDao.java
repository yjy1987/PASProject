package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.InviteVo;
import com.app.pas.dto.ProjInviteViewVo;

public interface InviteDao {
	public List<InviteVo> selectInviteList()throws SQLException;
	public void insertInvite(InviteVo inviteVo)throws SQLException;
	public void updateInvite(InviteVo inviteVo)throws SQLException;
	public void deleteInvite(InviteVo inviteVo)throws SQLException;
	public List<ProjInviteViewVo> selectInviteList(ProjInviteViewVo projInviteViewVo)throws SQLException;
	public List<ProjInviteViewVo> selectInviteListByMemEmail(String mem_Email) throws SQLException;
	public void updateInviteCommitCheck(InviteVo inviteVo) throws SQLException;
	public InviteVo selectInvite(int invite_Num) throws SQLException;
	public int selectInviteCount(String mem_Email) throws SQLException;
	public int selectCountProjInviteView(InviteVo inviteVo) throws SQLException;
}
