package com.app.pas.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("FreeBoard")
@Data
public class FreeBoardVo implements Serializable{

	
	/**s
	 * 
	 */
	private static final long serialVersionUID = -4308973987930961633L;
	private int frb_Article_Num;
	private Timestamp frb_Wt_Date;
	private String frb_Content;
	private String frb_Title;
	private int frb_Inq_Count;
	private String mem_Email;
	private String frb_Kind;
	private int frb_Like_Count;
	private String mem_Name;
	private String frb_Tag;
	private String frb_title_Content;
	

	

	
	
	
	
	
}
