package com.app.pas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("ScheduleCalendar")
@Data
public class ScheduleCalendarVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1962789608836030585L;
	private int sc_Num;
	private Date sc_Start_Date;
	private Date sc_End_Date;
	private String sc_Wk_Name;
	private String sc_Wk_Mem_Email;
	private String sc_Title;
	private int sc_Proj_Num;
	private String sc_Color;
	private String sc_Description;
	private String start_Day;
	private String end_Day;
	private String week_Day;
	private String week_Content;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private String dt; //이번주 날짜 
	
	private String dy;  //이번주 요일 

	
	public ScheduleCalendarCommand toCommand(){
		ScheduleCalendarCommand scheduleCalendarCommand = new ScheduleCalendarCommand();
		
		scheduleCalendarCommand.setStart(this.getSc_Start_Date());
		scheduleCalendarCommand.setEnd(this.getSc_End_Date());
		scheduleCalendarCommand.setTitle(this.getSc_Title());
		scheduleCalendarCommand.setColor(this.getSc_Color());
		scheduleCalendarCommand.setDescription(this.sc_Description);
		scheduleCalendarCommand.setId(this.sc_Wk_Mem_Email+"."+this.sc_Num);
		return scheduleCalendarCommand;
	}
	
	
	public ScheduleCalendarVo fromCommand(ScheduleCalendarCommand scheduleCalendarCommand){
		ScheduleCalendarVo scheduleCalendarVo = new ScheduleCalendarVo();
		if(scheduleCalendarCommand.getId()!=null){
			scheduleCalendarVo.setSc_Num(Integer.parseInt(scheduleCalendarCommand.getId()));
		}
		
		scheduleCalendarVo.setSc_Start_Date(scheduleCalendarCommand.getStart());
		scheduleCalendarVo.setSc_End_Date(scheduleCalendarCommand.getEnd()) ;
		scheduleCalendarVo.setSc_Title( scheduleCalendarCommand.getTitle());
		scheduleCalendarVo.setSc_Color(scheduleCalendarCommand.getColor()) ;
		scheduleCalendarVo.setSc_Description(scheduleCalendarCommand.getDescription());
		return scheduleCalendarVo;
	}
	
}
