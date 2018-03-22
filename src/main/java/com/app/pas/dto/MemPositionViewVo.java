package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("MemPositionView")
@Data
public class MemPositionViewVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989759546828049086L;
	private String mem_Email;
	private String mem_Name;
	private String mem_Phone;
	private String mem_Img;
	private int pjj_Per_Num;
	private int position_Num;
	private String position_Name;
	private int proj_Num;
	private String proj_Name;
	private Timestamp proj_Log_Time;
	private String pjj_Color;
	

}
