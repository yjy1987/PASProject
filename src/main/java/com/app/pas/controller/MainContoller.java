package com.app.pas.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.pas.dto.ApplyVo;
import com.app.pas.dto.InviteVo;
import com.app.pas.dto.MemApplyViewVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.MessageVo;
import com.app.pas.dto.ProjInviteViewVo;
import com.app.pas.dto.ProjectJoinVo;
import com.app.pas.dto.ProjectLogVo;
import com.app.pas.dto.ProjectVo;
import com.app.pas.dto.board.SkillSharingBoardVo;
import com.app.pas.service.ApplyService;
import com.app.pas.service.InviteService;
import com.app.pas.service.MainService;
import com.app.pas.service.MemberService;
import com.app.pas.service.MessageService;
import com.app.pas.service.ProjectLogService;
import com.app.pas.service.ProjectService;
import com.app.pas.service.board.QnaBoardService;

@Controller
@RequestMapping("/main")
public class MainContoller {
	HttpServletRequest request;
	@Autowired
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	MemberService memberService;

	@Autowired
	ProjectService projectService;

	@Autowired
	InviteService inviteService;

	@Autowired
	MainService mainService;
	
	@Autowired
	QnaBoardService qnaBoardService; 
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ApplyService applyService;
	@Autowired
	ProjectLogService projectLogService;
	
	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	public String exit(HttpSession session,ProjectVo projectVo,MemberVo member)
			throws NumberFormatException, SQLException {
		String url = null;

		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String loginEmail = memberVo.getMem_Email();
		projectVo.setMem_Email(loginEmail);
		List<ProjectVo> list = projectService.selectMyProjectListById(projectVo);
		if(list == null||list.isEmpty()){
			member = memberService.getMember(loginEmail);
			member.setQuit_Check("y");
			memberService.updateMemberQuitCheck(member);
			/*memberService.deleteMember(loginEmail);*/
			url = "redirect:/index?exit=yes";
		}else{
			url = "redirect:myProject?exit=no";
		}
		
		
	
		return url;
	}
	

	//연습용
		@RequestMapping(value="/temp")
		public String temp(HttpSession session, Model model){
		String url = "/main/temp";
		return url;
			
		}

