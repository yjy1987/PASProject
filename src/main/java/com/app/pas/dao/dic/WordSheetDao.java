package com.app.pas.dao.dic;

import java.sql.SQLException;

import com.app.pas.dto.dic.WordSheetVo;

public interface WordSheetDao {
  
	
	public void insertWordSheet(WordSheetVo wordSheetVo)throws SQLException; 
	public WordSheetVo selectWordSheetByDocNum(int doc_Num)throws SQLException;
	public void updateWordSheet(WordSheetVo wordSheetVo)throws SQLException;

}
