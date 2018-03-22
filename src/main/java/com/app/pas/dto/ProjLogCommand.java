package com.app.pas.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Data
@Alias("ProjLogCommand")
public class ProjLogCommand {

	private int Project_Log_Count;
	private String log_Date;
}