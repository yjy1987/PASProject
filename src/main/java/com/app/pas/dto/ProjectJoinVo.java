package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("ProjectJoin")
@Data
public class ProjectJoinVo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2774331649874455198L;
	private String mem_Email;
	private int proj_Num;
	private int pjj_Per_Num;
	private int position_Num;
	private String mem_Name;
	private String mem_Img;
	private String pjj_Color;
	private Timestamp pjj_Final_In_Time;
	
	
	

}
