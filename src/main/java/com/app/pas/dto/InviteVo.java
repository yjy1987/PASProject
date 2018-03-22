package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Invite")
@Data
public class InviteVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7380871539250222346L;
	private int invite_Num;
	private String invite_Content;
	private String invite_Commit_Check;
	private String alarm_Clsfct;
	private int proj_Num;
	private String mem_Email;
	
	
	
}
