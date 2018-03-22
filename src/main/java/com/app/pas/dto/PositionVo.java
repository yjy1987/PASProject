package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Position")
@Data
public class PositionVo implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3955732648847363680L;
	private int position_Num;
	private String position_Name;
	
	
}
