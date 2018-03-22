package com.app.pas.dao.dic;

import java.sql.SQLException;
import java.util.List;

import com.app.pas.dto.dic.DocumentVo;

public interface DocumentDao {

	public void  insertDocument(DocumentVo documentVo) throws SQLException;
	public DocumentVo selectDocumentLastColumn() throws SQLException;
	public List<DocumentVo> selectDocumentListByProjNum(int proj_Num)throws SQLException;
	public int deleteDocumentByDocNum(int doc_Num) throws SQLException;
	public DocumentVo selectDocumentByDocNum(int doc_Num) throws SQLException;
	public int updateDocumentName(DocumentVo documentVo) throws SQLException;
	public int selectCountDocumentByProjectNum(int proj_Num) throws SQLException;
}