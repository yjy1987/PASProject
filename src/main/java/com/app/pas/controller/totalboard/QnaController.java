package com.app.pas.controller.totalboard;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pas.commons.Paging;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.board.QnaBoardReplyVo;
import com.app.pas.dto.board.QnaBoardVo;
import com.app.pas.service.MemberService;
import com.app.pas.service.board.QnaBoardReplyService;
import com.app.pas.service.board.QnaBoardService;

@Controller
@RequestMapping("/qna")
public class QnaController {

	@Autowired
	QnaBoardService qnaBoardService;
	@Autowired
	MemberService memberService;
	@Autowired
	QnaBoardReplyService qnaBoardReplyService;
	@Autowired
	HttpServletRequest request;
	
	//내가쓴글 보기
	@RequestMapping("/myPostList")
	public String myPostList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,
			QnaBoardVo qnaBoardVo,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content,
			@RequestParam(defaultValue = "") String title_content,
			String myPost,
			HttpSession session
			) throws SQLException {
		String url = "qna/QnAList";
		int totalCount = 0;
		List<QnaBoardVo> qnaList = new ArrayList<QnaBoardVo>();
		//로그인 정보 가져오기
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		qnaBoardVo.setMem_Email(mem_Email);
		
	
		if (keyField == "" || keyField.equals(null)) {
			qnaList = qnaBoardService.myPostList(qnaBoardVo);
			model.addAttribute("qnaList", qnaList);
			totalCount = qnaBoardService.myPostListCount(qnaBoardVo);
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);
			
		}else{
			
		 if (keyField == ("name") || keyField.equals("name")) {

			 qnaBoardVo.setMem_Name(keyword);
			System.out.println("--------------name 키워드 : " + keyword);

		} else if (keyField == ("title") || keyField.equals("title")) {
			qnaBoardVo.setQb_Title(keyword);
			System.out.println("-----------------title 키워드 : " + keyword);

		} else if (keyField == ("number") || keyField.equals("number")) {
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoardVo.setQb_Article_Num(Integer.parseInt(keyword));

			System.out.println("-----------------number 키워드 : " + keyword);
		} else if (keyField == ("content") || keyField.equals("content")) {
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoardVo.setQb_Content(keyword);
			System.out.println("-----------------content 키워드 : " + keyword);
		
		} else if (keyField == ("title_content") || keyField.equals("title_content")){
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoardVo.setQb_Title_Content(keyword);
			
		}

		qnaList = qnaBoardService.myPostList(qnaBoardVo);
		model.addAttribute("qnaList", qnaList);
		totalCount = (Integer)qnaBoardService.myPostListCount(qnaBoardVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		model.addAttribute("paging", paging);

	}
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}
		totalCount =(Integer)qnaBoardService.myPostListCount(qnaBoardVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		model.addAttribute("paging", paging);

	
		return url;
	}
	
	

	// qnaList
	@RequestMapping("/QnAList")
	public String QnaList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,
			QnaBoardVo qnaBoarVo,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content,
			@RequestParam(defaultValue = "") String title_content,
			String myPost,
			HttpSession session
			) throws SQLException {
		String url = "qna/QnAList";
		int totalCount = 0;
		List<QnaBoardVo> qnaList = new ArrayList<QnaBoardVo>();
		if (keyField == "" || keyField.equals(null)) {
			totalCount = qnaBoardService.QnaSelectTotalCount();
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);
			
		}else{
			
			
		 if (keyField == ("name") || keyField.equals("name")) {

			qnaBoarVo.setMem_Name(keyword);
			System.out.println("--------------name 키워드 : " + keyword);

		} else if (keyField == ("title") || keyField.equals("title")) {
			qnaBoarVo.setQb_Title(keyword);
			System.out.println("-----------------title 키워드 : " + keyword);

		} else if (keyField == ("number") || keyField.equals("number")) {
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoarVo.setQb_Article_Num(Integer.parseInt(keyword));

			System.out.println("-----------------number 키워드 : " + keyword);
		} else if (keyField == ("content") || keyField.equals("content")) {
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoarVo.setQb_Content(keyword);
			System.out.println("-----------------content 키워드 : " + keyword);
		
		} else if (keyField == ("title_content") || keyField.equals("title_content")){
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoarVo.setQb_Title_Content(keyword);
			
		}

		qnaList = qnaBoardService.selectQnaBoardList(qnaBoarVo);
		model.addAttribute("qnaList", qnaList);
		totalCount = (Integer)qnaBoardService.QnaSearchTotalCount(qnaBoarVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		model.addAttribute("paging", paging);

	}
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}
		totalCount =(Integer)qnaBoardService.QnaSearchTotalCount(qnaBoarVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		model.addAttribute("paging", paging);
			
		// 페이징처리
	
		return url;
	}

	// 디테일 

	@RequestMapping(value = "/QnADetail")

	public String detailQna(@RequestParam String qb_Article_Num, Model model,
			HttpSession session,String qna_Pwd, String num) throws NumberFormatException, SQLException {
		String url = "qna/QnADetail";
		QnaBoardReplyVo qnaBoardReplyVo = null;

		QnaBoardVo qnaBoardVo = qnaBoardService.selectQnaBoard(Integer
				.parseInt(qb_Article_Num));
		System.out.println("컨트롤러 debug : "+ qnaBoardVo);
		String Qb_PWD = qnaBoardVo.getQb_Password();
		
		
		System.out.println("Qb_PWD : "+ Qb_PWD);
		System.out.println("qna_Pwd : "+ qna_Pwd);
		
		
		
		if (Qb_PWD == qna_Pwd || Qb_PWD.equals(qna_Pwd)){
			System.out.println("if문이 잘 작동하는ㄴ지 ##################");
			}
		model.addAttribute("Qb_PWD", Qb_PWD);	
		model.addAttribute("qnaBoardVo", qnaBoardVo);
		
		
		
		qnaBoardReplyVo = qnaBoardReplyService.selectQnaReply(Integer
				.parseInt(qb_Article_Num));
		// 조횟수
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String session_Email = memberVo.getMem_Email();
		String qnaBoard_Email = qnaBoardVo.getMem_Email();

		if (!session_Email.equals(qnaBoard_Email)) {

			qnaBoardService.QnaBoardCount(Integer.parseInt(qb_Article_Num));
		}
		
		model.addAttribute("session_Email", session_Email);
		model.addAttribute("qnaBoardReplyVo", qnaBoardReplyVo);
	

		return url;
	}

	@RequestMapping(value = "/insertQnABoard", method = RequestMethod.POST)
	public String insertQna(HttpSession session, Model model,
			QnaBoardVo qnaBoardVo,String qb_Password) throws SQLException {
		String url = "redirect:QnAList";

		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");

		String mem_Email = memberVo.getMem_Email();
		qnaBoardVo.setMem_Email(mem_Email);
	
		String mem_Name = memberVo.getMem_Name();
		qnaBoardVo.setMem_Name(mem_Name);
		
		qnaBoardVo.setQb_Password(qb_Password);
	
		qnaBoardService.insertQnaBoard(qnaBoardVo);
	

		return url;

	}

	// qna글쓰기
	@RequestMapping("/QnAWrite")
	public String writeQna(Model model, QnaBoardVo qnaBoardVo) {
		String url = "qna/QnAWrite";
		return url;

	}

	// 수정 폼
	@RequestMapping(value = "/QnAUpdate", method = RequestMethod.GET)
	public String updateQnaForm(@RequestParam String qb_Article_Num,
			HttpSession session, Model model) {
		String url = "qna/QnAUpdate";

		QnaBoardVo qnaBoardVo;
		try {
			qnaBoardVo = qnaBoardService.selectQnaBoard(Integer
					.parseInt(qb_Article_Num));
			model.addAttribute("qnaBoardVo", qnaBoardVo);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;

	}

	// 글 수정
	@RequestMapping(value = "/QnAUpdate", method = RequestMethod.POST)
	public String updateQnaBoard(QnaBoardVo qnaBoardVo) throws SQLException {
		String url = "redirect:QnAList";

		qnaBoardService.updateQnaBoard(qnaBoardVo);

		return url;
	}

	@RequestMapping("/QnADelete")
	public String deleteQna(HttpSession session, Model model) {
		String url = "";
		return url;
	}


	// 글 삭제
	@RequestMapping(value = "/QnADelete", method = RequestMethod.POST)
	public String deleteQnaBoard(String qb_Article_Num) throws NumberFormatException, SQLException {
		String url = "redirect:QnAList";
		
		qnaBoardService.deleteQnaBoard(Integer.parseInt(qb_Article_Num));
	
		return url;

	}

}
