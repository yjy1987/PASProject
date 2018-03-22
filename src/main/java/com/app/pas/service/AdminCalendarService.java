package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.AdminCalendarDao;
import com.app.pas.dto.AdminCalendarVo;

public class AdminCalendarService {

	
	AdminCalendarDao adminCalendarDao;

	public void setAdminCalendarDao(AdminCalendarDao adminCalendarDao) {
		this.adminCalendarDao = adminCalendarDao;
	}
	
	public List<AdminCalendarVo> selectAdminCalendar () throws SQLException{
		List<AdminCalendarVo> list = adminCalendarDao.selectAdminCalendar();
		return list;
	}
	
	public void insertAdminCalendar(AdminCalendarVo adminCalendarVo) throws SQLException{
		adminCalendarDao.insertAdminCalendar(adminCalendarVo);
	}
}
