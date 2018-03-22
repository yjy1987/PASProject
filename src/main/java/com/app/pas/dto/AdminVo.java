package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Admin")
@Data
public class AdminVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6355823050838702970L;
	private String admin_Email;
	private String admin_Pass;
	
	
}
