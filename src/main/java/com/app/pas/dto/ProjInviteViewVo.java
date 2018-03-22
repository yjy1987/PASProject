package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("ProjInviteView")
@Data
public class ProjInviteViewVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1532908507364078448L;
	private int invite_Num;
	private String invite_Commit_Check;
	private String invite_Content;
	private String mem_Email;
	private String p_Mem_Email;
	private int proj_Num;
	private String proj_Name;
	private String alarm_Clsfct_Name;
	private String mem_Name;
	private Timestamp invite_Time;
	private String mem_Img;
	
	
	
	
	

}
