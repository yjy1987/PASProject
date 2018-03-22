package com.app.pas.controller.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectVo;
import com.app.pas.service.AdminService;
import com.app.pas.service.MemberService;
import com.app.pas.service.ProjectService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

@Controller
@RequestMapping("/admin")
public class AdminProjectController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	AdminService adminService;
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/projectList")
	public String MemberList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(defaultValue = "") String proj_Name)
			throws SQLException {
		String url = "admin/adminProjectList";
		int totalCount = 0;
		List<ProjectVo> projectList = new ArrayList<ProjectVo>();
			
		projectList = projectService.selectProjectList2(proj_Name);	
				
		totalCount = projectService.selectProjectTotalCount();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@"+totalCount);
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}

		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(10);
		paging.setTotalCount(totalCount);
		System.out.println(paging.toString());
		model.addAttribute("paging", paging);
		model.addAttribute("projectList", projectList);
		return url;

	}
	
	@RequestMapping(value = "/mdlValue3", method = RequestMethod.POST)
	public @ResponseBody List<ProjectJoinVo> mdlValue(
			@RequestBody Map<String, Object> map,ProjectJoinVo projectJoinVo) throws SQLException {
		String proj_Num = (String) map.get("proj_Num");
		System.out.println("#######################"+proj_Num);
		projectJoinVo.setProj_Num(Integer.parseInt(proj_Num));
		List<ProjectJoinVo> list = projectService.selectMemberToProjNum(Integer.parseInt(proj_Num));
		System.out.println("@#@#@#@#@#@#@#@#@#@"+list);
		return list;
	}
	
	@RequestMapping("/searchProj")
	public String searchProj(@RequestParam String proj_Name, Model model)
			throws SQLException {
		System.out.println("*$*$*$*$**$*$*$*$**$*$**$*$*$"+proj_Name);
		String url = "redirect:projectList?proj_Name="+proj_Name;
		/*
		 * List<MemberVo> memberList = null; memberList =
		 * memberService.selectMemberEmail(mem_Email);
		 * model.addAttribute("memberList", memberList);
		 */
		return url;
	}
	
	@RequestMapping("/projectDelete")
	public String deleteMember(String proj_Num, HttpSession session) throws NumberFormatException, SQLException {
		String url = "redirect:projectList";
		System.out.println("@@@@@@@[          "+proj_Num+"         }@@@@@@@@@@@");
		System.out.println("@@@@@@@[          "+proj_Num+"         }@@@@@@@@@@@");
		System.out.println("@@@@@@@[          "+proj_Num+"         }@@@@@@@@@@@");
		StringTokenizer st = new StringTokenizer(proj_Num, ",");
		while(st.hasMoreTokens()){
			projectService.deleteProject(Integer.parseInt(st.nextElement().toString()));
		}
		
		
		return url;
	}
	
	

}
