package com.app.pas.dto.dic;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Data
@Alias("SpreadSheet")
public class SpreadSheetVo {
	private int doc_Num;
	private String sp_Content;
	private Timestamp sp_Wt_Date;
	
}
