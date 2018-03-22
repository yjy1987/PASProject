package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.AdminCalendarVo;

public interface AdminCalendarDao {

	public void insertAdminCalendar(AdminCalendarVo adminCalendarVo) throws SQLException;
	public List<AdminCalendarVo> selectAdminCalendar() throws SQLException;
}
