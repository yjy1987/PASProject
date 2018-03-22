package com.app.pas.dto.dic;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Data
@Alias("WordSheet")
public class WordSheetVo {	
		private int doc_Num;
		private String wd_Content;
		private Timestamp wd_Wt_Date;
		
	}


