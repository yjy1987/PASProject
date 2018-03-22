package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ProjectLogDao;
import com.app.pas.dto.MemberLogCommand;
import com.app.pas.dto.ProjLogCommand;
import com.app.pas.dto.ProjectLogVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProjectLogDaoImpl implements ProjectLogDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void insertProjectLog(ProjectLogVo projectLogVo) throws SQLException {
		client.insert("insertProjectLog",projectLogVo);
		
	}

	@Override
	public ProjectLogVo selectLastProjectLogList(ProjectLogVo projectLogVo)
			throws SQLException {
		ProjectLogVo resultVo =(ProjectLogVo) client.queryForObject("selectLastProjectLogList",projectLogVo);
		return resultVo;
	}

	@Override
	public List<ProjLogCommand> selectWeekLogCount(int proj_Num) throws SQLException {
		List<ProjLogCommand> list = client.queryForList("selectWeekLogCount",proj_Num);
		return list;
	}

}
