package com.app.pas.service.dic;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dao.dic.DocumentDao;
import com.app.pas.dao.dic.SpreadSheetDao;
import com.app.pas.dao.dic.WordSheetDao;
import com.app.pas.dto.dic.DocumentVo;
import com.app.pas.dto.dic.SpreadSheetVo;
import com.app.pas.dto.dic.WordSheetVo;

public class DocumentService {

	private DocumentDao documentDao;
	private SpreadSheetDao spreadSheetDao;
	private WordSheetDao wordSheetDao;
	
	
	
	
	
	public void setWordSheetDao(WordSheetDao wordSheetDao) {
		this.wordSheetDao = wordSheetDao;
	}



	public void setSpreadSheetDao(SpreadSheetDao spreadSheetDao) {
		this.spreadSheetDao = spreadSheetDao;
	}

	
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}



	public boolean insertDictionarySpreadSeet(DocumentVo documentVo,SpreadSheetVo spreadSheetVo) throws SQLException{
		documentDao.insertDocument(documentVo);
		DocumentVo selectLastVo = documentDao.selectDocumentLastColumn();
		spreadSheetVo.setDoc_Num(selectLastVo.getDoc_Num());
		int result = spreadSheetDao.insertSpreadSheet(spreadSheetVo);
		boolean flag = false;
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public List<DocumentVo> selectDocumentListByProjNum(int proj_Num)throws SQLException{
		List<DocumentVo> list = documentDao.selectDocumentListByProjNum(proj_Num);
		return list;
	}
	
	public boolean deleteDocumentByDocNum(DocumentVo documentVo) throws SQLException{
		int result = documentDao.deleteDocumentByDocNum(documentVo.getDoc_Num());
		boolean flag = false;
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public int selectCountDocumentByProjectNum(int proj_Num) throws SQLException {
		int count = documentDao.selectCountDocumentByProjectNum(proj_Num);
		return count;
	}
	
	public DocumentVo selectDocumentByDocNum(int doc_Num) throws SQLException{
		DocumentVo documentVo = documentDao.selectDocumentByDocNum(doc_Num);
		return documentVo;
	}

	
	public boolean insertDictionaryWordSeet(DocumentVo documentVo,WordSheetVo wordSheetVo) throws SQLException{
		documentDao.insertDocument(documentVo);
		DocumentVo selectLastVo = documentDao.selectDocumentLastColumn();
		wordSheetVo.setDoc_Num(selectLastVo.getDoc_Num());
		System.out.println(wordSheetVo+"ㅁㅇㄹㄷ");
		wordSheetDao.insertWordSheet(wordSheetVo);
		boolean flag = true;
		/*if(result==1){
			flag = true;
		}*/
		return flag;
	}
	
	public boolean updateDocumentName(DocumentVo documentVo) throws SQLException{
		boolean flag = false;
		int result = documentDao.updateDocumentName(documentVo);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
}
