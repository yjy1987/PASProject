package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("MemApplyView")
@Data
public class MemApplyViewVo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564133866533752763L;
	private int apply_Num;
	private Timestamp apply_Time;
	private String apply_Commit_Check;
	private String mem_Email;
	private int proj_Num;
	private String proj_Name;
	private String p_Mem_Email;
	private String alarm_Clsfct;
	private String Alarm_Clsfct_Name;
	
	
	
}
