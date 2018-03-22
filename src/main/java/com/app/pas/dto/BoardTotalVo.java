package com.app.pas.dto;

import java.io.Serializable;


import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Data
@Alias("BoardTotal")
public class BoardTotalVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805064574620240432L;
	private int bt_Num;
	private String bt_Content;
	private String bt_Title;
	private String bt_Mem_Email;
	private Timestamp bt_Wt_Date;
	private int bm_Num;
	private String bt_Mem_Name;
}
