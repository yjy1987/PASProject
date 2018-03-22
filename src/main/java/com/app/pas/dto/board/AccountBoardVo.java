package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("AccountBoard")
@Data
public class AccountBoardVo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1934031726029780543L;
	private int acc_Num;
	private Timestamp acc_Date;
	private int acc_Imp;
	private int acc_Exp;
	private String acc_Content;
	private int acc_Total;
	private int proj_Num;
	

	
	
	
	
	
}
