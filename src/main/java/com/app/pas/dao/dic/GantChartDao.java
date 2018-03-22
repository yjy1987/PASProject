package com.app.pas.dao.dic;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.dic.GantChartVo;

public interface GantChartDao {
	public List<GantChartVo> selectGantChart(int proj_Num) throws SQLException;
	public int insertGantChart(GantChartVo gantChartVo) throws SQLException;
	public int deleteGantChart(int proj_Num) throws SQLException;
}
