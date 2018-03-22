package com.app.pas.dto.dic;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;



@Data
@Alias("Document")
public class DocumentVo {
	private int doc_Num;
	private int doc_Kind;
	private String mem_Email;
	private String mem_Name;
	private String doc_Name;
	private Timestamp doc_Wt_Date;
	private int proj_Num;
	private String doc_Img;
	private String doc_File_Name;
}
