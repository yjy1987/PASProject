package com.app.pas.dao;

import java.sql.SQLException;
import java.util.List;


import com.app.pas.dto.WeeklyCheckVo;

public interface WeeklyCheckDao {
	
	public List<WeeklyCheckVo> weeklyCheck_Select(WeeklyCheckVo weeklyCheckVo) throws SQLException;
	public void weeklyCheck_Update(WeeklyCheckVo weeklyCheckVo) throws SQLException;
	public void weeklyCheck_Delete(WeeklyCheckVo weeklyCheckVo) throws SQLException;
	public void weeklyCheck_YN(WeeklyCheckVo weeklyCheckVo) throws SQLException; 
	public void wk_UpdateSuccess(WeeklyCheckVo weeklyCheckVo) throws SQLException;
	public int selectWkYnY(int proj_Num)throws SQLException;
	public int selectWkYnN(int proj_Num)throws SQLException;
}
