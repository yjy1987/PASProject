package com.app.pas.dto.board;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("QnaBoardReply")
@Data
public class QnaBoardReplyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811232382707712323L;
	private int qb_Reply_Num;
	private String qb_Reply_Time;
	private int qb_Article_Num;
	private String admin_Email;
	private String qb_Reply_Content;
	
	
}
