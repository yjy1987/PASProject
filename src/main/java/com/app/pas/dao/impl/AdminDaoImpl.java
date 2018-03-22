package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.AdminDao;
import com.app.pas.dto.AdminVo;
import com.ibatis.sqlmap.client.SqlMapClient;


public class AdminDaoImpl implements AdminDao {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public AdminVo selectAdmin(String admin_Email) throws SQLException {
		AdminVo adminVo = (AdminVo) client.queryForObject("selectAdmin",admin_Email);
		return adminVo;
	}

	@Override
	public void insertAdmin(AdminVo adminVo) throws SQLException {
		client.insert("insertAdmin",adminVo);
	}

	@Override
	public void updateAdmin(AdminVo adminVo) throws SQLException {
		client.update("updateAdmin",adminVo);
	}

	@Override
	public void deleteAdmin(String admin_Email) throws SQLException {
		client.delete("deleteAdmin",admin_Email);
	}

	
}
