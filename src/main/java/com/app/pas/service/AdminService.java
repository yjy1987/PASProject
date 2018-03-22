package com.app.pas.service;

import java.sql.SQLException;

import com.app.pas.dao.AdminDao;
import com.app.pas.dto.AdminVo;

public class AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public AdminVo getAdmin(String admin_Email) throws SQLException {
		AdminVo adminVo = null;
		
		adminVo = adminDao.selectAdmin(admin_Email);
		
		return adminVo;
	}
	
}
