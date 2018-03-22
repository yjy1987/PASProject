package com.app.pas.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("MyPostBoardVo")
@Data
public class MyPostBoardVo {
	
	private Timestamp dt;
	private String title;
	private String cont;
	private int num;
	private int cnt;
	private String mail;
	private String yn;
	private String tag;
	private String bd_check;

}
