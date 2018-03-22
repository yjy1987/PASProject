package com.app.pas.dto.board;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("FreeBoardLike")
@Data
public class FreeBoardLikeVo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 554231981599807318L;
	private int frb_Article_Num;
	private String mem_Email;
	
	
	
	
}
	
