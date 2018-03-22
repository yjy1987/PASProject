package com.app.pas.controller.totalboard;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.app.pas.dto.board.FreeBoardLikeVo;
import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.service.board.FreeBoardReplyService;
import com.app.pas.service.board.FreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;
	@Autowired
	FreeBoardReplyService freeBoardReplyService;

	// 내가쓴글 보기
	@RequestMapping("/frb_myPost")
	public String frb_myPost(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
			HttpServletRequest request, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String title_Content,
			@RequestParam(defaultValue = "") String tag, FreeBoardVo freeboardVo, HttpSession session)
			throws SQLException {

		String url = "freeBoard/freeBoardList";
		String delete = request.getParameter("delete");
		int totalCount = 0;

		List<FreeBoardVo> freeBoardList = new ArrayList<FreeBoardVo>();
		// 로그인정보 가져오기
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		freeboardVo.setMem_Email(mem_Email);

		if (page.equals(null) || page == "") {
			totalCount = freeBoardService.frb_myPostCount(freeboardVo);
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}

			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);
			model.addAttribute("paging", paging);
		} else {
			if (keyField == ("name") || keyField.equals("name")) {

				freeboardVo.setMem_Name(keyword);
				System.out.println("--------------name 키워드 : " + keyword);

			} else if (keyField == ("title") || keyField.equals("title")) {
				freeboardVo.setFrb_Title(keyword);
				System.out.println("-----------------title 키워드 : " + keyword);

			} else if (keyField == ("number") || keyField.equals("number")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Article_Num(Integer.parseInt(keyword));
				System.out.println("-----------------number 키워드 : " + keyword);

			} else if (keyField == ("content") || keyField.equals("content")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Content(keyword);
				System.out.println("-----------------content 키워드 : " + keyword);

			} else if (keyField == ("title_Content") || keyField.equals("title_Content")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_title_Content(keyword);

			} else if (keyField == ("tag") || keyField.equals("tag")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Tag(keyword);
			}
			//
			// freeBoardList = freeBoardService.frb_myPost(freeboardVo);
			// model.addAttribute("freeBoardList", freeBoardList);
			//
			totalCount = freeBoardService.frb_myPostCount(freeboardVo);
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);

		}
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}
		freeBoardList = freeBoardService.frb_myPost(freeboardVo);
		model.addAttribute("freeBoardList", freeBoardList);

		totalCount = freeBoardService.frb_myPostCount(freeboardVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);
		model.addAttribute("delete", delete);
		return url;
	}

	// 자유게시판 전체 리스트
	@RequestMapping("/freeBoardList")
	public String CommunityList(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
			HttpServletRequest request, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyField, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String number,
			@RequestParam(defaultValue = "") String content, @RequestParam(defaultValue = "") String title_Content,
			@RequestParam(defaultValue = "") String tag, FreeBoardVo freeboardVo) throws SQLException {
		System.out.println("*#%&*#(&%*(@#%&*(@#%&*(23: " + page);
		String url = "freeBoard/freeBoardList";
		String delete = request.getParameter("delete");
		String modify = request.getParameter("modify");
		int totalCount = 0;

		List<FreeBoardVo> freeBoardList = new ArrayList<FreeBoardVo>();

		if (page.equals(null) || page == "") {
			totalCount = freeBoardService.selectTotalCount();
			if (page.equals(null) || page == "") {
				page = "" + 1;
			}

			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);
			model.addAttribute("paging", paging);
		} else {
			if (keyField == ("name") || keyField.equals("name")) {

				freeboardVo.setMem_Name(keyword);
				System.out.println("--------------name 키워드 : " + keyword);

			} else if (keyField == ("title") || keyField.equals("title")) {
				freeboardVo.setFrb_Title(keyword);
				System.out.println("-----------------title 키워드 : " + keyword);

			} else if (keyField == ("number") || keyField.equals("number")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Article_Num(Integer.parseInt(keyword));
				System.out.println("-----------------number 키워드 : " + keyword);

			} else if (keyField == ("content") || keyField.equals("content")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Content(keyword);
				System.out.println("-----------------content 키워드 : " + keyword);

			} else if (keyField == ("title_Content") || keyField.equals("title_Content")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_title_Content(keyword);
			} else if (keyField == ("tag") || keyField.equals("tag")) {
				if (!(keyword.isEmpty() || keyword == null))
					freeboardVo.setFrb_Tag(keyword);
			}

			freeBoardList = freeBoardService.selectFreeBoardList(freeboardVo);
			model.addAttribute("freeBoardList", freeBoardList);

			totalCount = freeBoardService.freeBoardSearchCount(freeboardVo);
			Paging paging = new Paging();
			paging.setPageNo(Integer.parseInt(page));
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);

			model.addAttribute("paging", paging);

		}
		if (page.equals(null) || page == "") {
			page = "" + 1;
		}

		totalCount = freeBoardService.freeBoardSearchCount(freeboardVo);
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(page));
		paging.setPageSize(5);
		paging.setTotalCount(totalCount);

		model.addAttribute("paging", paging);
		model.addAttribute("delete", delete);
		model.addAttribute("modify", modify);

		System.out.println(paging.toString());
		return url;
	}

	@RequestMapping("/freeBoardDetail")
	public String detailFreeBoard(@RequestParam String frb_Article_Num, HttpServletRequest request, Model model)
			throws NumberFormatException, SQLException {
		String url = "freeBoard/freeBoardDetail";
		FreeBoardVo freeBoardVo = null;
		String like = request.getParameter("like");
		String message = request.getParameter("message");
		String delete = request.getParameter("delete");
		String modify = request.getParameter("modify");
		freeBoardVo = freeBoardService.selectFreeBoardDetail(Integer.parseInt(frb_Article_Num));
		if (message == null) {
			freeBoardService.updateFreeBoardCount(freeBoardVo);
		}
		model.addAttribute("delete", delete);
		model.addAttribute("like", like);
		model.addAttribute("freeBoardVo", freeBoardVo);
		model.addAttribute("modify", modify);
		return url;
	}

	@RequestMapping("/FreeBoardLike")
	public String detailskillSharingBoardLike(@RequestParam String frb_Article_Num, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, FreeBoardVo freeBoardVo)
			throws SQLException, IOException {

		FreeBoardLikeVo freeBoardLikeVo = new FreeBoardLikeVo();
		FreeBoardLikeVo LikeMember = new FreeBoardLikeVo();
		String url = "redirect:freeBoardDetail?frb_Article_Num=" + frb_Article_Num;
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		freeBoardVo.setFrb_Article_Num(Integer.parseInt(frb_Article_Num));
		freeBoardLikeVo.setFrb_Article_Num(Integer.parseInt(frb_Article_Num));
		freeBoardLikeVo.setMem_Email(memberVo.getMem_Email());

		LikeMember = freeBoardService.selectFreeBoardLikeList(freeBoardLikeVo);

		if (LikeMember == null) {
			freeBoardService.insertFreeboardLike(freeBoardLikeVo);
			url = "redirect:freeBoardDetail?frb_Article_Num=" + frb_Article_Num + "&like=yes&message=1";
		} else {
			url = "redirect:freeBoardDetail?frb_Article_Num=" + frb_Article_Num + "&like=no&message=1";
		}
		return url;
	}

	@RequestMapping(value = "/freeBoardInsert")
	public String insertFreeBoardForm(HttpSession session, Model model) {
		String url = "freeBoard/freeBoardWrite";
		return url;

	}

	@RequestMapping(value = "/freeBoardInsert", method = RequestMethod.POST)
	public String insertFreeBoard(HttpSession session, FreeBoardVo freeBoardVo) throws SQLException {
		String url = "redirect:freeBoardList";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		String mem_Name = memberVo.getMem_Name();
		if (freeBoardVo.getFrb_Tag() == "") {
			freeBoardVo.setFrb_Tag("#");
		}
		freeBoardVo.setMem_Email(mem_Email);
		freeBoardVo.setMem_Name(mem_Name);
		freeBoardVo.setFrb_Kind("1");

		freeBoardService.insertFreeBoard(freeBoardVo);

		return url;
	}

	@RequestMapping(value = "/freeBoardUpdate", method = RequestMethod.GET)
	public String updateFreeBoardForm(String frb_Article_Num, Model model, HttpSession session)
			throws NumberFormatException, SQLException {

		String url = "freeBoard/freeBoardUpdate";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String loginEmail = memberVo.getMem_Email();
		FreeBoardVo freeboardVo = freeBoardService.selectFreeBoardDetail(Integer.parseInt(frb_Article_Num));
		String writeEmail = freeboardVo.getMem_Email();
		if (loginEmail.equals(writeEmail)) {
			url = "freeBoard/freeBoardUpdate";
			model.addAttribute("freeBoardVo", freeboardVo);
		} else {
			url = "redirect:freeBoardDetail?frb_Article_Num=" + frb_Article_Num + "&modify=no&message=1";
		}

		return url;
	}

	@RequestMapping(value = "/freeBoardUpdate", method = RequestMethod.POST)
	public String updateFreeBoard(FreeBoardVo freeBoardVo) throws NumberFormatException, SQLException {

		String url = "redirect:freeBoardList?modify=yes";

		freeBoardVo.setFrb_Kind("1");
		if (freeBoardVo.getFrb_Tag() == null || freeBoardVo.getFrb_Tag() == "") {
			freeBoardVo.setFrb_Tag("#");
		}
		freeBoardService.updateFreeBoard(freeBoardVo);

		return url;
	}

	@RequestMapping(value = "/freeBoardWrite", method = RequestMethod.GET)
	public String writeFreeBoard(HttpSession session, Model model) {
		String url = "freeBoard/freeBoardWrite";
		return url;

	}

	@RequestMapping(value = "/freeBoardDelete", method = RequestMethod.POST)
	public String deleteFreeBoard(String frb_Article_Num, HttpSession session)
			throws NumberFormatException, SQLException {
		String url = "redirect:freeBoardList";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@dasdasdasdasdasda@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String loginEmail = memberVo.getMem_Email();
		FreeBoardVo freeboardVo = freeBoardService.selectFreeBoardDetail(Integer.parseInt(frb_Article_Num));
		String writeEmail = freeboardVo.getMem_Email();

		if (loginEmail.equals(writeEmail)) {
			freeBoardService.deleteFreeBoard(Integer.parseInt(frb_Article_Num));
			url = "redirect:freeBoardList?delete=yes";
		} else {
			url = "redirect:freeBoardDetail?frb_Article_Num=" + frb_Article_Num + "&delete=no&message=1";
		}
		return url;
	}

	@RequestMapping(value = "/freeBoardReplyList")
	public @ResponseBody List<FreeBoardReplyVo> selectFreeBoardReplyList(
			@RequestParam(value = "page", defaultValue = "1") String page, @RequestBody Map<String, Object> jsonMap,
			Model model) throws SQLException {
		int totalCount = 0;
		List<FreeBoardReplyVo> freeBoardReplyList = new ArrayList<FreeBoardReplyVo>();
		String frb_Article_Num = (String) jsonMap.get("frb_Article_Num");
		System.out.println(frb_Article_Num);
		try {
			freeBoardReplyList = freeBoardReplyService.selectFreeBoardReply(Integer.parseInt(frb_Article_Num));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("freeBoardReplyList", freeBoardReplyList);
		return freeBoardReplyList;
	}

	@RequestMapping(value = "freeBoardReplyWrite", method = RequestMethod.POST)
	public @ResponseBody List<FreeBoardReplyVo> writeFreeBoardReply(@RequestBody FreeBoardReplyVo freeBoardReplyVo,
			HttpSession session) {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		freeBoardReplyVo.setFrb_Reply_Mem(mem_Email);
		freeBoardReplyVo.setFrb_Reply_Mem_Name(memberVo.getMem_Name());
		List<FreeBoardReplyVo> freeBoardReplyList = new ArrayList<FreeBoardReplyVo>();
		try {
			freeBoardReplyService.insertFreeBoardReply(freeBoardReplyVo);
			freeBoardReplyList = freeBoardReplyService.selectFreeBoardReply(freeBoardReplyVo.getFrb_Article_Num());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardReplyList;
	}

	@RequestMapping(value = "freeBoardReplyUpdate", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String updateFreeBoardReply(int frb_Reply_Num, String content, FreeBoardReplyVo freeBoardReplyVo,
			HttpSession session, HttpServletRequest request) throws SQLException {
		String url = "redirect:freeBoardDetail";

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@" + content + "@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@" + frb_Reply_Num + "@@@@@@@@@@@@@@@@@@@@@@@@@");
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		FreeBoardReplyVo freeBoardReplyVo1 = freeBoardReplyService.selectFRBR(frb_Reply_Num);
		String loginEmail = memberVo.getMem_Email();
		System.out.println(frb_Reply_Num);
		System.out.println("freeBoardReplyVo1" + freeBoardReplyVo1);
		String writeEmail = freeBoardReplyVo1.getFrb_Reply_Mem();

		if (loginEmail.equals(writeEmail)) {
			freeBoardReplyVo1.setFrb_Reply_Content(content);
			freeBoardReplyService.updateFreeBoardReply(freeBoardReplyVo1);
			url = "redirect:freeBoardDetail?frb_Article_Num=" + freeBoardReplyVo.getFrb_Article_Num()
					+ "&modify=yes&message=1";
		} else {
			url = "redirect:freeBoardDetail?frb_Article_Num=" + freeBoardReplyVo.getFrb_Article_Num()
					+ "&modify=no&message=1";
		}
		return url;

	}

	@RequestMapping(value = "freeBoardReplyDelete", method = RequestMethod.POST)
	public String deleteFreeBoardReply(int frb_Reply_Num, FreeBoardReplyVo freeBoardReplyVo, HttpSession session)
			throws SQLException {

		String url = "redirect:freeBoardDetail";
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		FreeBoardReplyVo freeBoardReplyVo1 = freeBoardReplyService.selectFRBR(frb_Reply_Num);
		String loginEmail = memberVo.getMem_Email();
		System.out.println(frb_Reply_Num);
		System.out.println("freeBoardReplyVo1" + freeBoardReplyVo1);
		String writeEmail = freeBoardReplyVo1.getFrb_Reply_Mem();

		if (loginEmail.equals(writeEmail)) {
			freeBoardReplyService.deleteFreeBoradReply(frb_Reply_Num);
			url = "redirect:freeBoardDetail?frb_Article_Num=" + freeBoardReplyVo.getFrb_Article_Num()
					+ "&delete=yes&message=1";
		} else {
			url = "redirect:freeBoardDetail?frb_Article_Num=" + freeBoardReplyVo.getFrb_Article_Num()
					+ "&delete=no&message=1";
		}
		return url;
	}

}
