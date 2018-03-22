package com.app.pas.controller.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pas.dto.AdminCalendarCommand;
import com.app.pas.dto.AdminCalendarVo;
import com.app.pas.dto.MemberLogCommand;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectVo;
import com.app.pas.service.AdminCalendarService;
import com.app.pas.service.AdminService;
import com.app.pas.service.MemberLogService;
import com.app.pas.service.MemberService;
import com.app.pas.service.ProjectService;
import com.app.pas.service.board.QnaBoardService;

@Controller
@RequestMapping("/admin")
public class AdminMemberMain {

	@Autowired
	MemberService memberService;
	@Autowired
	AdminService adminService;
	@Autowired
	ProjectService projectService;
	@Autowired
	QnaBoardService qnaBoardService; 

	@Autowired
	MemberLogService memberLogService;
	
	@Autowired
	AdminCalendarService adminCalendarService;
	
	
	@RequestMapping("/adminMain")
	public String MemberList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(defaultValue = "") String mem_Email)
			throws SQLException {
		
		int total_Mem = memberService.selectMemberTotalCount();
		int total_proj = projectService.selectProjectTotalCount();
		int total_QnaN = qnaBoardService.selectNCount();
		int joinCount = memberService.selectJoinToday();
		int projCount = memberService.selectProjCreated_Count();
		int visitorNum = memberService.selectVisitorNum();
		int exitCount = memberService.selectExit_count(); 
		int todayVisitorCount = memberService.selectTodayVisitorCount();  //오늘 방문한 방문자수 
		int visitThisWeekCount = memberService.selectVisitThisWeek(); //오늘로부터 일주일 방문자수 
		int visitLastWeelCount = memberService.selectVisitLastWeek(); //지지난주
		MemberVo memberVo = new MemberVo();
		
		List<MemberVo> todayMemberList = new ArrayList<MemberVo>();
		List<ProjectVo> projCreateList = new ArrayList<ProjectVo>();
		List<MemberVo> exit_MemList = new ArrayList<MemberVo>();
 		todayMemberList = memberService.selectJoinMemberToday();
		projCreateList = projectService.selectProjCreateToday();
		exit_MemList = memberService.selectExit_MemList();
		
		model.addAttribute("todayMemberList",todayMemberList);
		model.addAttribute("total_QnaN",total_QnaN);
		model.addAttribute("total_Mem",total_Mem);
		model.addAttribute("total_proj",total_proj);
		model.addAttribute("joinCount", joinCount);
		model.addAttribute("projCount",projCount);
		model.addAttribute("projCreateList",projCreateList);
		model.addAttribute("visitorNum",visitorNum);
		model.addAttribute("exitCount",exitCount);
		model.addAttribute("exit_MemList",exit_MemList);
		model.addAttribute("todayVisitorCount",todayVisitorCount); //오늘 방문한 방문자수 
		model.addAttribute("visitThisWeekCount",visitThisWeekCount);  //오늘로부터 일주일 방문자수 
		model.addAttribute("visitLastWeelCount",visitLastWeelCount);
		
		String url = "admin/adminMain";
		return url;
	}
	
	@RequestMapping("chartInit")
	public @ResponseBody Map<String,Object> chartInit() throws SQLException{
		List<MemberLogCommand> list = memberLogService.selectWeeklyLogCount();
		List<String> dayList = new ArrayList<String>();
		List<Integer> dayCount = new ArrayList<Integer>();
		Map<String,Object> totalMap = new HashMap<String, Object>();
		for(MemberLogCommand x : list){
			dayList.add(x.getLog_Date());
			dayCount.add(x.getMem_Log_Count());
		}
		totalMap.put("dt", dayList);
		totalMap.put("count", dayCount);
		return totalMap;
	}
	
	
	@RequestMapping(value="adminCalendarList",method = RequestMethod.POST)
	public @ResponseBody List<AdminCalendarCommand> adminCalendarList() throws SQLException{
		List<AdminCalendarVo> list = adminCalendarService.selectAdminCalendar();
		List<AdminCalendarCommand> resultList = new ArrayList<AdminCalendarCommand>();
		for(AdminCalendarVo x : list){
			resultList.add(x.toCommand());
		}
		return resultList;
	}
	@RequestMapping(value="adminInsertCal",method= RequestMethod.POST)
	public void admininsertCal(@RequestBody AdminCalendarCommand adminCalendarCommand) throws SQLException{
		AdminCalendarVo adminCalendarVo = new AdminCalendarVo();
		adminCalendarVo = adminCalendarVo.fromCommand(adminCalendarCommand);
		adminCalendarService.insertAdminCalendar(adminCalendarVo);
	}
}
