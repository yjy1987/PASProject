package com.app.pas.dao.dic.impl;

import java.sql.SQLException;

import com.app.pas.dao.dic.SpreadSheetDao;
import com.app.pas.dto.dic.SpreadSheetVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SpreadSheetDaoImpl implements SpreadSheetDao {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public int insertSpreadSheet(SpreadSheetVo spreadSheetVo)
			throws SQLException {
		int result = (Integer) client.update("insertSpreadSheet", spreadSheetVo);
		return result;
	}
	@Override
	public SpreadSheetVo selectSpreadSheetByDocNum(int doc_Num)
			throws SQLException {
		SpreadSheetVo spreadSheetVo = (SpreadSheetVo) client.queryForObject("selectSpreadSheetByDocNum", doc_Num);
		return spreadSheetVo;
	}
	@Override
	public int updateSpreadSheet(SpreadSheetVo spreadSheetVo)
			throws SQLException {
		return client.update("updateSpreadSheet",spreadSheetVo);
	}

}
