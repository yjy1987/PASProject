package com.app.pas.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Data
@Alias("BoardManagement")
public class BoardManagementVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1728289183836460394L;
	private int bm_Num;
	private String bm_Title;
	private String bm_Mem_Email;
	private String bm_Mem_Name;
	private int bm_Proj_Num;
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Timestamp bm_Create_Date;
	private int bm_TotalCount;
}
