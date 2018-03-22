package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("ProjectBoard")
@Data
public class ProjectBoardVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -767077232241060471L;
	private int pb_Article_Num;
    private int pb_Inq_Count;
    private String mem_Email;
    private int proj_Num;
    private Timestamp pb_Wt_Date;
    private String pb_Content;
    private String mem_Name;
    private String mem_Img;
    
    
}
