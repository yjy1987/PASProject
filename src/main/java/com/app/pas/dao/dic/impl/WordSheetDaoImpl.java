package com.app.pas.dao.dic.impl;

import java.sql.SQLException;

import com.app.pas.dao.dic.WordSheetDao;
import com.app.pas.dto.dic.WordSheetVo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class WordSheetDaoImpl implements WordSheetDao{

	SqlMapClient client;
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	

	@Override
	public void insertWordSheet(WordSheetVo wordSheetVo) throws SQLException {
		client.update("insertWordSheet", wordSheetVo);
		
	}


	@Override
	public WordSheetVo selectWordSheetByDocNum(int doc_Num) throws SQLException {
    WordSheetVo wordSheetVo =(WordSheetVo) client.queryForObject("selectWordSheetByDocNum", doc_Num);
		return wordSheetVo;
	}


	@Override
	public void updateWordSheet(WordSheetVo wordSheetVo) throws SQLException {
		client.update("updateWordSheet", wordSheetVo);
		
	}

}
