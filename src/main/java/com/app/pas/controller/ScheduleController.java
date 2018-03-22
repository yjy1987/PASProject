package com.app.pas.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ScheduleCalendarVo;
import com.app.pas.dto.WeeklyCheckVo;
import com.app.pas.service.ScheduleCalendarService;
import com.app.pas.service.WeeklyCheckService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	

	@Autowired
	ScheduleCalendarService scheduleService;
	@Autowired
	ScheduleCalendarService schdulCalendarService;
	@Autowired
	WeeklyCheckService weeklyCheckService;

	@RequestMapping("/calendar")
	public String CalendarList() {
		String url = "schedule/monthlySchedule";
		return url;
	}

	@RequestMapping(value = "/weeklyChecklist")
	public String weelyChecklist(ScheduleCalendarVo scheduleCalendarVo,
			Model model, HttpSession session,
			HttpServletRequest request,
			WeeklyCheckVo weeklyCheckVo) throws SQLException, ParseException, UnsupportedEncodingException {
		String url = "schedule/weeklyChecklist";
		
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		String wk_Proj_Num = (String) session.getAttribute("joinProj");
		List<ScheduleCalendarVo> weelyList_start = new ArrayList<ScheduleCalendarVo>();
		scheduleCalendarVo.setSc_Wk_Mem_Email(mem_Email);
		scheduleCalendarVo.setSc_Proj_Num(Integer.parseInt(wk_Proj_Num));
		// 업데이트-----------------------------------------------------------------

			weelyList_start = schdulCalendarService.selectWeeklylist_Start(scheduleCalendarVo);
			model.addAttribute("weelyList_start", weelyList_start);

			// 마감
			List<ScheduleCalendarVo> weelyList_end = new ArrayList<ScheduleCalendarVo>();
			weelyList_end = schdulCalendarService.selectWeeklylist_End(scheduleCalendarVo);
			model.addAttribute("weelyList_end", weelyList_end);

			// 마감,시작 포함일정(모달)
			List<ScheduleCalendarVo> weekly_dateList = new ArrayList<ScheduleCalendarVo>();
			weekly_dateList = schdulCalendarService.weekly_date();
			model.addAttribute("weekly_dateList", weekly_dateList);

			// select
			List<WeeklyCheckVo> weekCheckList = new ArrayList<WeeklyCheckVo>();
			WeeklyCheckVo vo = new WeeklyCheckVo();
			vo.setWk_Mem_Email(mem_Email);
			vo.setWk_Proj_Num(Integer.parseInt(wk_Proj_Num));
			weekCheckList = weeklyCheckService.weeklyCheck(vo);
			model.addAttribute("weekCheckList",weekCheckList);
			
			//완료인것 리스트 뿌려주는거
			List<WeeklyCheckVo> weekCheck_Y_List = new ArrayList<WeeklyCheckVo>();
			WeeklyCheckVo select_Y_Vo = new WeeklyCheckVo();
			
			select_Y_Vo.setWk_Proj_Num(Integer.parseInt(wk_Proj_Num));
			select_Y_Vo.setWk_Mem_Email(mem_Email);
			/*weekCheck_Y_List = weeklyCheckService.weeklyCheck_Select_Y(select_Y_Vo);*/
			/*model.addAttribute("weekCheck_Y_List", weekCheck_Y_List);*/
			
			/*System.out.println("y리스트 오긴오니? : "+ weekCheck_Y_List);*/
			
		return url;
	}
	
	//등록-------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="weeklyCheckInsert",method = RequestMethod.GET)
	public String weeklyCheckInsert(HttpServletRequest request,@RequestParam(defaultValue = "") String d,
			@RequestParam(defaultValue = "") String wk_Content,HttpSession session,HttpServletRequest response) throws SQLException, UnsupportedEncodingException, ParseException{
		String url="redirect:weeklyChecklist";
		request.setCharacterEncoding("utf-8");
		WeeklyCheckVo weeklyCheckVo = new WeeklyCheckVo();
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		String wk_Proj_Num = (String) session.getAttribute("joinProj");
		if ((d.equals(""))) {
		} else {
			StringBuffer sb = new StringBuffer(d);
			sb.insert(5, "-");
			sb.insert(8, "-");
			
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date to = transFormat.parse(sb.toString());
			weeklyCheckVo.setWk_Proj_Num(Integer.parseInt(wk_Proj_Num));
			weeklyCheckVo.setWk_Content(wk_Content);
			weeklyCheckVo.setWk_Date(to);
			weeklyCheckVo.setWk_Mem_Email(mem_Email);

			weeklyCheckService.weeklyCheck_Update(weeklyCheckVo);
		}
		return url;
	}

	//삭제-------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/weeklyCheck_Delete")
		public String weeklyCheck_Delete(String wk_Num,ScheduleCalendarVo scheduleCalendarVo,
				Model model, HttpSession session, @RequestParam(defaultValue = "") String d,
				@RequestParam(defaultValue = "") String wk_Content,WeeklyCheckVo weeklyCheckVo) throws SQLException, ParseException{
			String url = "redirect:weeklyChecklist";
				weeklyCheckService.weeklyCheck_Delete(weeklyCheckVo);
			return url; 
		}
		
	//Y or N ------------------------------------------------------------------------------------
		@RequestMapping(value = "/weeklyCheck_YN", method = RequestMethod.POST)
		public @ResponseBody boolean weeklyCheck_YN(HttpSession session,@RequestBody WeeklyCheckVo weeklyCheckVo) throws SQLException, ParseException{
			
			MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
			String mem_Email = memberVo.getMem_Email();
			String wk_Proj_Num = (String) session.getAttribute("joinProj");
				weeklyCheckVo.setWk_Mem_Email(mem_Email);
				weeklyCheckVo.setWk_Proj_Num(Integer.parseInt(wk_Proj_Num));
				weeklyCheckVo.setWk_Yn("Y");
				weeklyCheckService.weeklyCheck_YN(weeklyCheckVo);
				return true; 
		}
	
		@RequestMapping(value="wk_UpdateSuccess", method = RequestMethod.POST)
		public @ResponseBody boolean wk_UpdateSuccess(@RequestBody WeeklyCheckVo weeklyCheckVo )throws SQLException{
			weeklyCheckService.wk_UpdateSuccess(weeklyCheckVo);
			return true;
		}
	
}
