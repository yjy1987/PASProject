package com.app.pas.dto.board;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("ProjectBoardReply")
@Data
public class ProjectBoardReplyVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1617531274522471839L;
	private int pb_Reply_Num;
	private String pb_Reply_Mem;
	private String pb_Reply_Content;
	private int pb_Article_Num;
	private String pb_Reply_Mem_Img;
	private String pb_Reply_Mem_Name;
	
	

	
	
	
}
