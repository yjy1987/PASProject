package com.app.pas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class AdminCalendarCommand implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2360743940176400042L;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date start;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date end;
	private String title;
	private String allDay;
	
}
