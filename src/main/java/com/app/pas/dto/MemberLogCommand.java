package com.app.pas.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Data
@Alias("MemberLogCommand")
public class MemberLogCommand {

	private int mem_Log_Count;
	private String log_Date;
}