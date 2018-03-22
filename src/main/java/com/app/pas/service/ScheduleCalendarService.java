package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ScheduleCalendarDao;
import com.app.pas.dto.ScheduleCalendarVo;


public class ScheduleCalendarService {

	private ScheduleCalendarDao scheduleCalendarDao;

	public void setScheduleCalendarDao(ScheduleCalendarDao scheduleCalendarDao) {
		this.scheduleCalendarDao = scheduleCalendarDao;
	}

	public List<ScheduleCalendarVo> selectScheduleCalendarList(int sc_Proj_Num)
			throws SQLException {

		List<ScheduleCalendarVo> list = scheduleCalendarDao
				.selectScheduleCalendarList(sc_Proj_Num);
		return list;
	}

	public void insertScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo)
			throws SQLException {
		scheduleCalendarDao.insertScheduleCalendar(scheduleCalendarVo);
	}

	public void updateScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo)
			throws SQLException {
		scheduleCalendarDao.updateScheduleCalendar(scheduleCalendarVo);
	}

	public int deleteScheduleCalendar(int sc_Num) throws SQLException {
		int flag = scheduleCalendarDao.deleteScheduleCalendar(sc_Num);
		return flag;
	}

	public void updateScheduleCalendarColor(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		scheduleCalendarDao.updateScheduleCalendarColor(scheduleCalendarVo);
	}

	public ScheduleCalendarVo selectScheduleCalendarByScNum(int sc_Num)
			throws SQLException {
		return (ScheduleCalendarVo) scheduleCalendarDao
				.selectScheduleCalendarByScNum(sc_Num);
	}

	public List<ScheduleCalendarVo> selectWeeklylist_Start(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		List<ScheduleCalendarVo> list = scheduleCalendarDao
				.selectWeeklylist_Start(scheduleCalendarVo);
		return list;
	}

	// 마감하는 일감보기
	public List<ScheduleCalendarVo> selectWeeklylist_End(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		List<ScheduleCalendarVo> list = scheduleCalendarDao
				.selectWeeklylist_End(scheduleCalendarVo);
		return list;
	}

	public  List<ScheduleCalendarVo> weekly_date() throws SQLException {
		List<ScheduleCalendarVo> list  = scheduleCalendarDao.weekly_date();
		return list;
		
	}
	public int selectScheduleCount(int proj_Num) throws SQLException {
		int count = scheduleCalendarDao.selectScheduleCount(proj_Num); 
		return count;
	}
}
