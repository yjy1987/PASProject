package com.app.pas.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pas.commons.Paging;
import com.app.pas.dto.AdminVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberLogVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectVo;
import com.app.pas.service.AdminService;
import com.app.pas.service.MemberLogService;
import com.app.pas.service.MemberService;
import com.app.pas.service.ProjectService;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	AdminService adminService;
	@Autowired
	ProjectService projectService;
	@Autowired
	MemberLogService memberLogService; 

	@RequestMapping("/memberList")
	public String MemberList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(defaultValue = "") String mem_Email)
			throws SQLException {
		String url = "admin/adminMemberList";
		int totalCount = 0;
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		memberList = memberService.selectMemList(mem_Email);
		totalCount = memberService.selectMemberTotalCount();

		if (page.equals(null) || page == "") {
			page = "" + 1;
		}

		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(10);
		paging.setTotalCount(totalCount);
		System.out.println(paging.toString());
		model.addAttribute("paging", paging);
		model.addAttribute("memberList", memberList);
		return url;

	}
	/*
	 * MyProject 모달
	 */

	@RequestMapping(value = "/mdlValue2", method = RequestMethod.POST)
	public @ResponseBody List<ProjectVo> mdlValue(
			@RequestBody Map<String, Object> map,ProjectVo projectVo) throws SQLException {
		String mem_Email = (String) map.get("mem_Email");
		projectVo.setMem_Email(mem_Email);
		MemberLogVo memberLastLog = new MemberLogVo();
		memberLastLog = memberLogService.selectLastMemberLogByEmail(mem_Email);
		Timestamp log = memberLastLog.getMem_Log_Time();
		System.out.println("$$$$$$$$$$$$$$$$$$"+log);
		List<ProjectVo> list = projectService.selectMyProjectListById(projectVo);
		
		return list;
	}
	@RequestMapping("/memberDetail")
	public String MemberDetail(HttpSession session, Model model)
			throws ServletException, IOException {

		String url = "admin/adminMemberDetail";
		return url;

	}

	@RequestMapping("/memberUpdate")
	public String updateMember(HttpSession session, Model model)
			throws ServletException, IOException {

		String url = "admin/adminMemberList";
		return url;

	}

	@RequestMapping("/memberDelete")
	public String deleteMember(String mem_Email, HttpSession session) throws NumberFormatException, SQLException {
		String url = "redirect:memberList";
		StringTokenizer st = new StringTokenizer(mem_Email, ",");
		while(st.hasMoreTokens()){
			memberService.deleteMember(st.nextElement().toString());
		}
		return url;
	}
	
	@RequestMapping("/memberQuitCheck")
	public String memberQuitCheck(
			@RequestParam(value = "") String mem_Email, String quit_Check,
			HttpSession session,MemberVo memberVo) throws NumberFormatException, SQLException {
		String url = "redirect:memberList";
		System.out.println(memberVo.toString());
		memberVo = memberService.getMember(mem_Email);
		memberVo.setQuit_Check(quit_Check);
		memberService.updateMemberQuitCheck(memberVo);
		return url;
	}

	@RequestMapping("/searchMemEmail")
	public String searchMemEmail(@RequestParam String mem_Email, Model model)
			throws SQLException {
		String url = "redirect:memberList?mem_Email=" + mem_Email;
		/*
		 * List<MemberVo> memberList = null; memberList =
		 * memberService.selectMemberEmail(mem_Email);
		 * model.addAttribute("memberList", memberList);
		 */
		return url;
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model) {
		String url = "/admin/adminLogin";
		return url;
	}

	// 로그인처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody int loginAdmin(HttpSession session,
			String admin_Email, String admin_Pass) throws SQLException {

		int result = 0;
		System.out.println("@@@@@@@@@@@@@@@@@@@@들어옴@@@@@@@@@@@@@@@@@@@@@@");
		AdminVo adminVo = null;

		adminVo = adminService.getAdmin(admin_Email);
		if(adminVo==null ){
			result=3;
		}else{
			if(adminVo.getAdmin_Pass().equals(admin_Pass)){
				result=1;
			}else{
				result=2; 
			}
		}
		session.setAttribute("admin", adminVo);

		return result;
	}

}
