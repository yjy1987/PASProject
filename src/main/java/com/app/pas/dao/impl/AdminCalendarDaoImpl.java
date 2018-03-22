package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.AdminCalendarDao;
import com.app.pas.dto.AdminCalendarVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AdminCalendarDaoImpl implements AdminCalendarDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public void insertAdminCalendar(AdminCalendarVo adminCalendarVo)
			throws SQLException {
		client.update("insertAdminCalendar",adminCalendarVo);
	}
	@Override
	public List<AdminCalendarVo> selectAdminCalendar() throws SQLException {
		List<AdminCalendarVo> list = client.queryForList("selectAdminCalendar",null);
		return list;
	}

}
