package com.app.pas.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;



@Alias("WeeklyCheck")
@Data
public class WeeklyCheckVo {

	private int wk_Num;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date wk_Date;
	
	private String wk_Content;
	private String wk_Mem_Email;
	private String wk_Yn;
	private int wk_Proj_Num;

}
