package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.InviteDao;
import com.app.pas.dto.InviteVo;
import com.app.pas.dto.ProjInviteViewVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class InviteDaoImpl implements InviteDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<InviteVo> selectInviteList() throws SQLException {
		List<InviteVo> list = client.queryForList("selectInviteList");
		return list;
	}

	@Override
	public void insertInvite(InviteVo inviteVo) throws SQLException {
		client.insert("insertInvite",inviteVo);
	}

	@Override
	public void updateInvite(InviteVo inviteVo) throws SQLException {
		client.update("updateInvite",inviteVo);
	}

	@Override
	public void deleteInvite(InviteVo inviteVo) throws SQLException {
		client.update("deleteInvite",inviteVo);
	}

	@Override
	public List<ProjInviteViewVo> selectInviteList(ProjInviteViewVo projInviteViewVo) throws SQLException {
		List<ProjInviteViewVo> list =client.queryForList("selectInviteList", projInviteViewVo);
		return list;
	}

	@Override
	public List<ProjInviteViewVo> selectInviteListByMemEmail(String mem_Email)
			throws SQLException {
		List<ProjInviteViewVo> list = client.queryForList("selectInviteListByMemEmail",mem_Email);
		return list;
	}

	@Override
	public void updateInviteCommitCheck(InviteVo inviteVo) throws SQLException {
		client.update("updateInviteCommitCheck",inviteVo);
	}

	@Override
	public InviteVo selectInvite(int invite_Num) throws SQLException {
		InviteVo inviteVo = (InviteVo) client.queryForObject("selectInvite",invite_Num);
		return inviteVo;
	}

	@Override
	public int selectInviteCount(String mem_Email) throws SQLException {
		int count = (Integer) client.queryForObject("selectInviteCount",mem_Email);
		return count;
	}

	@Override
	public int selectCountProjInviteView(InviteVo inviteVo) throws SQLException {
		int resultCount = (Integer) client.queryForObject("selectCountProjInviteView",inviteVo);
		return resultCount;
	}
}
