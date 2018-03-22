package com.app.pas.dao.dic.impl;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.dic.GantChartDao;
import com.app.pas.dto.dic.GantChartVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class GantChartDaoImpl implements GantChartDao{
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public List<GantChartVo> selectGantChart(int proj_Num) throws SQLException {
		List<GantChartVo> list = (List<GantChartVo>) client.queryForList("selectGantChart",proj_Num);
		return list;
	}
	@Override
	public int insertGantChart(GantChartVo gantChartVo) throws SQLException {
		int result = client.update("insertGantChart",gantChartVo);
		return result;
	}
	@Override
	public int deleteGantChart(int proj_Num) throws SQLException {
		int result = client.update("deleteGantChart",proj_Num);
		return result;
	}

}
