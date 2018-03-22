package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Project")
 @Data
public class ProjectVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2098979335551574345L;
	private int proj_Num;
	private String mem_Email;
	private String proj_Content;
	private String proj_Name;
	private String proj_Check;
	private String mem_Name;
	private String mem_Img;
	private String proj_Img;
    private String mem_Phone;
    private String proj_Team;
    private String proj_Color;
    private String proj_Search;
    
	

}
