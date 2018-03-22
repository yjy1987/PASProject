package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("FreeBoardReply")
@Data
public class FreeBoardReplyVo implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5305142254812233310L;
	private int frb_Reply_Num;
	private int frb_Article_Num;
	private String frb_Reply_Mem;
	private String frb_Reply_Content;
	private Timestamp frb_Reply_Time;
	private String frb_Reply_Mem_Name;
	
	
	
	
}