	//공지팝업
	@RequestMapping(value="/tempNotice")
	public String tempNotice(HttpSession session, Model model){
	String url = "/main/tempNotice";
	return url;
		
	}
	

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model) {

		if (session != null) {
			session.removeAttribute("loginUser");
			if (session.getAttribute("joinProj") != null
					|| session.getAttribute("joinProj") != "null") {
				session.removeAttribute("joinProj");
			}
			if(session.getAttribute("joinProjectVo")!=null || session.getAttribute("joinProjectVo") !="null" ){
				session.removeAttribute("joinProjectVo");
			}
		}
		String url = "/main/loginForm";
		return url;
	}

	// 로그인처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody int loginMember(HttpSession session, String email,
			String pwd) {
		
		int result = 0;
		MemberVo memberVo = null;

		memberVo = memberService.getMember(email);
		// 아이디 검증
		if (memberVo == null) {
			result = 0;

		} else {
			// 비밀번호 검증
			if (memberVo.getMem_Pass().equals(pwd)) {

				/* result = 1; */

				// 이메일 인증
				if (memberVo.getMem_Approve().equals("y")) {
					
					if(memberVo.getQuit_Check().equals("n")){
						result = 1;
						session.setAttribute("loginUser", memberVo);
					}else{
						result=4;
					}
					
					
					
				} else {
					result = 3;

				}
			} else {
				result = 2;
			}

		}
		/* System.out.println("result값" + result); */
		return result;
	}

	@RequestMapping(value = "/logOut")
	public String logOut(HttpSession session, Model model) {
		String url = "redirect:/index";
		session.removeAttribute("loginUser");
		if (session.getAttribute("joinProj") != null
				&& session.getAttribute("joinProj") != "null") {
			session.removeAttribute("joinProj");
		}
		return url;
	}

	// 가입처리
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(HttpSession session, Model model) {
		String url = "main/joinForm";
		return url;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinMember(HttpSession session, MemberVo memberVo,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException,
			MessagingException, SQLException, UnknownHostException {
		String url = "/main/joinAuthForm";
		
		request.setCharacterEncoding("utf-8");
		
		InetAddress inet = InetAddress.getLocalHost();
		String svrIP = inet.getHostAddress();
		 /*System.out.println(memberVo);
		 System.out.println(memberVo.getMem_Email());*/
		
		
			System.out.println("중복이아닙니다.");
			memberService.insertMember(memberVo);
			String content = memberVo.getMem_Email()
					+ "(님)의 계정 승인 확인 메일입니다. "
					+ "<a href='http://"+svrIP+":8181/main/memberAuth?mem_Email="
					+ memberVo.getMem_Email() + "'>승인확인</a>";

			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");
			messageHelper.setSubject("이메일 인증 요정확인 메일입니다.");
			messageHelper.setTo(memberVo.getMem_Email());
			messageHelper.setFrom("youliksna@naver.com");
			messageHelper.setText(content, true);
			mailSender.send(message);

			
		
		return url;
	}
	
	@RequestMapping(value = "/EmailCheck", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String,Boolean> EmailCheck(HttpSession session, @RequestBody String mem_Email,Model model,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException,
			MessagingException, SQLException {
		
		boolean result = false;
		String check = mem_Email.replace("%40", "@");
		if(memberService.getMember(check.substring(check.indexOf("=")+1)) != null ){
			result = false;
			System.out.println("중복");
		}else{
			System.out.println("중복아님");
			result = true;
		}
		Map<String,Boolean> reMap = new HashMap<String, Boolean>();
		reMap.put("valid", result);
		System.out.println(result);
		return reMap;
	}
	

	@RequestMapping(value = "/memberAuth", method = RequestMethod.GET)
	public String MemberAuth(String mem_Email) throws SQLException {
		String url = "/main/loginAuthForm";
		memberService.AuthMember(mem_Email);
		return url;
	}
	

	/**
	 * 내가 참여한 프로젝트 리스트와 프로젝트를 검색한 결과의 리스트를 뿌려주는 메소드
	 * 
	 * @param session : 로그인한 회원의 기본키인 Email을 받음
	 * @param model :  내가 참여한 프로젝트의 리스트를 뿌려주는 기능을 model에 넣음
	 * @param proj_Search : jsp파일로부터 입력받은 검색어를 가져옴 
	 * @param projectVo : 회원의email과 검색어를 projectVo 에 넣음
	 * @return : myProject.jsp 파일로 return
	 * @throws SQLException
	 */
	@RequestMapping("/myProject")
	public String MyProject(HttpSession session, Model model,HttpServletRequest request,
			@RequestParam(defaultValue = "")String proj_Search,
			ProjectVo projectVo) throws SQLException {
		String url = "main/myProject";
		
		String exit = request.getParameter("exit");
		
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
	
		projectVo.setMem_Email(mem_Email);
		List<ProjectVo> list = projectService.selectMyProjectListById(projectVo);
		if (session.getAttribute("proj_Num") != null) {
			session.removeAttribute("proj_Num");
			}

			if (session.getAttribute("joinProj") != null
				|| session.getAttribute("joinProj") != "null") {
				session.removeAttribute("joinProj");
			}
			if (session.getAttribute("joinProjectVo") != null
				|| session.getAttribute("joinProjectVo") != "null") {
				session.removeAttribute("joinProjectVo");
			}
		
		if (proj_Search == "" || proj_Search.equals(null)) {
		
			}else{
				projectVo.setProj_Search(proj_Search);
				
				}
				model.addAttribute("exit", exit);
				model.addAttribute("myProjectList", list);
				return url;
		}
//---------------------------------------------------------------------------------
//외부 프로젝트
	@RequestMapping("/otherProject")
	public String OtherProject(HttpSession session, Model model,
			@RequestParam(defaultValue = "")String proj_Search,ProjectVo projectVo,
			HttpServletResponse response)
			throws SQLException {
		
		String url = "/main/otherProject";
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		projectVo.setMem_Email(mem_Email);
		
		if(proj_Search == "" || proj_Search.equals(null)){
			if (session.getAttribute("proj_Num") != null) {
				session.removeAttribute("proj_Num");
			}
			if (session.getAttribute("joinProj") != null
					|| session.getAttribute("joinProj") != "null") {
				session.removeAttribute("joinProj");
			}
			if (session.getAttribute("joinProjectVo") != null
					|| session.getAttribute("joinProjectVo") != "null") {
				session.removeAttribute("joinProjectVo");
			}
		}else{		
			if (session.getAttribute("proj_Num") != null) {
				session.removeAttribute("proj_Num");
			}
			if (session.getAttribute("joinProj") != null
					|| session.getAttribute("joinProj") != "null") {
				session.removeAttribute("joinProj");
			}
			if (session.getAttribute("joinProjectVo") != null
					|| session.getAttribute("joinProjectVo") != "null") {
				session.removeAttribute("joinProjectVo");
			}
			
			projectVo.setProj_Search(proj_Search);
			
		}
		
		list = projectService.selectOtherProjectListById(projectVo);
		model.addAttribute("otherProjectList", list);
	
		return url;
		
	}

	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String Mypage(HttpSession session, Model model) {
		String url = "main/myPage";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		MemberVo memName = memberService.getMember(memberVo.getMem_Name());
		model.addAttribute("memName", memName);
		if (session.getAttribute("memName") != null) {
			session.removeAttribute("memName");
		}
		return url;
	}

	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> MypageUpdate(HttpSession session,
			Model model, @RequestBody Map<String, Object> map)
			throws SQLException {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		
		String mem_Pass = (String) map.get("mem_Pass");
		
		if(mem_Pass ==""|| mem_Pass==null){
			memberVo.setMem_Pass(memberVo.getMem_Pass());
		}else{
			memberVo.setMem_Pass(mem_Pass);	
		}
		
		String mem_Phone = (String) map.get("mem_Phone");
		memberVo.setMem_Phone(mem_Phone);

		int a = memberService.updateMember(memberVo);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("T", a);
		return m;
	}

	/*
	 * MyProject 모달
	 */

	@RequestMapping(value = "/mdlValue", method = RequestMethod.POST)
	public @ResponseBody List<MemPositionViewVo> mdlValue(
			@RequestBody Map<String, Object> map) throws SQLException {
		int proj_Num = (Integer) map.get("proj_Num");
		List<MemPositionViewVo> list = projectService
				.selectMemPositionViewListByProjNum(proj_Num);
		return list;
	}

	/*
	 * OtherProject 모달
	 */
	@RequestMapping(value = "/mdlOtherValue", method = RequestMethod.POST)
	public @ResponseBody List<MemPositionViewVo> mdlOtherValue(
			@RequestBody Map<String, Object> map) throws SQLException {
		int proj_Num = Integer.parseInt(map.get("proj_Num").toString());
		List<MemPositionViewVo> list = projectService
				.selectMemPositionViewListByProjNum(proj_Num);
		return list;
	}

	@RequestMapping(value = "/checkApply", method = RequestMethod.POST)
	public @ResponseBody int mdlCheckApply(
			@RequestBody Map<String, Object> map, HttpSession session)
			throws SQLException {
		int proj_Num = (Integer) map.get("proj_Num");
		MemApplyViewVo memApplyViewVo = new MemApplyViewVo();
		memApplyViewVo.setProj_Num(proj_Num);
		memApplyViewVo.setMem_Email(((MemberVo) session
				.getAttribute("loginUser")).getMem_Email());
		int countMemApply = memberService
				.selectCountMemApplyView(memApplyViewVo);
		return countMemApply;
	}

	@RequestMapping(value="checkInvite",method = RequestMethod.POST)
	public @ResponseBody int checkInvite(@RequestBody InviteVo inviteVo, HttpSession session) throws SQLException{
		inviteVo.setMem_Email(((MemberVo) session.getAttribute("loginUser")).getMem_Email());
		int countProjInvite  = inviteService.selectCountProjInviteView(inviteVo);
		return countProjInvite;
	}
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> mdlInvite(
			@RequestBody Map<String, Object> map, HttpSession session)
			throws SQLException {
		int proj_Num = (Integer) map.get("proj_Num");
		ApplyVo applyVo = new ApplyVo();
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		MemApplyViewVo memApplyViewVo = new MemApplyViewVo();
		MemberVo member = (MemberVo) session.getAttribute("loginUser");

		applyVo.setMem_Email(member.getMem_Email());
		applyVo.setProj_Num(proj_Num);
		applyVo.setAlarm_Clsfct("1");

		projectJoinVo.setMem_Email(member.getMem_Email());
		projectJoinVo.setProj_Num(proj_Num);
		projectJoinVo.setMem_Name(member.getMem_Name());
		projectJoinVo.setMem_Img(member.getMem_Img());
		memApplyViewVo.setMem_Email(member.getMem_Email());
		memApplyViewVo.setProj_Num(proj_Num);
		memApplyViewVo = projectService.insertApply(applyVo, projectJoinVo,
				memApplyViewVo);
		String p_Mem_Email = memApplyViewVo.getP_Mem_Email();
		
		map.put("p_Mem_Email", p_Mem_Email);
		
		return map;
	}

	@RequestMapping(value = "/simpleMessage", method = RequestMethod.POST)
	public @ResponseBody int SimpleMessage(HttpSession session,
			HttpServletRequest request, String sendEmail) throws SQLException,
			UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		int result = -1;
		double dpwd = ((Math.random()+1)*10000);
		String pwd = ((int)(dpwd))+"";
		String content = sendEmail + "님 의 임시 비밀번호는 " + pwd+ "입니다";
		SimpleMailMessage message = new SimpleMailMessage();

		MemberVo memberVo = (MemberVo) memberService.getMember(sendEmail);
		memberVo.setMem_Pass(pwd);
		if (memberVo != null) {
			memberService.extraPwd(memberVo);

			message.setText(content);
			message.setTo(sendEmail);
			message.setSubject("임시비밀번호 전송입니다.");
			message.setFrom("youliksna@naver.com");

			mailSender.send(message);
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	@RequestMapping("/c8")
	public String c8(HttpSession session, Model model) {
		String url = "/main/c8";
		return url;
	}

	
	

	@RequestMapping(value = "/c8", method = RequestMethod.POST)
	public String uploadByMultipartHttpServletRequest(MemberVo memberVo,
			MultipartHttpServletRequest request, Model model,
			HttpSession session) throws IOException {

		MultipartFile multipartFile = request.getFile("f");

		if (!multipartFile.isEmpty()) {
			String upload = new HttpServletRequestWrapper(request).getRealPath("/resources/upload");
			System.out.println(upload);
			File file = new File(upload, System.currentTimeMillis() + "$$"
					+ multipartFile.getOriginalFilename());

			multipartFile.transferTo(file);

			model.addAttribute("title", request.getParameter("title"));
			model.addAttribute("uploadPath", file.getAbsolutePath());
			MemberVo member = (MemberVo) session.getAttribute("loginUser");
			
			memberVo.setMem_Img(file.getName());
			
			memberVo.setMem_Email(((MemberVo) (session
					.getAttribute("loginUser"))).getMem_Email());
			/*session.removeAttribute("loginUser");*/
			
			request.setAttribute("memberVo", memberVo);
			try {
				memberService.updateMemberImg(memberVo);
				member.setMem_Img(memberVo.getMem_Img());
				session.setAttribute("loginUser", member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "main/c8";
		}
		System.out.println("null");
		return "main/c8";

	}
	
	@RequestMapping(value = "/profileImg", method = RequestMethod.GET)
	public String profileImg(HttpSession session, Model model) {
		String url = "main/profileImg";
		return url;
	}

	@RequestMapping(value = "/alramView", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> selectAlarmView(
			HttpSession session) throws SQLException {
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		String p_Mem_Email = member.getMem_Email();
		String mem_Email = member.getMem_Email();
		List<MemApplyViewVo> memApplyViewList = memberService
				.selectMemApplyViewByEmail(p_Mem_Email);
		List<ProjInviteViewVo> projInviteViewList = inviteService.selectInviteListByMemEmail(mem_Email);
		
		Map<String,Object> alarmMap = new HashMap<String, Object>();
		alarmMap.put("memApplyViewList", memApplyViewList);
		alarmMap.put("projInviteViewList", projInviteViewList);
		
		return alarmMap;
	}

	
	@RequestMapping(value = "/alarmCount", method = RequestMethod.GET)
	public @ResponseBody int selectAlarmCount(HttpSession session) throws SQLException{
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		int memApplyViewCount = memberService.selectCountMemApplyViewByEmail(memberVo.getMem_Email());
		int projInviteViewCount = inviteService.selectInviteCount(memberVo.getMem_Email());
		int totalCount = projInviteViewCount+memApplyViewCount;
		return totalCount;

	}

	@RequestMapping(value = "/searchEmail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> SearchEmail(
			@RequestBody Map<String, Object> map, Model model)
			throws SQLException {
		String Id = "";
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_Name(map.get("sendName").toString());
		memberVo.setMem_Phone(map.get("sendPhone").toString());

		MemberVo memberVo1 = memberService.searchEmail(memberVo);
		if (memberVo1 != null) {

			Id = memberVo1.getMem_Email();
		}

		map.put("id", Id);
		return map;
	}

	@RequestMapping(value = "/agreeApply", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> agreeApplyAlarm(
			@RequestBody Map<String, Object> map,HttpSession session) throws SQLException {
		Map<String,Object> alarmMap = new HashMap<String, Object>();
		
		String apply_Num = (String) map.get("apply_Num");
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = member.getMem_Email();
		
		List<MemApplyViewVo> memApplyViewList = memberService
				.updateApplyAgree(Integer.parseInt(apply_Num));
		List<ProjInviteViewVo> projInviteViewList = inviteService.selectInviteListByMemEmail(mem_Email);
		alarmMap.put("memApplyViewList", memApplyViewList);
		alarmMap.put("projInviteViewList", projInviteViewList);
		
		return alarmMap;
	}
	
	
	@RequestMapping(value = "/rejectApply", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> rejectApplyAlarm(
			@RequestBody Map<String, Object> map,HttpSession session) throws SQLException {
		Map<String,Object> alarmMap = new HashMap<String, Object>();
		String apply_Num = (String) map.get("apply_Num");
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = member.getMem_Email();
		List<MemApplyViewVo> memApplyViewList = memberService.updateApplyReject(Integer.parseInt(apply_Num));
		List<ProjInviteViewVo> projInviteViewList = inviteService.selectInviteListByMemEmail(mem_Email);
		alarmMap.put("memApplyViewList", memApplyViewList);
		alarmMap.put("projInviteViewList", projInviteViewList);
		return alarmMap;
	}
	
	@RequestMapping(value = "/agreeInvite", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> agreeInviteAlarm(
			@RequestBody Map<String, Object> map,HttpSession session) throws SQLException {
		Map<String,Object> alarmMap = new HashMap<String, Object>();
		String invite_Num = (String) map.get("invite_Num");
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		String p_mem_Email = member.getMem_Email();
		
		List<MemApplyViewVo> memApplyViewList = memberService.selectMemApplyViewByEmail(p_mem_Email);
		List<ProjInviteViewVo> projInviteViewList = inviteService.updataInviteAgree(Integer.parseInt(invite_Num));
		alarmMap.put("memApplyViewList", memApplyViewList);
		alarmMap.put("projInviteViewList", projInviteViewList);
		return alarmMap;
	}

	@RequestMapping(value = "/rejectInvite", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> rejectInviteAlarm(
			@RequestBody Map<String, Object> map,HttpSession session) throws SQLException {
		Map<String,Object> alarmMap = new HashMap<String, Object>();
		String invite_Num = (String) map.get("invite_Num");
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		String p_Mem_Email = member.getMem_Email();
		List<MemApplyViewVo> memApplyViewList = memberService.selectMemApplyViewByEmail(p_Mem_Email);
		List<ProjInviteViewVo> projInviteViewList = inviteService.updataInviteReject(Integer.parseInt(invite_Num));
		
		alarmMap.put("memApplyViewList", memApplyViewList);
		alarmMap.put("projInviteViewList", projInviteViewList);
		return alarmMap;
	}
	
	
	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public @ResponseBody int createProject(@RequestBody ProjectVo projectVo)
			throws SQLException {
		ProjectJoinVo projectJoinVo = new ProjectJoinVo();
		projectJoinVo.setMem_Email(projectVo.getMem_Email());
		projectJoinVo.setMem_Name(projectVo.getMem_Name());
		projectJoinVo.setMem_Img(projectVo.getMem_Img());
		projectJoinVo.setPjj_Per_Num(1);
		projectJoinVo.setPosition_Num(1);
		int proj_Num = projectService.insertProject(projectVo, projectJoinVo);
		return proj_Num;
	}
	@RequestMapping(value="/messageReceiveList", method=RequestMethod.GET)
	public String MessageReceiveList( MessageVo messageVo, Model model, HttpSession session) throws SQLException{
		String url = "main/messageReceiveList";
		MemberVo memberVo=(MemberVo) session.getAttribute("loginUser");
		messageVo.setMsg_rm_Email(memberVo.getMem_Email());
		List<MessageVo> messageList = new ArrayList<MessageVo>();
		messageList=messageService.selectReceiveMessageList(messageVo);
		model.addAttribute("messageList",messageList);	
		return url;
	}
	@RequestMapping(value="/messageSendList", method=RequestMethod.GET)
	public String MessageSendList( MessageVo messageVo,Model model, HttpSession session) throws SQLException{
		String url = "main/messageSendList";
		MemberVo memberVo=(MemberVo) session.getAttribute("loginUser");
		messageVo.setMsg_sm_Email(memberVo.getMem_Email());
		List<MessageVo> messageList = new ArrayList<MessageVo>();
		messageList=messageService.selectSendMessageList(messageVo);
		model.addAttribute("messageList",messageList);	
		return url;
	}
	//받은쪽지 디테일
	@RequestMapping(value="/messageReceiveDetail", method=RequestMethod.GET)
	public String MessageReceiveDetail(int msg_Article_Num, Model model, HttpSession session) throws NumberFormatException, SQLException{
		String url = "main/messageReceiveDetail";
		MessageVo asdf = messageService.selectReceiveMessageDetail(msg_Article_Num);
		model.addAttribute("messageVo", asdf);
		System.out.println("controller MessageVo"+asdf);
		return url;
		
	}
	
	//보낸 쪽지 디테일
	@RequestMapping(value="/messageSendDetail", method=RequestMethod.GET)
	public String MessageSendDetail(int msg_Article_Num, Model model, HttpSession session) throws NumberFormatException, SQLException{
		String url = "main/messageSendDetail";
		System.out.println(msg_Article_Num);
		MessageVo messageVo = messageService.selectSendMessage(msg_Article_Num);
		model.addAttribute("messageVo", messageVo);
		System.out.println(msg_Article_Num);
		System.out.println("detail"+ messageVo);
		
		return url;
		
	}
	
	@RequestMapping(value="/messageWrite", method=RequestMethod.GET)
	public String MessageWrite(HttpSession session, Model model){
		String url = "main/messageWrite";
		return url;
	}
	//쪽지 보내기
	@RequestMapping(value="/messageInsert", method=RequestMethod.POST)
	public String MessageInsert(MessageVo messageVo, HttpSession session) throws SQLException{
		String url = "redirect:messageSendList";
		System.out.println(messageVo);
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_sm_Email = memberVo.getMem_Email();
		String mem_sm_Name = memberVo.getMem_Name();
		
		MemberVo memberVo1 = memberService.getMember(messageVo.getMsg_rm_Email());
		
		messageVo.setMsg_sm_Email(mem_sm_Email);
		messageVo.setMsg_sm_Name(mem_sm_Name);
		messageVo.setMsg_rm_Name(memberVo1.getMem_Name());

		messageService.insertMessage(messageVo);
		/*messageVo.setMsg_rm_Email(msg_rm_Email);*/
		return url;
	}
	
	//보낸 쪽지 삭제하기
	@RequestMapping(value="/messageSendDelete")
	public @ResponseBody boolean DeleteSendMessage(int msg_Article_Num, HttpSession session, Model model) throws SQLException{
		messageService.updateSendMessageDelYN(msg_Article_Num);
		System.out.println("타는거 맞음?");
		return true;
		
	}
	@RequestMapping(value="/messageReceiveDelete")
	public @ResponseBody boolean DeleteReceiveMessage(int msg_Article_Num, HttpSession session, Model model) throws SQLException{
		messageService.updateReceiveMessageDelYN(msg_Article_Num);
		
		return true;
	}
	@RequestMapping(value="selectMemberInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> selectMemberInfo(@RequestBody ProjectLogVo projectLogVo,HttpSession session)throws SQLException{
		ProjectLogVo resultVo =projectLogService.selectLastProjectLogList(projectLogVo);
		MemberVo memberVo = memberService.selectByMemEmail(projectLogVo.getMem_Email());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mem_Name", memberVo.getMem_Name());
		map.put("mem_Recent_Project_Login", resultVo.getProj_Log_Time());
		return map;
	}
}
