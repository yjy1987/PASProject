package com.app.pas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pas.dao.board.SkillSharingBoardDao;
import com.app.pas.dto.MemberVo;
import com.app.pas.dto.MyPostBoardVo;
import com.app.pas.dto.board.FreeBoardReplyVo;
import com.app.pas.dto.board.FreeBoardVo;
import com.app.pas.dto.board.QnaBoardReplyVo;
import com.app.pas.dto.board.QnaBoardVo;
import com.app.pas.dto.board.SkillSharingBoardReplyVo;
import com.app.pas.dto.board.SkillSharingBoardVo;
import com.app.pas.service.MainService;
import com.app.pas.service.board.FreeBoardReplyService;
import com.app.pas.service.board.FreeBoardService;
import com.app.pas.service.board.QnaBoardReplyService;
import com.app.pas.service.board.QnaBoardService;
import com.app.pas.service.board.SkillSharingBoardReplyService;
import com.app.pas.service.board.SkillSharingBoardService;

@Controller
@RequestMapping("/main")
public class MyPostController {
	HttpServletRequest request;
	@Autowired
	MainService mainService;
	
	@Autowired
	QnaBoardService qnaBoardService; 
	
	@Autowired
	QnaBoardReplyService qnaBoardReplyService;
	
	@Autowired
	SkillSharingBoardReplyService skillSharingBoardReplyService;
	
	@Autowired
	FreeBoardReplyService freeBoardReplyService;
	
	@Autowired
	SkillSharingBoardService skillSharingBoardService;
	
	@Autowired
	FreeBoardService freeBoardService;
	
	//내가 쓴 글 보기 리스트
		@RequestMapping(value ="/myPostBoard")
		public String myPostBoard(HttpSession session, Model model,
				FreeBoardVo freeBoardVo,
				MyPostBoardVo myPostBoardVo,String page) throws SQLException {
			String url = "main/myPostBoard";
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
			
			List<MyPostBoardVo> myPostBoardList = new ArrayList<MyPostBoardVo>();
			
			MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
			String mem_Email = memberVo.getMem_Email();
			String sessionMem_Name = memberVo.getMem_Name();
			model.addAttribute("sessionMem_Name", sessionMem_Name);
		
			myPostBoardVo.setMail(mem_Email);

			myPostBoardList = mainService.MyPostBoard(myPostBoardVo);
		
			model.addAttribute("myPostBoardList", myPostBoardList);
		
		return url;
		}
//기술공유----------------------------------------------------------------------------------------------------
		//dtail
		@RequestMapping(value = "/myPostDetail_skill")
		public String myPostBoard_Skill(HttpSession session, Model model,
				MyPostBoardVo myPostBoardVo,SkillSharingBoardVo skillSharingBoardVo,
				SkillSharingBoardReplyVo skillSharingBoardReplyVo) throws SQLException {
		
			int skillDetailNum = myPostBoardVo.getNum();
			skillSharingBoardVo.setSsb_Article_Num(skillDetailNum);
			
			skillSharingBoardVo = (SkillSharingBoardVo)mainService.myPostBoard_Skill(skillSharingBoardVo);
			model.addAttribute("skillSharingBoardVo", skillSharingBoardVo);
			
			//답글보여주기
			List<SkillSharingBoardReplyVo> ssb_replyList = new ArrayList<SkillSharingBoardReplyVo>();
			ssb_replyList = skillSharingBoardReplyService.selectSkillSharingBoardReply(skillDetailNum);
			model.addAttribute("ssb_replyList",ssb_replyList);
		
			String url = "/main/myPostDetail_skill";
		
			return url;
		}
		//기술공유 삭제
		@RequestMapping(value = "/myPostDelete_skill")
		public String deleteSkillSharingBoard(MyPostBoardVo myPostBoardVo,SkillSharingBoardVo skillSharingBoardVo,
				String num) throws SQLException {
				skillSharingBoardService.deleteSkillSharingBoard(Integer.parseInt(num));
				String url = "redirect:myPostBoard";
			return url;
		
		}
	
