package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ScheduleCalendarVo;

public interface ScheduleCalendarDao {
	public List<ScheduleCalendarVo> selectScheduleCalendarList(int sc_Proj_Num)throws SQLException;
	public void insertScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo)throws SQLException;
	public int deleteScheduleCalendar(int sc_Num)throws SQLException;
	public void updateScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo) throws SQLException;
	public void updateScheduleCalendarColor(ScheduleCalendarVo scheduleCalendarVo) throws SQLException;
	public ScheduleCalendarVo selectScheduleCalendarByScNum(int sc_Num)throws SQLException;
	
	public List<ScheduleCalendarVo> selectWeeklylist_Start(ScheduleCalendarVo scheduleCalendarVo) throws SQLException;
	public List<ScheduleCalendarVo> selectWeeklylist_End(ScheduleCalendarVo scheduleCalendarVo) throws SQLException;
	public List<ScheduleCalendarVo> weekly_date()throws SQLException;
	public int selectScheduleCount(int proj_Num)throws SQLException;

}
