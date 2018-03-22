package com.app.pas.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class ScheduleCalendarCommand implements Serializable{
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm")
	private Date start;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm")
	private Date end;
	private String title;
	private String color;
	private String description;
	private String id;

}
