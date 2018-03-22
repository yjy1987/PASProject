package com.app.pas.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.pas.commons.Paging;
import com.app.pas.dto.ApplyVo;
import com.app.pas.dto.InviteVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberCommandVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.ProjInviteViewVo;
import com.app.pas.dto.ProjLogCommand;
import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectVo;
import com.app.pas.dto.ScheduleCalendarCommand;
import com.app.pas.dto.ScheduleCalendarVo;
import com.app.pas.dto.board.AccountBoardVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.NoticeVo;
import com.app.pas.dto.board.ProjectBoardReplyVo;
import com.app.pas.dto.board.ProjectBoardVo;
import com.app.pas.dto.dic.GantChartCommand;
import com.app.pas.dto.dic.GantChartVo;
import com.app.pas.service.ApplyService;
import com.app.pas.service.InviteService;
import com.app.pas.service.MemberLogService;
import com.app.pas.service.MemberService;
import com.app.pas.service.PositionService;
import com.app.pas.service.ProjectJoinService;
import com.app.pas.service.ProjectLogService;
import com.app.pas.service.ProjectService;
import com.app.pas.service.ScheduleCalendarService;
import com.app.pas.service.WeeklyCheckService;
import com.app.pas.service.board.AccountBoardService;
import com.app.pas.service.board.FreeBoardService;
import com.app.pas.service.board.NoticeService;
import com.app.pas.service.board.ProjectBoardReplyService;
import com.app.pas.service.board.ProjectBoardService;
import com.app.pas.service.dic.DocumentService;
import com.app.pas.service.dic.GantChartService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	NoticeService noticeService;
	@Autowired
	ProjectBoardService projectBoardService;
	@Autowired
	ProjectBoardReplyService projectBoardReplyService;
	@Autowired
	AccountBoardService accountService;
	@Autowired
	MemberService memberService;
	@Autowired
	InviteService inviteService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectJoinService projectJoinService;
	@Autowired
	ScheduleCalendarService scheduleCalendarService;
	@Autowired
	PositionService positionService;
	@Autowired
	ApplyService applyService;
	@Autowired
	FreeBoardService freeBoardService;
	@Autowired
	MemberLogService memberLogService;
	@Autowired
	GantChartService gantChartService;
	@Autowired
	ProjectLogService projectLogService;
	@Autowired
	WeeklyCheckService weeklyCheckService;
	@Autowired
	DocumentService documentService; 
	
	// �봽濡쒖젥�듃 Board List ---------------------------------------------
	@RequestMapping("/pmBoardList")
	public String selectProjectBoardList(HttpSession session,
			ProjectBoardVo projectBoardVo, Model model,
			@RequestParam(value = "page", defaultValue = "1") String page)
			throws SQLException {

		List<ProjectBoardVo> pbList = new ArrayList<ProjectBoardVo>();
		String url = "project/pmBoardList";

		String getProj_Num = (String) session.getAttribute("joinProj");

		pbList = projectBoardService.selectProjectBoardList(Integer.parseInt(getProj_Num));

		model.addAttribute("pbList", pbList);

		return url;
	}

	// �봽濡쒖젥�듃 board 寃뚯떆湲� �삱由ш린-----------------------------------------
	@RequestMapping(value = "/pmBoardInsert", method = RequestMethod.POST)
	public String insertProjectBoard(Model model,
			ProjectBoardVo projectBoardVo, HttpSession session)
			throws SQLException {

		// �꽭�뀡�쓽 �젙蹂대�� 媛��졇���꽌 �꽔�쓬
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		String mem_Img = memberVo.getMem_Img();
		String proj_Num = (String) session.getAttribute("joinProj");
		String mem_Name = memberVo.getMem_Name();
		projectBoardVo.setMem_Name(mem_Name);
		projectBoardVo.setMem_Email(mem_Email);
		projectBoardVo.setMem_Img(mem_Img);
		projectBoardVo.setProj_Num(Integer.parseInt(proj_Num));

		projectBoardService.insertProjectBoard(projectBoardVo);
		String url = "redirect:pmBoardList";
		return url;
	}

	// �봽濡쒖젥�듃 Board 湲� �닔�젙
	// ------------------------------------------------------------------
	@RequestMapping(value = "/pmBoardUpdate")
	public @ResponseBody int updateProjectBoard(
			@RequestBody ProjectBoardVo projectBoardVo, Model model,
			HttpSession session) throws SQLException {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		projectBoardVo.setMem_Email(mem_Email);
		projectBoardService.updateProjectBoard(projectBoardVo);
		return 0;
	}

	// �궡媛� �벖 湲� 蹂닿린 --------------------------------------------------
	@RequestMapping("/pmBoardMyProjectList")
	public String myProjectList(Model model, HttpSession session,
			ProjectBoardVo projectBoardVo) throws SQLException {
		List<ProjectBoardVo> pbList = new ArrayList<ProjectBoardVo>();

		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		projectBoardVo.setMem_Email(mem_Email);
		projectBoardVo.setProj_Num(1);

		String url = "project/pmBoardMyProjectList";

		pbList = projectBoardService.myProjectList(mem_Email);
		model.addAttribute("projectBoardVo", projectBoardVo);
		model.addAttribute("pbList", pbList);

		return url;
	}

	// 湲��궘�젣
	// ------------------------------------------------------------------------
	@RequestMapping("/deleteProjectBoard")
	public String deleteProjectBoard(String pb_Article_Num)
			throws NumberFormatException, SQLException {
		String url = "redirect:pmBoardList";
		projectBoardService
				.deleteProjectBoard(Integer.parseInt(pb_Article_Num));

		return url;
	}

	// �뙎湲�

	// �뙎湲� 由ъ뒪�듃---------------------------------------------------------------
	@RequestMapping(value = "/selectProjectBoardReply", method = RequestMethod.POST)
	public @ResponseBody List<List<ProjectBoardReplyVo>> selectProjectBoardReply(
			HttpSession session) throws NumberFormatException, SQLException {
		String proj_Num = (String) session.getAttribute("joinProj");

		List<ProjectBoardVo> list = projectBoardService
				.selectProjectBoardList(Integer.parseInt(proj_Num));

		List<List<ProjectBoardReplyVo>> fullList = new ArrayList<List<ProjectBoardReplyVo>>();

		for (ProjectBoardVo x : list) {
			List<ProjectBoardReplyVo> projectBoardReplyList = new ArrayList<ProjectBoardReplyVo>();
			projectBoardReplyList = projectBoardReplyService
					.selectProjectBoardReply(x.getPb_Article_Num());
			fullList.add(projectBoardReplyList);
		}

		return fullList;
	}

	// �뙎湲� �삱由ш린 -----------------------------------------------------
	@RequestMapping(value = "/insertProjectBoardReply", method = RequestMethod.POST)
	public @ResponseBody List<ProjectBoardReplyVo> insertProjectBoardReply(
			@RequestBody ProjectBoardReplyVo projectBoardReplyVo,
			HttpSession session) throws SQLException {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Name = memberVo.getMem_Name();
		String mem_Img = memberVo.getMem_Img();
		String mem_Email = memberVo.getMem_Email();
		projectBoardReplyVo.setPb_Reply_Mem_Name(mem_Name);
		projectBoardReplyVo.setPb_Reply_Mem(mem_Email);
		projectBoardReplyVo.setPb_Reply_Mem_Img(mem_Img);

		List<ProjectBoardReplyVo> list = projectBoardReplyService
				.insertProjectBoardReply(projectBoardReplyVo);

		return list;
	}

	@RequestMapping(value = "/deleteProjectBoardReply", method = RequestMethod.GET)
	public String deleteProjectBoardReply(@RequestParam String pb_Reply_Num)
			throws NumberFormatException, SQLException {
		String url = "redirect:/project/pmBoardList";
		projectBoardReplyService.deleteProjectBoardReply(Integer
				.parseInt(pb_Reply_Num));
		return url;
	}
	// ------------------------------------------------------------------------------

	@RequestMapping("/pmChat")
	public String PmChat(HttpSession session, Model model) {
		String url = "/project/demo_audio_only";
		return url;
	}

	@RequestMapping("/pmNoticeList")
	public String pmNoticeList(Model model, HttpSession session,
			@RequestParam(value = "page", defaultValue = "1") String page) {
		String proj_Num = (String) session.getAttribute("joinProj");
		int totalCount = 0;
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");

		String url = "project/pmNoticeList";

		List<NoticeVo> list = null;
		MemPositionViewVo memPositionView = new MemPositionViewVo();
		
		HashMap map = new HashMap();
		map.put("proj_Num", proj_Num);
		map.put("mem_Email", memberVo.getMem_Email());

		try {
			list = noticeService.getNoticeList(Integer.parseInt(proj_Num));	
			model.addAttribute("NoticeList", list);
			memPositionView = noticeService.getNoticePosition(map);
			session.setAttribute("memPositionView", memPositionView);
			totalCount = noticeService.selectNoticeCount(Integer
					.parseInt(proj_Num));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (page.equals(null) || page == "") {
			page = "" + 1;
		}

		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(10);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);

		return url;

	}

	
	@RequestMapping(value = "/pmNoticeWrite", method = RequestMethod.POST)
	public String pmNoticeWrite(HttpSession session, NoticeVo noticeVo) {
		String url = "redirect:/project/pmNoticeList";
		int proj_Num =  Integer.parseInt((String)session.getAttribute("joinProj"));

		noticeVo.setProj_Num(proj_Num);
		
		try {
			noticeService.insertNotice(noticeVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;

	}

	// �봽濡쒖젥�듃 Notice寃뚯떆�뙋 湲��벐湲� Form
	@RequestMapping(value = "/pmNoticeWrite", method = RequestMethod.GET)
	public String pmNoticeWriteForm(HttpServletRequest request,
			String proj_Num, String notice_Num) {
		String url = "project/pmNoticeWrite";

		return url;

	}

	@RequestMapping(value = "/pmNoticeDetail", method = RequestMethod.GET)
	public String NoticeDetailForm(HttpServletRequest request, String proj_Num,
			String notice_Num) {
		String url = "project/pmNoticeDetail";
		// int iproj_Num = Integer.parseInt(proj_Num);
		HashMap map = new HashMap();
		map.put("proj_Num", proj_Num);
		map.put("notice_Num", notice_Num);

		try {
			NoticeVo noticeVo = (NoticeVo) noticeService.getNoticeDetail(map);
			request.setAttribute("NoticeVo", noticeVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	// �봽濡쒖젥�듃 Notice寃뚯떆�뙋 �닔�젙 Form
	@RequestMapping(value = "/pmNoticeUpdate", method = RequestMethod.GET)
	public String pmNoticeUpdateForm(HttpServletRequest request,
			String proj_Num, String notice_Num) {
		String url = "project/pmNoticeUpdate";
		HashMap map = new HashMap();
		map.put("proj_Num", proj_Num);
		map.put("notice_Num", notice_Num);

		try {
			NoticeVo noticeVo = (NoticeVo) noticeService.getNoticeDetail(map);
			request.setAttribute("NoticeVo", noticeVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;

	}

	
	@RequestMapping(value = "/pmNoticeUpdate", method = RequestMethod.POST)
	public String updateUpdate(NoticeVo noticeVo) {
		String url = "redirect:/project/pmNoticeList";

		try {
			noticeService.updateNotice(noticeVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/pmNoticeDelete")
	public String deleteNotice(HttpSession session, String notice_Num) {
		NoticeVo noticeVo = new NoticeVo();
		noticeVo.setNotice_Num(Integer.parseInt(notice_Num));
		noticeVo.setProj_Num(Integer.parseInt((String)session.getAttribute("joinProj")));
		
		String url = "redirect:/project/pmNoticeList";
		try {
			noticeService.deleteNotice(noticeVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/overView")
	public String PmOverView(HttpSession session, Model model,HttpServletRequest request,
			@RequestParam(value="page",defaultValue="1")String page,
			@RequestParam String proj_Num,FreeBoardVo freeboardVo) throws NumberFormatException,
			SQLException {
		
		String url = "project/overView";
		
        List<NoticeVo> list = null;
        List<MemPositionViewVo> joinmember = null;
        list = noticeService.getNoticeList(Integer.parseInt(proj_Num));
        model.addAttribute("NoticeList", list);
        joinmember = projectService.selectMemPositionViewListByProjNum(Integer.parseInt(proj_Num));
        model.addAttribute("joinmember", joinmember);
		List<FreeBoardVo> freeBoardList = new ArrayList<FreeBoardVo>();
	
		session.setAttribute("joinProj", proj_Num);
		request.setAttribute("proj_Num", proj_Num);
		ProjectVo projectVo = projectService.selectProject(Integer
				.parseInt(proj_Num));

		int joinMem = projectJoinService.selectJoinCountMember(Integer.parseInt(proj_Num)); 
		int countDoc = documentService.selectCountDocumentByProjectNum(Integer.parseInt(proj_Num));
		int countAccount = accountService.selectAccountCount(Integer.parseInt(proj_Num));
		int countSchedule = scheduleCalendarService.selectScheduleCount(Integer.parseInt(proj_Num));
		int countProjNotice = noticeService.selectNoticeCount(Integer.parseInt(proj_Num));
		int totalAccountExp = accountService.sumAccountExp(Integer.parseInt(proj_Num));
		int totalAccountImp = accountService.sumAccountImp(Integer.parseInt(proj_Num));
		int totalAccount = totalAccountImp-totalAccountExp;
		MemberVo selectKing = memberService.selectKing(Integer.parseInt(proj_Num));
		
		int wkY = weeklyCheckService.selectWkYnY(Integer.parseInt(proj_Num));
		int wkN = weeklyCheckService.selectWkYnN(Integer.parseInt(proj_Num));
		int sumYN = wkY+wkN;
		request.setAttribute("totalAccountExp", totalAccountExp);
		request.setAttribute("totalAccountImp", totalAccountImp);
		request.setAttribute("countAccount", countAccount);
		request.setAttribute("joinMem", joinMem);
		request.setAttribute("countDoc", countDoc);
		request.setAttribute("countSchedule", countSchedule);
		request.setAttribute("countProjNotice", countProjNotice);
		request.setAttribute("totalAccount", totalAccount);
		request.setAttribute("selectKing", selectKing);
		request.setAttribute("wkY", wkY);
		request.setAttribute("wkN", wkN);
		request.setAttribute("sumYN", sumYN);
		freeBoardList = freeBoardService.selectFreeBoardList(freeboardVo);
		
		model.addAttribute("freeBoardList", freeBoardList);
	
		session.setAttribute("joinProjectVo", projectVo);
		
	   Paging paging = new Paging();
       paging.setPageNo(Integer.parseInt(page));
       paging.setPageSize(10);
       paging.setTotalCount(countProjNotice);
       model.addAttribute("paging", paging);
       
       Paging paging1 = new Paging();
       paging1.setPageNo(Integer.parseInt(page));
       paging1.setPageSize(10);
       paging1.setTotalCount(joinMem);
       model.addAttribute("paging1", paging1);
  
		return url;
		
	}
	@RequestMapping("overViewChart")
	public @ResponseBody Map<String,Object> overViewChart(
			HttpSession httpSession ) throws SQLException{
		String proj_Num =(String) httpSession.getAttribute("joinProj");  
		System.out.println("**********@@@@@@@@@@@@@@"+proj_Num);
		List<ProjLogCommand> list =projectLogService.selectWeekLogCount(Integer.parseInt(proj_Num));
		List<String> dayList = new ArrayList<String>();
		List<Integer> dayCount = new ArrayList<Integer>();
		Map<String,Object> totalMap = new HashMap<String, Object>();
		for(ProjLogCommand x : list){
			dayList.add(x.getLog_Date());
			dayCount.add(x.getProject_Log_Count());
		}
		totalMap.put("dt", dayList);
		totalMap.put("count", dayCount);
		
		System.out.println("######list#######"+list);
		System.out.println("######dayList#######"+dayList);
		System.out.println("######dayCount#######"+dayCount);
		return totalMap;
	}

	@RequestMapping("/teamMemberList")
	public String TeamMemberList(HttpSession session, Model model) {
		String url = "";
		return url;
	}

	@RequestMapping("/billing")
	public String Billing(HttpSession session, Model model) {
		String url = "project/billing";

		return url;
	}

	@RequestMapping("/AccountBoardList")
	public String AccountBoardList(HttpSession session, Model model,
			@RequestParam(value = "page", defaultValue = "1") String page)
			throws SQLException {
		String url = "schedule/accountForm";
		/* int proj_Num = (Integer) session.getAttribute("joinProj"); */
		String Num = (String) session.getAttribute("joinProj");
		int proj_Num = Integer.parseInt(Num);
		int totalCount = 0;
		List<AccountBoardVo> list = accountService.getAccountList(proj_Num);
		System.out.println(list + "�씠嫄� 由ъ뒪�듃!!");
		if (list.isEmpty() != true) {
			int Imp = accountService.sumAccountImp(proj_Num);
			int Exp = accountService.sumAccountExp(proj_Num);
			int Sum = Imp-Exp;
			
			model.addAttribute("Sum",Sum);
			model.addAttribute("sumImp", Imp);
			model.addAttribute("sumExp", Exp);
		}
		model.addAttribute("AccountBoardList", list);

		totalCount = accountService.selectAccountCount(proj_Num);

		if (page.equals(null) || page == "") {
			page = "" + 1;
		}

		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(10);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping(value = "/AccountBoardInsert", method = RequestMethod.POST)
	public @ResponseBody int AccountBoardInsert(
			@RequestBody Map<String, Object> map) throws SQLException,
			ParseException {
		int result = 1;
		AccountBoardVo accountBoardVo = new AccountBoardVo();

		String str = map.get("acc_Date").toString();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		java.util.Date t = sdf.parse(str);
		java.sql.Date st = new java.sql.Date(t.getTime());
		java.sql.Timestamp sts = new java.sql.Timestamp(t.getTime());

		accountBoardVo.setAcc_Date(sts);
		int acc_Imp = Integer.parseInt(map.get("acc_Imp").toString());
		accountBoardVo.setAcc_Imp(acc_Imp);
		int acc_Exp = Integer.parseInt(map.get("acc_Exp").toString());
		accountBoardVo.setAcc_Exp(acc_Exp);
		accountBoardVo.setAcc_Content((String) map.get("acc_Content"));
		accountBoardVo.setAcc_Total(acc_Imp - acc_Exp);
		accountBoardVo.setProj_Num(Integer.parseInt(map.get("proj_Num")
				.toString()));
		accountService.InsertAccountBoard(accountBoardVo);
		return result;
	}

	@RequestMapping(value = "/AccountBoardUpdate", method = RequestMethod.POST)
	public @ResponseBody int AccountBoardUpdate(
			@RequestBody Map<String, Object> map) throws SQLException,
			ParseException {
		int result = 1;
		AccountBoardVo accountBoardVo = new AccountBoardVo();
		accountBoardVo.setAcc_Num(Integer.parseInt(map.get("acc_Num")
				.toString()));
		accountBoardVo.setProj_Num(Integer.parseInt(map.get("proj_Num")
				.toString()));
		accountBoardVo = accountService.selectAccountBoardByAcc(accountBoardVo);
		String str = map.get("acc_Date").toString();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyy-MM-dd");
		java.util.Date t = sdf.parse(str);
		java.sql.Date st = new java.sql.Date(t.getTime());
		java.sql.Timestamp sts = new java.sql.Timestamp(t.getTime());
		accountBoardVo.setAcc_Date(sts);
		System.out.println(accountBoardVo.getAcc_Date()
				+ "�씠寃껋� accountboardVo accDate");
		int acc_Imp = Integer.parseInt(map.get("acc_Imp").toString());
		accountBoardVo.setAcc_Imp(acc_Imp);
		int acc_Exp = Integer.parseInt(map.get("acc_Exp").toString());
		accountBoardVo.setAcc_Exp(acc_Exp);
		accountBoardVo.setAcc_Content((String) map.get("acc_Content"));
		accountBoardVo.setAcc_Total(acc_Imp - acc_Exp);

		accountService.updateAccountBoard(accountBoardVo);
		return result;
	}

	@RequestMapping(value = "/AccountBoardDelete", method = RequestMethod.POST)
	public @ResponseBody int AccountBoardDelete(
			@RequestBody Map<String, Object> map) throws SQLException {
		int result = 1;
		AccountBoardVo accountBoardVo = new AccountBoardVo();
		accountBoardVo.setAcc_Num(Integer.parseInt(map.get("acc_Num")
				.toString()));
		accountBoardVo.setProj_Num(Integer.parseInt(map.get("proj_Num")
				.toString()));

		accountService.deleteAccountBoard(accountBoardVo);
		return result;
	}

	@RequestMapping("/pmMemberList")
	public String pmMemberList(HttpSession session, Model model)
			throws SQLException {
		String url = "/project/teamMemberList";
		/* int proj = (Integer) session.getAttribute("joinProj"); */
		int proj_Num = Integer.parseInt((String) session
				.getAttribute("joinProj"));
		int per = 1;
		MemPositionViewVo memPositionView = new MemPositionViewVo();
		memPositionView.setPjj_Per_Num(1);
		memPositionView.setProj_Num(proj_Num);

		List<MemPositionViewVo> list = memberService
				.selectMemberListByProj(memPositionView);
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		memPositionView.setMem_Email(memberVo.getMem_Email());
		memPositionView = memberService.selectMemberPosition(memPositionView);
		model.addAttribute("pmMemberList", list);
		model.addAttribute("memPositionView", memPositionView);
		return url;
	}

	@RequestMapping(value = "/pmMemberInvite", method = RequestMethod.GET)
	public String pmMemberInvite(HttpSession session) throws SQLException {
		String url = "/project/teamInvite";
		int proj_Num = Integer.parseInt((String) session.getAttribute("joinProj"));
		String mem_Email = "";
		/* int proj_Num= (Integer) session.getAttribute("joinProj"); */
		ProjInviteViewVo projInviteViewVo = new ProjInviteViewVo();
		projInviteViewVo.setProj_Num(proj_Num);

		List<ProjInviteViewVo> list = inviteService
				.selectInviteList(projInviteViewVo);
		session.setAttribute("InviteList", list);

		return url;
	}

	@RequestMapping(value = "/pmMemberInvite", method = RequestMethod.POST)
	public @ResponseBody List<MemberCommandVo> pmMemberInviteList(
			HttpSession session) throws SQLException {
		String Proj_Num = (String) session.getAttribute("joinProj");
		List<MemberCommandVo> memberList = memberService
				.selectMemberEmailList(Integer.parseInt(Proj_Num));

		return memberList;
	}

	@RequestMapping(value = "/pmInviteInsert", method = RequestMethod.POST)
	public @ResponseBody MemberVo  pmInviteInsert(String mem_Email,
			HttpSession session) throws SQLException,
			UnsupportedEncodingException {
		
		int proj_Num = Integer.parseInt((String) session
				.getAttribute("joinProj"));
		MemberVo memberVo1 = memberService.getMember(mem_Email);
		InviteVo inviteVo = new InviteVo();
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();

		inviteVo.setMem_Email(mem_Email);
		inviteVo.setProj_Num(proj_Num);

		projectJoinVo.setMem_Email(mem_Email);
		projectJoinVo.setProj_Num(proj_Num);
		projectJoinVo.setMem_Name(memberVo1.getMem_Name());
		projectJoinVo.setMem_Img(memberVo1.getMem_Img());
		projectJoinService.insertProject(projectJoinVo);
		inviteService.insertInvite(inviteVo);
		return memberVo1;

	}

	@RequestMapping(value = "TeamMemberUpdate", method = RequestMethod.POST)
	public @ResponseBody int TeamMemberUpdate(@RequestBody Map<String, Object> map,HttpSession session) throws SQLException {
		
		int proj_Num = Integer.parseInt((String) session.getAttribute("joinProj"));
		ProjectJoinVo member = new ProjectJoinVo();
		String result=(String) map.get("position_Num");
		
		member.setMem_Email(map.get("mem_Email").toString());
		member.setProj_Num(proj_Num);
		member.setPosition_Num(Integer.parseInt(result));
        
		projectJoinService.updatePosition(member);
        return proj_Num;
	}

	@RequestMapping(value = "activeModal", method = RequestMethod.POST)
	public @ResponseBody AccountBoardVo activeModal(
			@RequestBody Map<String, Object> map, HttpSession session)
			throws SQLException {
		AccountBoardVo accountBoardVo = new AccountBoardVo();
		accountBoardVo.setAcc_Num(Integer.parseInt(map.get("acc_Num")
				.toString()));
		accountBoardVo.setProj_Num(Integer.parseInt((String) session
				.getAttribute("joinProj")));

		accountBoardVo = accountService.selectAccountBoardByAcc(accountBoardVo);
		System.out.println(accountBoardVo.getAcc_Date()+"날짜");
		return accountBoardVo;
	}

	@RequestMapping(value = "activeMemberModal", method = RequestMethod.POST)
	public @ResponseBody MemPositionViewVo activeMemberModal(
			@RequestBody Map<String, Object> map, HttpSession session,
			HttpServletRequest request) throws SQLException,
			UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int proj_Num = Integer.parseInt((String) session
				.getAttribute("joinProj"));

		MemPositionViewVo memPositionViewVo = new MemPositionViewVo();
		memPositionViewVo.setMem_Email(map.get("mem_Email").toString());
		memPositionViewVo.setProj_Num(proj_Num);

		memPositionViewVo = memberService
				.selectMemberPosition(memPositionViewVo);
		String mem_Phone = memberService.selectMemberPhone(map.get("mem_Email")
				.toString());
		memPositionViewVo.setMem_Phone(mem_Phone);

		return memPositionViewVo;

	}

	@RequestMapping(value = "TeamMemberDelete", method = RequestMethod.POST)
	public @ResponseBody int TeamMemberDelete(
			@RequestBody Map<String, Object> map, HttpSession session)
			throws SQLException {

		int result = 1;

		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		int proj_Num = Integer.parseInt((String) session
				.getAttribute("joinProj"));
		
		projectJoinVo.setMem_Email(map.get("mem_Email").toString());
		projectJoinVo.setProj_Num(proj_Num);
		projectJoinService.deleteProjectJoin(projectJoinVo);
		return result;
	}

	@RequestMapping(value = "deleteInvite", method = RequestMethod.POST)

	   public @ResponseBody int DeleteInvite(String mem_Email, HttpSession session)
	         throws SQLException {
	      int result=1;
	      InviteVo inviteVo = new InviteVo();
	      System.out.println(mem_Email + "이건 인바이메일!");
	      int proj_Num = Integer.parseInt((String) session
	            .getAttribute("joinProj"));
	      inviteVo.setMem_Email(mem_Email);
	      inviteVo.setProj_Num(proj_Num);
	      ProjectJoinVo projectJoinvo = new ProjectJoinVo();
	      projectJoinvo.setMem_Email(inviteVo.getMem_Email());
	      projectJoinvo.setProj_Num(proj_Num);
	      projectJoinService.deleteProjectJoin(projectJoinvo);
	      inviteService.deleteInvite(inviteVo);

        return result;
	}

	@RequestMapping(value = "/c9", method = RequestMethod.GET)
	public String profileImgForm(HttpSession session, Model model)
			throws SQLException {
		int proj_Num = Integer.parseInt((String) session
				.getAttribute("joinProj"));
		ProjectVo projectVo = projectService.selectProject(proj_Num);
		model.addAttribute("projectVo", projectVo);
		String url = "project/c9";
		return url;
	}

	@RequestMapping(value = "/c9", method = RequestMethod.POST)
	public String uploadByMultipartHttpServletRequest2(ProjectVo projectVo,
			MultipartHttpServletRequest request, Model model,
			HttpSession session) throws IOException, SQLException {

		MultipartFile multipartFile = request.getFile("ff");

		if (!multipartFile.isEmpty()) {
			String upload = new HttpServletRequestWrapper(request)
					.getRealPath("/resources/upload2");

			File file = new File(upload, System.currentTimeMillis() + "$$"
					+ multipartFile.getOriginalFilename());

			multipartFile.transferTo(file);

			model.addAttribute("title", request.getParameter("title"));
			model.addAttribute("uploadPath", file.getAbsolutePath());

			int proj_Num = Integer.parseInt((String) session
					.getAttribute("joinProj"));
			projectVo.setProj_Img(file.getName());
			projectVo.setProj_Num(proj_Num);
			projectService.updateProjectImg(projectVo);
			return "project/c9";
		}

		return "projectVo/c9";

	}

	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public @ResponseBody ProjectVo Color(@RequestBody String color, Model model,
			HttpSession session) throws SQLException {

		ProjectVo projectVo = new ProjectVo();

		String realColor = "#" + color.substring(0, 6);
		System.out.println(realColor);
		String proj = (String) session.getAttribute("joinProj");
		projectVo.setProj_Num(Integer.parseInt(proj));
		projectVo.setProj_Color(realColor);

		projectService.updateProjectColor(projectVo);
		projectVo = projectService.selectProject(Integer.parseInt(proj));
		session.setAttribute("joinProjectVo", projectVo);

		return projectVo;

	}

	@RequestMapping(value = "/colorList")
	public String ColorList(HttpSession session, Model model)
			throws SQLException {
		String url = "project/colorList";

		return url;
	}

	@RequestMapping(value = "/pmCalendar", method = RequestMethod.GET)
	public String pmCalendarView(HttpSession session, Model model)
			throws SQLException {
		String url = "schedule/monthlySchedule";
		String proj_Num = (String) session.getAttribute("joinProj");

		MemPositionViewVo memPositionViewVo = new MemPositionViewVo();

		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");

		memPositionViewVo.setProj_Num(Integer.parseInt(proj_Num));

		memPositionViewVo.setPjj_Per_Num(1);

		List<MemPositionViewVo> list = memberService
				.selectMemberListByProj(memPositionViewVo);

		memPositionViewVo.setMem_Email(memberVo.getMem_Email());

		MemPositionViewVo memPosition = memberService
				.selectMemberPositionByEmail(memPositionViewVo);

		model.addAttribute("memPositionViewVo", list);
		model.addAttribute("memPosition", memPosition);
		return url;
	}

	@RequestMapping(value = "calendarList", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleCalendarCommand> calendarList(
			HttpSession session, Model model) throws SQLException {
		String sc_Proj_Num = (String) session.getAttribute("joinProj");
		List<ScheduleCalendarVo> list = scheduleCalendarService
				.selectScheduleCalendarList(Integer.parseInt(sc_Proj_Num));
		List<ScheduleCalendarCommand> scheduleCalendarList = new ArrayList<ScheduleCalendarCommand>();

		for (ScheduleCalendarVo x : list) {
			ScheduleCalendarCommand command = new ScheduleCalendarCommand();
			command = x.toCommand();
			scheduleCalendarList.add(command);
		}
		return scheduleCalendarList;
	}

	@RequestMapping(value = "addCal", method = RequestMethod.POST)
	public @ResponseBody ScheduleCalendarCommand addCal(
			@RequestBody ScheduleCalendarCommand scheduleCalendarCommand,
			HttpSession session) throws SQLException {

		String sc_Proj_Num = (String) session.getAttribute("joinProj");
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		ScheduleCalendarVo scheduleCalendarVo = new ScheduleCalendarVo();
		MemPositionViewVo memPositionViewVo = new MemPositionViewVo();

		memPositionViewVo.setMem_Email(memberVo.getMem_Email());
		memPositionViewVo.setProj_Num(Integer.parseInt(sc_Proj_Num));

		memPositionViewVo = memberService
				.selectMemberPositionByEmail(memPositionViewVo);
		scheduleCalendarVo = scheduleCalendarVo
				.fromCommand(scheduleCalendarCommand);
		scheduleCalendarVo.setSc_Proj_Num(Integer.parseInt(sc_Proj_Num));
		scheduleCalendarVo.setSc_Wk_Mem_Email(memberVo.getMem_Email());
		scheduleCalendarVo.setSc_Wk_Name(memberVo.getMem_Name());

		scheduleCalendarVo.setSc_Color(memPositionViewVo.getPjj_Color());

		scheduleCalendarService.insertScheduleCalendar(scheduleCalendarVo);

		return scheduleCalendarVo.toCommand();
	}

	@RequestMapping(value = "updateCal", method = RequestMethod.POST)
	public @ResponseBody ScheduleCalendarCommand updateCal(
			@RequestBody ScheduleCalendarCommand scheduleCalendarCommand,
			HttpSession session) throws SQLException {
		String sc_Proj_Num = (String) session.getAttribute("joinProj");
		ScheduleCalendarVo scheduleCalendarVo = new ScheduleCalendarVo();

		String sc_Num = scheduleCalendarCommand.getId();
		// sc_Num으로 vo하나 셀렉트
		ScheduleCalendarVo select = scheduleCalendarService
				.selectScheduleCalendarByScNum(Integer.parseInt(sc_Num));

		scheduleCalendarVo = scheduleCalendarVo
				.fromCommand(scheduleCalendarCommand);
		scheduleCalendarVo.setSc_Num(Integer.parseInt(sc_Num));

		scheduleCalendarVo.setSc_Proj_Num(Integer.parseInt(sc_Proj_Num));
		scheduleCalendarVo.setSc_Wk_Name(select.getSc_Wk_Name());
		scheduleCalendarVo.setSc_Wk_Mem_Email(select.getSc_Wk_Mem_Email());

		scheduleCalendarService.updateScheduleCalendar(scheduleCalendarVo);

		return scheduleCalendarVo.toCommand();
	}

	@RequestMapping(value = "deleteCal", method = RequestMethod.POST)
	public @ResponseBody boolean deleteCal(@RequestBody Map<String, Object> map)
			throws SQLException {
		String sc_Num = (String) map.get("sc_Num");
		boolean deleteSuccess = false;
		int flag = scheduleCalendarService.deleteScheduleCalendar(Integer
				.parseInt(sc_Num));
		if (flag != 0) {
			deleteSuccess = true;
		} else {
			deleteSuccess = false;
		}

		return deleteSuccess;
	}

	@RequestMapping(value = "updateCalColor", method = RequestMethod.POST)
	public @ResponseBody boolean updateCalColor(
			@RequestBody ProjectJoinVo projectJoinVo, HttpSession session)
			throws SQLException {
		String proj_Num = (String) session.getAttribute("joinProj");
		projectJoinVo.setProj_Num(Integer.parseInt(proj_Num));
		projectJoinService.updateProjectJoinColor(projectJoinVo);
		ScheduleCalendarVo scheduleCalendarVo = new ScheduleCalendarVo();

		scheduleCalendarVo.setSc_Color(projectJoinVo.getPjj_Color());
		scheduleCalendarVo.setSc_Wk_Mem_Email(projectJoinVo.getMem_Email());

		scheduleCalendarVo.setSc_Proj_Num(Integer.parseInt(proj_Num));
		scheduleCalendarService.updateScheduleCalendarColor(scheduleCalendarVo);

		return true;
	}

	@RequestMapping(value = "selectDetailCal", method = RequestMethod.POST)
	public @ResponseBody MemPositionViewVo selectDetailCal(
			@RequestBody ScheduleCalendarCommand scheduleCalendarCommand)
			throws SQLException {
		ScheduleCalendarVo scheduleCalendarVo = new ScheduleCalendarVo();
		scheduleCalendarVo = scheduleCalendarVo
				.fromCommand(scheduleCalendarCommand);
		ScheduleCalendarVo select = scheduleCalendarService
				.selectScheduleCalendarByScNum(scheduleCalendarVo.getSc_Num());
		MemPositionViewVo memPositionViewVo = new MemPositionViewVo();
		memPositionViewVo.setMem_Email(select.getSc_Wk_Mem_Email());
		memPositionViewVo.setProj_Num(select.getSc_Proj_Num());
		MemPositionViewVo memPosition = memberService
				.selectMemberPositionByEmail(memPositionViewVo);
		return memPosition;
	}
	
	
	@RequestMapping("pmGantChart")
	public String pmGantChartForm(){
		String url ="schedule/gantChartForm";
		return url;
	}
	
	@ResponseBody
	@RequestMapping("setGant")
	public List<GantChartCommand> setGant(HttpSession session) throws NumberFormatException, SQLException{
		String proj_Num = (String) session.getAttribute("joinProj");
		List<GantChartVo> vo = (List<GantChartVo>) gantChartService.selectGantChart(Integer.parseInt(proj_Num));
		List<GantChartCommand> gantChartCommandList = new ArrayList<GantChartCommand>();
		for(GantChartVo x : vo){
			gantChartCommandList.add(x.toCommand());
		}
		
		return gantChartCommandList;
	}
	
	@RequestMapping(value="updateGant",method = RequestMethod.POST)
	public @ResponseBody boolean updateGant(@RequestBody Map<String,Object> map,HttpSession session) throws NumberFormatException, SQLException, ParseException{
		 Map<String,Object> m = new HashMap<String, Object>();
		 String proj_Num = (String) session.getAttribute("joinProj");
		 List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) map.get("_data");
	     boolean result  =  gantChartService.updateGantChart(list, Integer.parseInt(proj_Num));
	     return true;
	
	
	}
	
	@RequestMapping(value="projOut", method = RequestMethod.POST)
	public @ResponseBody int ProjectOut(HttpSession session, ProjectJoinVo projectJoinVo,  InviteVo inviteVo, ApplyVo applyVo) throws SQLException{
		int result = -1;
		ProjectJoinVo proj =projectJoinService.selectProjectJoin(projectJoinVo);
		
		System.out.println(proj.toString()+"피알오제!");
		if(proj.getPosition_Num()==1){
		
			result=2;
		}else{
		
		projectJoinService.deleteProjectJoin(projectJoinVo);
		inviteService.deleteInvite(inviteVo);
		applyService.deleteApply(applyVo);
		
		result=1;
		}
		return result;
	}
	
	@RequestMapping(value="ProjectDelete",method=RequestMethod.POST)
	public @ResponseBody int ProjectDelete(HttpSession session) throws SQLException{
		int proj_Num = Integer.parseInt(session.getAttribute("joinProj").toString());
		projectService.deleteProject(proj_Num);
		
		return 1;
		
		
	}
	
	@RequestMapping(value="checkAuthority",method = RequestMethod.POST)
	public @ResponseBody boolean checkAuthority(HttpSession session) throws SQLException{
		boolean flag = false;
		String proj_Num = (String) session.getAttribute("joinProj");
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		projectJoinVo.setProj_Num(Integer.parseInt(proj_Num));
		projectJoinVo.setMem_Email(memberVo.getMem_Email());
		ProjectJoinVo result = projectJoinService.selectProjectJoin(projectJoinVo);
		int positionNum = result.getPosition_Num();
		if(positionNum==1){
			flag = true;
		}
		return flag;
	}
	
}
/*
 * @RequestMapping("/projectBoardReplyList")
 * 
 * public @ResponseBody List<ProjectBoardVo>
 * selectProjectBoardReplyList(@RequestBody Map<String,Object> jsonMap,Model
 * model){
 * 
 * List<ProjectBoardVo> projectBoardReplyList = new ArrayList<ProjectBoardVo>();
 * String pb_Article_Num = (String)jsonMap.get("pb_Article_Num");
 * 
 * try { projectBoardReplyList =
 * projectBoardService.selectProjectboard(Integer.parseInt(pb_Article_Num)); }
 * catch (NumberFormatException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 * model.addAttribute("projectBoardList",projectBoardList);
 * 
 * return projectBoardList; }
 * 
 * @RequestMapping(value="/projectBoardReplyWrite", method=RequestMethod.POST)
 * public @ResponseBody List<ProjectBoardVo> writeProjectBoardReply(@RequestBody
 * ProjectBoardVo projectBoardVo, HttpSession session){ MemberVo memberVo =
 * (MemberVo) session.getAttribute("loginUser"); String mem_Email =
 * memberVo.getMem_Email(); projectBoardVo.setMem_Email(mem_Email);
 * 
 * List<ProjectBoardVo> projectBoardList = new ArrayList<ProjectBoardVo>();
 * projectBoardVo.setPb_Wt_Mem("def@naver.com");
 * 
 * try { projectBoardService.insertProjectboardDao(projectBoardVo);
 * projectBoardList =
 * projectBoardService.selectProjectboard(projectBoardVo.getPb_Article_Num()); }
 * catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return projectBoardList; } }
 */

