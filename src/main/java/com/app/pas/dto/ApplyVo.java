package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Apply")
@Data
public class ApplyVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2221490699953627878L;
	private int apply_Num;
	private String apply_Commit_Check;
	private String mem_Email;
	private int proj_Num;
	private String alarm_Clsfct;

}
