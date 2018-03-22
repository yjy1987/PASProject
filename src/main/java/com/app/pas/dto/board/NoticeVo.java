package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Notice")
@Data
public class NoticeVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6793382049531459676L;
	private int notice_Num;
	private String notice_Title;
	private String notice_Content;
	private Timestamp notice_Date;
	private int notice_Inq_Count;
	private int proj_Num;
	private String mem_Name;
	
	
	
	
	
	
	
	
}
