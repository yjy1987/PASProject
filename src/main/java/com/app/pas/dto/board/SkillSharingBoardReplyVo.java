package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;



@Alias("SkillSharingBoardReply")
@Data
public class SkillSharingBoardReplyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8540349801062581717L;
	private int ssb_Reply_Num;
	private int ssb_Article_Num;
	private String ssb_Reply_Mem;
	private String ssb_Reply_Content;
	private String ssb_Reply_Mem_Name;
	private Timestamp ssb_Reply_Time;
	

}