		//기술공유 수정폼
				@RequestMapping(value = "/myPostUpdateForm_Skill")
				public String myPostUpdateForm_Skill(HttpSession session, Model model,
						MyPostBoardVo myPostBoardVo,SkillSharingBoardVo skillSharingBoardVo,
						SkillSharingBoardReplyVo skillSharingBoardReplyVo) throws SQLException {
				
					int skillDetailNum = myPostBoardVo.getNum();
					skillSharingBoardVo.setSsb_Article_Num(skillDetailNum);
					
					skillSharingBoardVo = (SkillSharingBoardVo)mainService.myPostBoard_Skill(skillSharingBoardVo);
					model.addAttribute("skillSharingBoardVo", skillSharingBoardVo);
					model.addAttribute("myPostBoardVo", myPostBoardVo);
		
					String url = "/main/myPostUpdate_skill";			
					return url;
			
				}
//기술공유 수정  
//				@RequestMapping(value ="/myPostUpdate_frb")
//				   public String myPostUpdate_Skill(String frb_Article_Num,MyPostBoardVo myPostBoardVo,
//						  SkillSharingBoardVo skillSharingBoardVo,String num
//							) throws NumberFormatException, SQLException{
//					
//				
//					skillSharingBoardVo.setSsb_Article_Num(Integer.parseInt(num));
//				   
//						String url = "/main/myPostDetail_frb";
//						mainService.myPostUpdate_skill(skillSharingBoardVo);
//
//			      return url;
//				   }
//				   
// QnA ----------------------------------------------------------------------------------------------------		
		//디테일
		@RequestMapping(value = "/myPostDetail_qna")
		public String myPostDetail_qna(HttpSession session, Model model,QnaBoardVo qnaBoardVo,
				MyPostBoardVo myPostBoardVo,QnaBoardReplyVo qnaBoardReplyVo) throws SQLException {
		
			int qnaDetailNum = myPostBoardVo.getNum();
			qnaBoardVo.setQb_Article_Num(qnaDetailNum);
			
			qnaBoardVo = (QnaBoardVo)mainService.myPostBoard_Qna(qnaBoardVo);
			model.addAttribute("qnaBoardVo", qnaBoardVo);

			//답글보여주기
			qnaBoardReplyVo = qnaBoardReplyService.selectQnaReply(qnaDetailNum);
			model.addAttribute("qnaBoardReplyVo",qnaBoardReplyVo);
			
			String url = "/main/myPostDetail_qna";

			return url;
		}
		
		//삭제
		@RequestMapping(value = "/myPostDelete_qna")
		public String myPostDelete_qna(String num) throws SQLException {
			String url = "redirect:myPostBoard";
			qnaBoardService.deleteQnaBoard(Integer.parseInt(num));
			return url;
		}
		
		
//freeboard(커뮤니티)-----------------------------------------------------------------------------------------------		
		
		//디테일
		@RequestMapping(value = "/myPostDetail_frb")
		public String myPostBoard_frb(HttpSession session, Model model,MyPostBoardVo myPostBoardVo,
				FreeBoardVo freeBoardVo, FreeBoardReplyVo freeBoardReplyVo) throws SQLException {
			String url = "/main/myPostDetail_frb";
			
			int freeDetailNum = myPostBoardVo.getNum();
			freeBoardVo.setFrb_Article_Num(freeDetailNum);
			
			freeBoardVo = (FreeBoardVo) mainService.myPostBoard_frb(freeBoardVo);
			model.addAttribute("freeBoardVo", freeBoardVo);
			model.addAttribute("myPostBoardVo", myPostBoardVo);
	
			//리플
			freeBoardReplyVo.setFrb_Article_Num(freeDetailNum);
			List<FreeBoardReplyVo> frb_replylist  = new ArrayList<FreeBoardReplyVo>();
			frb_replylist = freeBoardReplyService.selectFreeBoardReply(freeDetailNum);
			model.addAttribute("frb_replylist", frb_replylist);
			
			System.out.println("#######" + frb_replylist.size());

			return url;
		}
		
		//freeBoard 수정폼
		   @RequestMapping(value ="/myPostUpdateForm_frb")
		   public String myPostUpdate_frbForm(String frb_Article_Num, Model model,MyPostBoardVo myPostBoardVo,HttpSession session
				   ,FreeBoardVo freeBoardVo) throws NumberFormatException, SQLException{
				
				int freeDetailNum = myPostBoardVo.getNum();
				freeBoardVo.setFrb_Article_Num(freeDetailNum);
				freeBoardVo = (FreeBoardVo) mainService.myPostBoard_frb(freeBoardVo);
				model.addAttribute("freeBoardVo", freeBoardVo);
				model.addAttribute("myPostBoardVo", myPostBoardVo);
		      String url="main/myPostUpdate_frb";
		
		      return url;
		   }
		   
		   //freeBoard수정
		   @RequestMapping(value ="/myPostUpdate_frb")
		   public String myPostUpdate_frb(String frb_Article_Num,MyPostBoardVo myPostBoardVo,HttpSession session
				   ,FreeBoardVo freeBoardVo,String num) throws NumberFormatException, SQLException{
			   freeBoardVo.setFrb_Article_Num(Integer.parseInt(num));
		   
				String url = "/main/myPostDetail_frb";
				mainService.myPostUpdate_frb(freeBoardVo);

	      return url;
		   }
		   
		   //freeBoard삭제
		   @RequestMapping (value="/myPostDelete_frb")
		   public String deleteFreeBoard (String num,FreeBoardVo freeBoardVo,
				   MemberVo memberVo,MyPostBoardVo myPostBoardVo,String mem_Email) throws SQLException{
			   int freeDetailNum = myPostBoardVo.getNum();			
				String url = "redirect:myPostBoard";
				freeBoardService.deleteFreeBoard(freeDetailNum);
			   
			   return url;
		   }
		   
		   
		   
	

}
