package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Data
@Alias("BoardJoin")
public class BoardJoinVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2128491446773342599L;
	private int bm_Num;
	private String bj_Mem_Email;
	private String bj_Write;
	private String bj_Read;
	private String bj_Mem_Name;
	private int bj_Proj_Num;
}
