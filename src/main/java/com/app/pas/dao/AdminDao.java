package com.app.pas.dao;

import java.sql.SQLException;

import com.app.pas.dto.AdminVo;

public interface AdminDao {
	public AdminVo selectAdmin(String admin_Email)throws SQLException;
	public void insertAdmin(AdminVo adminVo)throws SQLException;
	public void updateAdmin(AdminVo adminVo)throws SQLException;
	public void deleteAdmin(String admin_Email)throws SQLException;	
}
