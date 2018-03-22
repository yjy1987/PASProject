package com.app.pas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model,HttpServletRequest request) {
		String url = "index";
		
		String exit = request.getParameter("exit");
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
		model.addAttribute("exit", exit);
		return url;
	}

}
