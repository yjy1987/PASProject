package com.app.pas.controller.totalboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.app.pas.dto.board.SkillSharingBoardLikeVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardVo;
import com.app.pas.service.board.SkillSharingBoardReplyService;
import com.app.pas.service.board.SkillSharingBoardService;

@Controller
@RequestMapping("/SkillSharing")
public class SkillSharingController {

	@Autowired
	SkillSharingBoardService skillSharingBoardService;
	@Autowired
	SkillSharingBoardReplyService skillSharingBoardReplyService;

	// 내가쓴글 보기 + 페이징
	@RequestMapping("/skill_myPostList")
	public String ssb_myPostList(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(defaultValue = "") String ssb_Title, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String title_content,
			@RequestParam(defaultValue = "") String tag, HttpSession session, SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException {
		String url = "SkillSharing/SkillSharingBoardList";
		int totalCount = 0;
		List<SkillSharingBoardVo> skillSharingBoardList = new ArrayList<SkillSharingBoardVo>();
		// 로그인정보 가져오기
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		skillSharingBoardVo.setMem_Email(mem_Email);

		if (keyField == "" || keyField.equals(null)) {
			skillSharingBoardList = skillSharingBoardService.skill_myPostList(skillSharingBoardVo);
			model.addAttribute("skillSharingBoardList", skillSharingBoardList);
			totalCount = skillSharingBoardService.skill_myPostCount(skillSharingBoardVo);

			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(10);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);
		} else {

			if (keyField == ("name") || keyField.equals("name")) {

				skillSharingBoardVo.setMem_Name(keyword);
				System.out.println("--------------name 키워드 : " + keyword);

			} else if (keyField == ("title") || keyField.equals("title")) {
				skillSharingBoardVo.setSsb_Title(keyword);
				System.out.println("-----------------title 키워드 : " + keyword);

			} else if (keyField == ("number") || keyField.equals("number")) {
				if (!(keyword.isEmpty() || keyword == null))
					skillSharingBoardVo.setSsb_Article_Num(Integer.parseInt(keyword));
				System.out.println("-----------------number 키워드 : " + keyword);

			} else if (keyField == ("content") || keyField.equals("content")) {
				if (!(keyword.isEmpty() || keyword == null))
					skillSharingBoardVo.setSsb_Content(keyword);

				System.out.println("-----------------content 키워드 : " + keyword);
			} else if (keyField == ("title_content") || keyField.equals("title_content")) {

				skillSharingBoardVo.setSsb_Title_Content(keyword);

			} else if (keyField == ("tag") || keyField.equals("tag")) {

				skillSharingBoardVo.setSsb_Tag(keyword);

			}
			skillSharingBoardList = skillSharingBoardService.skill_myPostList(skillSharingBoardVo);
			model.addAttribute("skillSharingBoardList", skillSharingBoardList);
			totalCount = (Integer) skillSharingBoardService.skill_myPostCount(skillSharingBoardVo);

			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);
		}
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}
		totalCount = (Integer) skillSharingBoardService.skill_myPostCount(skillSharingBoardVo);

		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);
		return url;
	}

	// 기술공유 전체리스트
	@RequestMapping("/SkillSharingBoardList")
	public String skillSharingBoardList(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(defaultValue = "") String ssb_Title, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String title_content,
			@RequestParam(defaultValue = "") String tag, SkillSharingBoardVo skillSharingBoardVo, HttpServletRequest request
			) throws SQLException {
		String url = "SkillSharing/SkillSharingBoardList";
		String delete = request.getParameter("delete");
		String modify = request.getParameter("modify");
		int totalCount = 0;
		List<SkillSharingBoardVo> skillSharingBoardList = new ArrayList<SkillSharingBoardVo>();

		if (keyField == "" || keyField.equals(null)) {
			totalCount = skillSharingBoardService.selectTotalCount();
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(10);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);
		} else {

			if (keyField == ("name") || keyField.equals("name")) {

				skillSharingBoardVo.setMem_Name(keyword);
				System.out.println("--------------name 키워드 : " + keyword);

			} else if (keyField == ("title") || keyField.equals("title")) {
				skillSharingBoardVo.setSsb_Title(keyword);
				System.out.println("-----------------title 키워드 : " + keyword);

			} else if (keyField == ("number") || keyField.equals("number")) {
				if (!(keyword.isEmpty() || keyword == null))
					skillSharingBoardVo.setSsb_Article_Num(Integer.parseInt(keyword));
				System.out.println("-----------------number 키워드 : " + keyword);

			} else if (keyField == ("content") || keyField.equals("content")) {
				if (!(keyword.isEmpty() || keyword == null))
					skillSharingBoardVo.setSsb_Content(keyword);

				System.out.println("-----------------content 키워드 : " + keyword);
			} else if (keyField == ("title_content") || keyField.equals("title_content")) {

				System.out.println("존트짜증 ㅡㅡ");
				skillSharingBoardVo.setSsb_Title_Content(keyword);
				System.out.println("타이틀+컨텐츠  : " + skillSharingBoardVo.getSsb_Title_Content());

			} else if(keyField ==("tag")|| keyField.equals("tag")){
	             if(!(keyword.isEmpty()|| keyword == null))
	                 skillSharingBoardVo.setSsb_Tag(keyword);
	           
				}
				System.out.println("tag  : " + skillSharingBoardVo.getSsb_Tag());

			}
			skillSharingBoardList = skillSharingBoardService.selectSkillSharingBoardList(skillSharingBoardVo);
			model.addAttribute("skillSharingBoardList", skillSharingBoardList);

			if (page.equals(null) || page == "") {
				page = "" + 1;
			}
			totalCount = (Integer) skillSharingBoardService.skillSharingSearchCount(skillSharingBoardVo);
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);
			model.addAttribute("delete",delete);
			model.addAttribute("modify",modify);
			model.addAttribute("paging", paging);
		
		return url;
	}

	@RequestMapping("/SkillSharingDetail")
	public String detailskillSharingBoard(@RequestParam String ssb_Article_Num, Model model, HttpServletRequest request,
			HttpSession session, SkillSharingBoardReplyVo skillSharingBoardReplyVo)
			throws NumberFormatException, SQLException {

		/*
		 * MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		 * String mem_Email = memberVo.getMem_Email();
		 */

		String url = "SkillSharing/SkillSharingDetail";

		String like = "";
		String modify = null;
		String message = null;
		String delete = null;
		String likee = null;
		message = request.getParameter("message");
		like = request.getParameter("like");
		modify = request.getParameter("modify");
		delete = request.getParameter("delete");
		likee = request.getParameter("likee");
		if (like != null) {
			model.addAttribute("like", like);
		}
		if (modify != null) {
			model.addAttribute("modify", modify);
		}
		if (delete != null) {
			model.addAttribute("delete", delete);
		}
		if (likee != null) {
			model.addAttribute("likee", likee);
		}

		SkillSharingBoardVo skillSharingBoardVo = null;
		skillSharingBoardVo = skillSharingBoardService.selectSkillSharingBoardDetail(Integer.parseInt(ssb_Article_Num));
		if (message == null) {
			System.out.println("detail message가 null일때 들어옴");
			skillSharingBoardService.updateSkillSharingBoardCount(skillSharingBoardVo);
		}
		model.addAttribute("skillSharingBoardVo", skillSharingBoardVo);

		return url;
	}

	@RequestMapping("/SkillSharingLike")
	public String detailskillSharingBoardLike(@RequestParam String ssb_Article_Num, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, SkillSharingBoardVo skillSharingBoardVo)
			throws SQLException, IOException {

		SkillSharingBoardLikeVo skillSharingBoardLikeVo = new SkillSharingBoardLikeVo();
		SkillSharingBoardLikeVo LikeMember = new SkillSharingBoardLikeVo();
		String url = "redirect:SkillSharingDetail?ssb_Article_Num=" + ssb_Article_Num;
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		skillSharingBoardVo.setSsb_Article_Num(Integer.parseInt(ssb_Article_Num));
		skillSharingBoardLikeVo.setSsb_Article_Num(Integer.parseInt(ssb_Article_Num));
		skillSharingBoardLikeVo.setMem_Email(memberVo.getMem_Email());

		LikeMember = skillSharingBoardService.selectSkillSharingBoardLikeList(skillSharingBoardLikeVo);

		if (LikeMember == null) {
			skillSharingBoardService.insertSkillSharingBoardLike(skillSharingBoardLikeVo);
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + ssb_Article_Num + "&like=yes&message=1";
		} else {
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + ssb_Article_Num + "&like=no&message=1";
		}
		return url;
	}


	@RequestMapping("/SkillSharingInsert")
	public String insertskillSharingBoardForm(HttpSession session, Model model) {
		String url = "skillSharing/SkillSharingWrite";
		return url;

	}

	@RequestMapping(value = "/SkillSharingInsert", method = RequestMethod.POST)
	public String insertskillSharingBoard(HttpSession session, SkillSharingBoardVo skillSharingBoardVo) throws SQLException {
		String url = "redirect:SkillSharingBoardList";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		if(skillSharingBoardVo.getSsb_Tag()==""){
			skillSharingBoardVo.setSsb_Tag("#");
	      }
		skillSharingBoardVo.setMem_Email(mem_Email);
		skillSharingBoardVo.setMem_Name(memberVo.getMem_Name());

		
		skillSharingBoardService.insertSkillSharingBoard(skillSharingBoardVo);

		

		return url;
	}

	@RequestMapping(value = "/SkillSharingUpdate", method = RequestMethod.GET)
	public String updateskillSharingBoardForm(String ssb_Article_Num, Model model,HttpSession session)throws NumberFormatException, SQLException{

		String url="SkillSharing/SkillSharingUpdate";
	      MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
	      String loginEmail = memberVo.getMem_Email();
	      SkillSharingBoardVo skillSharingBoardVo = skillSharingBoardService.selectSkillSharingBoardDetail(Integer.parseInt(ssb_Article_Num));
	    		  
	      String writeEmail = skillSharingBoardVo.getMem_Email();
	      if(loginEmail.equals(writeEmail)){
	            url = "SkillSharing/SkillSharingUpdate";
	            model.addAttribute("skillSharingBoardVo", skillSharingBoardVo);
	        }else{
	         url = "redirect:SkillSharingDetail?ssb_Article_Num="+ ssb_Article_Num+"&modify=no&message=1";
	        }
	       
	      
	      return url;
	   }

	@RequestMapping(value = "/SkillSharingUpdate", method = RequestMethod.POST)
	public String updateskillSharingBoard(SkillSharingBoardVo skillSharingBoardVo) throws SQLException {

		 String url = "redirect:SkillSharingBoardList?modify=yes";
		 if(skillSharingBoardVo.getSsb_Tag()==null || skillSharingBoardVo.getSsb_Tag()==""){
			 skillSharingBoardVo.setSsb_Tag("#"); 
	      }
		 skillSharingBoardService.updateSkillSharingBoard(skillSharingBoardVo);
	  
	     return url;
	   }

	@RequestMapping(value = "/SkillSharingWrite", method = RequestMethod.GET)
	public String writeskillSharingBoard(HttpSession session, Model model) {
		String url = "SkillSharing/SkillSharingWrite";
		return url;

	}

	@RequestMapping(value = "/SkillSharingDelete", method = RequestMethod.POST)
	public String deleteskillSharingBoard(String ssb_Article_Num, HttpSession session)
			throws NumberFormatException, SQLException {
		String url = "redirect:SkillSharingBoardList";

		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String loginEmail = memberVo.getMem_Email();
		SkillSharingBoardVo skillSharingBoardVo = skillSharingBoardService
				.selectSkillSharingBoardDetail(Integer.parseInt(ssb_Article_Num));

		String writeEmail = skillSharingBoardVo.getMem_Email();

		if (loginEmail.equals(writeEmail)) {
			skillSharingBoardService.deleteSkillSharingBoard(Integer.parseInt(ssb_Article_Num));

			url = "redirect:SkillSharingBoardList?delete=yes";
		} else {
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + ssb_Article_Num + "&delete=no&message=1";
		}
		return url;
	}

	@RequestMapping("/searchTitle")
	public String searchTitle(@RequestParam(defaultValue = "") String ssb_Title, Model model) throws SQLException {
		String url = "redirect:SkillSharingBoardList?ssb_Title=" + ssb_Title;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ssb_Title);
		/*
		 * List<SkillSharingBoardVo> skillSharingBoardList = null;
		 * 
		 * skillSharingBoardList =
		 * skillSharingBoardService.selectSearchSsbTitle(ssb_Title);
		 * 
		 * model.addAttribute("skillSharingBoardList", skillSharingBoardList);
		 */
		return url;
	}

	@RequestMapping(value = "/SkillSharingReplyList")
	public @ResponseBody List<SkillSharingBoardReplyVo> selectSkillSharingReplyList(
			@RequestBody Map<String, Object> jsonMap, Model model) {

		List<SkillSharingBoardReplyVo> skillSharingBoardReply = new ArrayList<SkillSharingBoardReplyVo>();
		String ssb_Article_Num = (String) jsonMap.get("ssb_Article_Num");
		System.out.println(ssb_Article_Num);
		try {
			skillSharingBoardReply = skillSharingBoardReplyService
					.selectSkillSharingBoardReply(Integer.parseInt(ssb_Article_Num));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("skillSharingBoardReply", skillSharingBoardReply);
		return skillSharingBoardReply;
	}

	@RequestMapping(value = "SkillSharingReplyWrite", method = RequestMethod.POST)
	public @ResponseBody List<SkillSharingBoardReplyVo> writeSkillSharingReply(
			@RequestBody SkillSharingBoardReplyVo skillSharingBoardReplyVo, HttpSession session) throws SQLException {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		String mem_Name = memberVo.getMem_Name();
		skillSharingBoardReplyVo.setSsb_Reply_Mem(mem_Email);
		skillSharingBoardReplyVo.setSsb_Reply_Mem_Name(mem_Name);
		List<SkillSharingBoardReplyVo> skillSharingBoardReplyList = new ArrayList<SkillSharingBoardReplyVo>();
		
			skillSharingBoardReplyService.insertSkillSharingBoardReply(skillSharingBoardReplyVo);
			skillSharingBoardReplyList = skillSharingBoardReplyService
					.selectSkillSharingBoardReply(skillSharingBoardReplyVo.getSsb_Article_Num());
		
		return skillSharingBoardReplyList;
	}

	@RequestMapping(value = "SkillSharingBoardReplyUpdate", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String updateSkillSharingBoardReply(int ssb_Reply_Num, String content,
			SkillSharingBoardReplyVo skillSharingBoardReplyVo, HttpSession session, HttpServletRequest request)
			throws SQLException {
		String url = "redirect:SkillSharingDetail";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		SkillSharingBoardReplyVo skillSharingBoardReplyVo1 = skillSharingBoardReplyService.selectSSBR(ssb_Reply_Num);
		String loginEmail = memberVo.getMem_Email();
		System.out.println(ssb_Reply_Num);
		System.out.println("skillSharingBoardReplyVo1" + skillSharingBoardReplyVo1);
		String writeEmail = skillSharingBoardReplyVo1.getSsb_Reply_Mem();
		if (loginEmail.equals(writeEmail)) {
			skillSharingBoardReplyVo1.setSsb_Reply_Content(content);
			skillSharingBoardReplyService.updateSkillSharingBoardReply(skillSharingBoardReplyVo1);
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + skillSharingBoardReplyVo.getSsb_Article_Num()
					+ "&modify=yes&message=1";
		} else {
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + skillSharingBoardReplyVo.getSsb_Article_Num()
					+ "&modify=no&message=1";
		}
		return url;

	}

	@RequestMapping(value = "SkillSharingReplyDelete", method = RequestMethod.POST)
	public String deleteSkillSharingBoardReply(int ssb_Reply_Num, SkillSharingBoardReplyVo skillSharingBoardReplyVo,
			HttpSession session) throws SQLException {

		String url = "redirect:SkillSharingDetail";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		SkillSharingBoardReplyVo skillSharingBoardReplyVo1 = skillSharingBoardReplyService.selectSSBR(ssb_Reply_Num);
		String loginEmail = memberVo.getMem_Email();
		System.out.println(ssb_Reply_Num);
		System.out.println("skillSharingBoardReplyVo1" + skillSharingBoardReplyVo1);
		String writeEmail = skillSharingBoardReplyVo1.getSsb_Reply_Mem();

		if (loginEmail.equals(writeEmail)) {
			skillSharingBoardReplyService.deleteSkillSharingBoardReply(ssb_Reply_Num);
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + skillSharingBoardReplyVo.getSsb_Article_Num()
					+ "&delete=yes&message=1";
		} else {
			url = "redirect:SkillSharingDetail?ssb_Article_Num=" + skillSharingBoardReplyVo.getSsb_Article_Num()
					+ "&delete=no&message=1";
		}
		return url;
	}

}
