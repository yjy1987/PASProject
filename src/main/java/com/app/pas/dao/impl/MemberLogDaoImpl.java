package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.MemberLogDao;
import com.app.pas.dto.MemberLogCommand;
import com.app.pas.dto.MemberLogVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberLogDaoImpl implements MemberLogDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public void insertMemberLog(MemberLogVo memberLogVo) throws SQLException {
		client.insert("insertMemberLog",memberLogVo);
	}

	@Override
	public MemberLogVo selectLastMemberLogByEmail(String mem_Email) throws SQLException {
		MemberLogVo log = (MemberLogVo) client.queryForObject("selectLastMemberLogByEmail", mem_Email);
		return log;
	}

	@Override
	public List<MemberLogCommand> selectWeeklyLogCount() throws SQLException {
		List<MemberLogCommand> list = client.queryForList("selectWeeklyLogCount",null);
		return list;
	}

}
