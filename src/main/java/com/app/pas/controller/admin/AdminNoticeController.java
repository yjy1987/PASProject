package com.app.pas.controller.admin;

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
import com.app.pas.dto.board.TotalNoticeVo;
import com.app.pas.service.board.TotalNoticeService;

@Controller
@RequestMapping("/admin")
public class AdminNoticeController {
	
	@Autowired
	TotalNoticeService totalNoticeService;
	
//전체공지사항 List 
	@RequestMapping("/AdminTotalNoticeList")
	public String selectTotalNoticeList(HttpSession session, Model model,HttpServletRequest request,
			@RequestParam(value = "page", defaultValue = "1") String page,
			TotalNoticeVo totalNoticeVo ,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") String number) throws SQLException {
		String url = "admin/adminNoticeList";
		List<TotalNoticeVo> noticeList = new ArrayList<TotalNoticeVo>();
		int totalCount = 0;
		
		if (keyField == "" || keyField.equals(null)) {
			totalCount = totalNoticeService.toTalNoticeTotalCount();
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);
		
		model.addAttribute("paging", paging);
		}else{
			
			if(keyField == ("title") || keyField.equals("title")) {
				
				totalNoticeVo.setTtnotice_Title(keyword);
				
			}else if (keyField == ("number") || keyField.equals("number")) {
				if (!(keyword.isEmpty() || keyword == null))
					totalNoticeVo.setTtnotice_Num(Integer.parseInt(keyword));

				System.out.println("-----------------number 키워드 : " + keyword);
			}else if(keyField ==("title_Content")|| keyField.equals("title_Content")){
				if(!(keyword.isEmpty()|| keyword ==null))
					totalNoticeVo.setTtnotice_Title_Content(keyword);
				
			}
				noticeList = totalNoticeService.selectTotalNoticeList(totalNoticeVo);
				model.addAttribute("noticeList", noticeList);
			
			totalCount = totalNoticeService.toTalNoticeSearchCount(totalNoticeVo);
			
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
//전체 공지사항 Detail
	@RequestMapping("/adminNoticeDetail")
	public String detailTotalNotice(HttpSession session, Model model,String ttnotice_Num) throws NumberFormatException, SQLException {
		String url = "admin/adminNoticeDetail";
		
		TotalNoticeVo totalNoticeVo = totalNoticeService.selectTotalNoticeBoard(Integer.parseInt(ttnotice_Num));
		model.addAttribute("totalNoticeVo",totalNoticeVo);
		return url;
	}
	
//글쓰기 폼 
	@RequestMapping(value = "/adminNoticeForm" , method=RequestMethod.GET)
	public String insertNoticeForm(HttpSession session, Model model, TotalNoticeVo totalNoticeVo) throws SQLException {
		String url = "admin/adminNoticeWrite";
	
		return url;
	}
//글쓰기	
	@RequestMapping(value = "/adminNoticeInsert", method=RequestMethod.POST)
	public String insertTotalNotice(HttpSession session, Model model, TotalNoticeVo totalNoticeVo) throws SQLException {
		//String url = "redirect:adminNoticeList";
		
		System.out.println("어드민 디버깅");
		String url = "redirect:AdminTotalNoticeList";
		totalNoticeVo.setAdmin_Email("admin");
		totalNoticeService.insertTotalNotice(totalNoticeVo);
	
		return url;
	}

//삭제 	
	@RequestMapping(value = "/adminNoticeDelete",method=RequestMethod.POST)
	public String deleteNotice(HttpSession session, Model model,String ttnotice_Num) throws NumberFormatException, SQLException{
		String url = "redirect:AdminTotalNoticeList";
		totalNoticeService.deleteTotalNotice(Integer.parseInt(ttnotice_Num));
		
		return url;
	}
//수정 폼	
	@RequestMapping("/adminNoticeUpdateForm")
	public String totalNoticeUpdateForm(HttpSession session, Model model,String ttnotice_Num) throws NumberFormatException, SQLException {
		String url = "admin/adminNoticeUpdateForm";
		TotalNoticeVo totalNoticeVo = null;
		
		totalNoticeVo = totalNoticeService.selectTotalNoticeBoard(Integer.parseInt(ttnotice_Num));
		model.addAttribute("totalNoticeVo", totalNoticeVo);
		return url;
	}
//진짜 수정	
	@RequestMapping(value = "/adminNoticeUpdate", method=RequestMethod.POST)
	public String updateTotalNotice(HttpSession session, Model model, TotalNoticeVo totalNoticeVo) throws SQLException {
		String url = "redirect:AdminTotalNoticeList";
		totalNoticeService.updateTotaTotalNotice(totalNoticeVo);
		
		return url;
	}


}
