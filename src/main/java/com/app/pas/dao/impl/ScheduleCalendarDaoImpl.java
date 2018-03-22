package com.app.pas.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.ScheduleCalendarDao;
import com.app.pas.dto.ScheduleCalendarVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ScheduleCalendarDaoImpl implements ScheduleCalendarDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public List<ScheduleCalendarVo> selectScheduleCalendarList(int sc_Proj_Num)
			throws SQLException {
		List<ScheduleCalendarVo> list = client.queryForList("selectScheduleCalendarList",sc_Proj_Num);
		return list;
	}

	@Override
	public void insertScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo)
			throws SQLException {
		client.insert("insertScheduleCalendar",scheduleCalendarVo);
		
	}

	
	@Override
	public int deleteScheduleCalendar(int sc_Num) throws SQLException {
		int flag = client.update("deleteScheduleCalendar",sc_Num);
		return flag;
	}

	@Override
	public void updateScheduleCalendar(ScheduleCalendarVo scheduleCalendarVo)
			throws SQLException {
		client.update("updateScheduleCalendar",scheduleCalendarVo);
		
	}

	@Override
	public void updateScheduleCalendarColor(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		client.update("updateScheduleCalendarColor",scheduleCalendarVo);
		
	}

	@Override
	public ScheduleCalendarVo selectScheduleCalendarByScNum(int sc_Num)
			throws SQLException {
		ScheduleCalendarVo scheduleCalendarVo = (ScheduleCalendarVo) client.queryForObject("selectScheduleCalendarByScNum",sc_Num);
		return scheduleCalendarVo;
	}
	@Override
	public List<ScheduleCalendarVo> selectWeeklylist_Start(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		List<ScheduleCalendarVo> list  = client.queryForList("selectWeeklylist_Start", scheduleCalendarVo);
		System.out.println("임플 :"+list);
		return list;
	}
//주간체크리스트 마감하는 일감보기
	@Override
	public List<ScheduleCalendarVo> selectWeeklylist_End(
			ScheduleCalendarVo scheduleCalendarVo) throws SQLException {
		List<ScheduleCalendarVo> list = client.queryForList("selectWeeklylist_End",scheduleCalendarVo);
		return list;
	}

@Override
public List<ScheduleCalendarVo> weekly_date() throws SQLException {
	List<ScheduleCalendarVo> list  =  client.queryForList("weekly_date");
	return list;
}

@Override
public int selectScheduleCount(int proj_Num) throws SQLException {
	int count = (Integer) client.queryForObject("selectScheduleCount",proj_Num);
	return count;
}



}
