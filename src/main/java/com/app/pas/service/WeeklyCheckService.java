package com.app.pas.service;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.WeeklyCheckDao;
import com.app.pas.dto.WeeklyCheckVo;

public class WeeklyCheckService {
	
	private WeeklyCheckDao weeklyCheckDao;

	public void setWeeklyCheckDao(WeeklyCheckDao weeklyCheckDao) {
		this.weeklyCheckDao = weeklyCheckDao;
	}
	
	public List<WeeklyCheckVo> weeklyCheck (WeeklyCheckVo weeklyCheckVo) throws SQLException{
		List<WeeklyCheckVo> list = weeklyCheckDao.weeklyCheck_Select(weeklyCheckVo);
		return list;
	}
//------------------------------------------------------------------------------------------	
	public void weeklyCheck_Update(WeeklyCheckVo weeklyCheckVo) throws SQLException{
		weeklyCheckDao.weeklyCheck_Update(weeklyCheckVo);
	}
	
//삭제 
	public void weeklyCheck_Delete(WeeklyCheckVo weeklyCheckVo) throws SQLException{
		weeklyCheckDao.weeklyCheck_Delete(weeklyCheckVo);
	}
//Y or N
	public void weeklyCheck_YN(WeeklyCheckVo weeklyCheckVo)throws SQLException{
		weeklyCheckDao.weeklyCheck_YN(weeklyCheckVo);
	}
	
	public void wk_UpdateSuccess(WeeklyCheckVo weeklyCheckVo) throws SQLException{
		weeklyCheckDao.wk_UpdateSuccess(weeklyCheckVo);
	}
	
	public int selectWkYnY(int proj_Num) throws SQLException {
		int wkY = (Integer) weeklyCheckDao.selectWkYnY(proj_Num);
		return wkY;
	}

	public int selectWkYnN(int proj_Num) throws SQLException {
		int wkN = (Integer) weeklyCheckDao.selectWkYnN(proj_Num);
		return wkN;
	}

}
