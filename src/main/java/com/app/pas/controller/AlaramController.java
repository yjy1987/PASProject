package com.app.pas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pas.dto.MemberVo;
import com.app.pas.service.MemberService;

@Controller
@RequestMapping("/alarm")
public class AlaramController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/viewAlarm")
	public String viewAlarm(HttpSession session, Model model) {
		String url = "";
		MemberVo member = memberService.getMember("abc@naver.com");
		System.out.println(member.toString());
		return url;

	}

	@RequestMapping("/alarmInsert")
	public String insertAlarm(HttpSession session, Model model) {
		String url = "";
		return url;

	}

	@RequestMapping("/alarmDelete")
	public String deleteAlarm(HttpSession session, Model model) {
		String url = "";
		return url;
	}

	@RequestMapping("/invitation")
	public String invitationMember(HttpSession session, Model model) {
		String url = "";
		return url;
	}

	@RequestMapping("/apply")
	public String applyForMemberShip(HttpSession session, Model model) {
		String url = "";
		return url;
	}

}
