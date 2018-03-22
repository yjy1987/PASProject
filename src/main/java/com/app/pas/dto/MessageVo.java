package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Message")
@Data
public class MessageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3940283899906898052L;
	private int msg_Article_Num;
	private Timestamp msg_Wt_Date;
	
	
	/*@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-mm-dd hh:mm:ss")*/
	private String msg_Rd_Date;
	
	private String msg_Title;
	private String msg_Content;
	private String msg_sm_Email;
	private String msg_rm_Email;
	private String msg_sm_Name;
	private String msg_rm_Name;
	private String msg_rm_Read_yn;
	private String msg_sm_del_yn;
	private String msg_rm_del_yn;
	
	

	
}
