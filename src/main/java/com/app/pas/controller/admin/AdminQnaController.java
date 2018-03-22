package com.app.pas.controller.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pas.commons.Paging;
import com.app.pas.dto.board.QnaBoardReplyVo;
import com.app.pas.dto.board.QnaBoardVo;
import com.app.pas.service.board.QnaBoardReplyService;
import com.app.pas.service.board.QnaBoardService;

@Controller
@RequestMapping("/admin")
public class AdminQnaController {

	@Autowired
	QnaBoardService qnaBoardService;

	@Autowired
	QnaBoardReplyService qnaBoardReplyService;

	// 관리자 Qna 리스트
	@RequestMapping("/AdminQnAList")
	public String QnaList(Model model,
			@RequestParam(value = "page", defaultValue = "1") String page,QnaBoardVo qnaBoarVo
			,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="") String keyField
			,@RequestParam(defaultValue="")String name,@RequestParam(defaultValue="")String title,
			@RequestParam(defaultValue="")String number) throws SQLException {
		String url = "admin/adminQnAList";
		int totalCount = 0;
		List<QnaBoardVo> qnaList = new ArrayList<QnaBoardVo>();
		
		if (keyField == "" || keyField.equals(null)) {
			System.out.println("asdsad");
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
		}else if (keyField == ("title_content") || keyField.equals("title_content")){
			if (!(keyword.isEmpty() || keyword == null))
				qnaBoarVo.setQb_Title_Content(keyword);
		}


		qnaList = qnaBoardService.selectQnaBoardList(qnaBoarVo);
		model.addAttribute("qnaList", qnaList);
		
		totalCount =(Integer)qnaBoardService.QnaSearchTotalCount(qnaBoarVo);
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);

	}
		return url;
	}
	//디테일
	@RequestMapping("/AdminQnADetail")
	public String detailQna(@RequestParam String qb_Article_Num, Model model) {
		String url = "admin/adminQnADetail";
			//List<QnaBoardReplyVo> QnaReplyList = new ArrayList<QnaBoardReplyVo>();	
		QnaBoardReplyVo qnaBoardReplyVo = null;
		try {
			QnaBoardVo qnaBoardVo = qnaBoardService.selectQnaBoard(Integer
					.parseInt(qb_Article_Num));
			qnaBoardReplyVo = qnaBoardReplyService.selectQnaReply(Integer.parseInt(qb_Article_Num));
			
			model.addAttribute("qnaBoardReplyVo", qnaBoardReplyVo);
			model.addAttribute("qnaBoardVo", qnaBoardVo);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}
	
	
//댓글작성----------------------------------------------------------------------
	@RequestMapping(value="/InsertQnAReply", method=RequestMethod.POST)
	public String insertQnaBoardReply(QnaBoardReplyVo qnaBoardReplyVo,Model model){
		System.out.println("댓글작성중..");
		
		String qb_Article_Num = qnaBoardReplyVo.getQb_Article_Num()+"";
		
		String url = "redirect:AdminQnADetail?qb_Article_Num="+qb_Article_Num;
		
		qnaBoardReplyVo.setAdmin_Email("admin");
		System.out.println(qnaBoardReplyVo.toString());
		try {
			
			qnaBoardReplyService.insertQnaBoardReply(qnaBoardReplyVo, Integer.parseInt(qb_Article_Num));
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		System.out.println("답글하는즁");
		return url;
	
	}
//-------  댓글폼  ------------------------------------------------------------	
	@RequestMapping("/AdminQnAReplyForm")
	public String QnAReplyForm(@RequestParam String qb_Article_Num, Model model) throws NumberFormatException, SQLException {
		QnaBoardVo qnaBoardVo = qnaBoardService.selectQnaBoard(Integer
				.parseInt(qb_Article_Num));
		
		model.addAttribute("qnaBoardVo", qnaBoardVo);
		String url = "admin/adminQnAReplyForm";
		return url;
	}
	
//-------  답글수정폼  ------------------------------------------------------------
	@RequestMapping("/QnAReplyUpdateForm")
	public String QnAReplyUpdateForm(@RequestParam String qb_Article_Num, Model model) {
	String url = "admin/adminQnAReplyUpdate";
		
	QnaBoardReplyVo qnaBoardReplyVo = null;
	try {
		QnaBoardVo qnaBoardVo = qnaBoardService.selectQnaBoard(Integer
				.parseInt(qb_Article_Num));
		qnaBoardReplyVo = qnaBoardReplyService.selectQnaReply(Integer.parseInt(qb_Article_Num));
		
		model.addAttribute("qnaBoardReplyVo", qnaBoardReplyVo);
		model.addAttribute("qnaBoardVo", qnaBoardVo);
		System.out.println("댓글 수정 폼 qnaBoardReplyVo" + qnaBoardReplyVo );
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return url;
	}
//-------  답글수정  ------------------------------------------------------------	
	@RequestMapping(value="/QnAReplyUpdate",method=RequestMethod.POST)
	public String QnAReplyUpdate(QnaBoardReplyVo qnaBoardReplyVo, Model model) throws SQLException {
		System.out.println("수정오긴오니;");
		//아예 그 페이지로 이동하기 위해선 redirect를 쓴다.
		//qb_Article_Num을 통해 데이터의 값을 select하기 때문에 qb_Article_Num도 같이 넘겨준다.
		//jsp로 이동하는건 파라미터를 url로 넘길수 없다.
		String qb_Article_Num = qnaBoardReplyVo.getQb_Article_Num()+"";
		String url = "redirect:AdminQnADetail?qb_Article_Num="+qb_Article_Num;
	
	qnaBoardReplyService.updateQnaBoardReply(qnaBoardReplyVo);
	System.out.println("댓글수정하는 중  " + qnaBoardReplyVo);
	
	
	return url;
	}
//------- 답변삭제 --------------------------------------------------------------	
	@RequestMapping(value="/QnAReplyDelete", method=RequestMethod.POST)
	public String deleteQna(QnaBoardReplyVo qnaBoardReplyVo, Model model) throws NumberFormatException, SQLException {
		System.out.println("답변삭제로 오는가?");
	//	String url = "admin/adminQnADetail";
		String qb_Article_Num = qnaBoardReplyVo.getQb_Article_Num()+"";
		String url = "redirect:AdminQnADetail?qb_Article_Num="+qb_Article_Num;
		qnaBoardReplyService.deleteQnaBoardReply(Integer.parseInt(qb_Article_Num));
		return url;
	}
	
	
//-------  댓글수정  ------------------------------------------------------------
//	@RequestMapping(value="/QnAReplyUpdate",method=RequestMethod.POST)
//	public String QnAReplyUpdate(@RequestParam String qb_Article_Num, Model model) {
//		//QnaBoardReplyVo qnaBoardReplyVo = null;
//	
//		
//		String url = "admin/adminQnAReplyUpdate";
//		
//		return url;
//	}
//--------------------------------------------------------------------------

	
	
	
}
