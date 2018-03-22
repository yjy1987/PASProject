package com.app.pas.dto.dic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GantChartCommand {
	private String id;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm")
	private Date start;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm")
	private Date end;
	private String title;
	private Double percentComplete;
	private String parentId;
	private String orderId;
	
}
