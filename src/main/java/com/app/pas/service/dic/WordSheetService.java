package com.app.pas.service.dic;

import java.sql.SQLException;

import com.app.pas.dao.dic.WordSheetDao;
import com.app.pas.dto.dic.WordSheetVo;

public class WordSheetService {
	
	private WordSheetDao wordSheetDao;

	
	
	
	public void setWordSheetDao(WordSheetDao wordSheetDao) {
		this.wordSheetDao = wordSheetDao;
	}




	public WordSheetVo selectWordSheetByDocNum(int doc_Num) throws SQLException{
	 WordSheetVo wordSheetVO =wordSheetDao.selectWordSheetByDocNum(doc_Num);
	 return wordSheetVO;
	}
	
	public void updateWordSheet(WordSheetVo wordSheetVo) throws SQLException{
		wordSheetDao.updateWordSheet(wordSheetVo);
		
	}
	
}
