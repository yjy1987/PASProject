package com.app.pas.dto;

import java.io.Serializable;
import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("AdminCalendar")
@Data
public class AdminCalendarVo implements Serializable{
	private int ad_Cal_Num;
	private String ad_Cal_Title;
	private Date ad_Cal_End;
	private Date ad_Cal_Start;
	private String ad_Cal_allDay;
	
	public AdminCalendarCommand toCommand(){
		AdminCalendarCommand adminCalendarCommand = new AdminCalendarCommand();
		adminCalendarCommand.setAllDay(this.getAd_Cal_allDay());
		adminCalendarCommand.setEnd(this.getAd_Cal_End());
		adminCalendarCommand.setStart(this.getAd_Cal_Start());
		adminCalendarCommand.setTitle(this.getAd_Cal_Title());
		return adminCalendarCommand;
	}
	
	public AdminCalendarVo fromCommand(AdminCalendarCommand adminCalendarCommand){
		AdminCalendarVo adminCalendarVo = new AdminCalendarVo();
		
		adminCalendarVo.setAd_Cal_allDay(adminCalendarCommand.getAllDay());
		adminCalendarVo.setAd_Cal_End(adminCalendarCommand.getEnd());
		adminCalendarVo.setAd_Cal_Start(adminCalendarCommand.getStart());
		adminCalendarVo.setAd_Cal_Title(adminCalendarCommand.getTitle());
		
		return adminCalendarVo;
	}
	
}
