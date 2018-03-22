package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("QnaBoard")
@Data
public class QnaBoardVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7623969246269740169L;
	private int qb_Article_Num;
	private String qb_Title;
	private String qb_Content;
	private int qb_Inq_Count;
	private String qb_Password;
	private String mem_Email;
	private Timestamp qb_Wt_Date;
	private String qb_yn;
	private String mem_Name;
	private String qb_Title_Content;
	
	
	
	
	
}
