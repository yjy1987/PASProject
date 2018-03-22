package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Member")
@Data
public class MemberVo implements Serializable{

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1330416796873302737L;
	private String mem_Email;
	private String quit_Check;
	private String mem_Name;
	private String mem_Phone;
	private String mem_Pass;
	private String mem_Img;
	private String mem_Approve;
	private Timestamp mem_Join_Date;

	
}
