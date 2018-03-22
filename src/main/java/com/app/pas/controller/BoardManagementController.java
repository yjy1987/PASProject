package com.app.pas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pas.commons.Paging;
import com.app.pas.dto.BoardJoinVo;
import com.app.pas.dto.BoardManagementVo;
import com.app.pas.dto.BoardTotalVo;
import com.app.pas.dto.MemPositionViewVo;
import com.app.pas.dto.MemberVo;
import com.app.pas.service.BoardJoinService;
import com.app.pas.service.BoardManagementService;
import com.app.pas.service.BoardTotalService;
import com.app.pas.service.MemberService;



@Controller
@RequestMapping("/project")
public class BoardManagementController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardManagementService boardManagementService;
	@Autowired
	BoardJoinService boardJoinService;
	@Autowired
	BoardTotalService boardTotalService;
	
	@RequestMapping("pmBoardManagementList")
	public String boardManagementList(HttpSession session,Model model) throws SQLException{
		String url = "project/pmBoardManagement";
		int proj_Num = Integer.parseInt((String) session.getAttribute("joinProj"));
		MemPositionViewVo memPositionView = new MemPositionViewVo();
		memPositionView.setPjj_Per_Num(1);
		memPositionView.setProj_Num(proj_Num);
		List<MemPositionViewVo> memberList = memberService.selectMemberListByProj(memPositionView);
		model.addAttribute("memberList",memberList);
		return url;
	}
	
	@RequestMapping(value= "insertBoard",method = RequestMethod.POST)
	public @ResponseBody boolean insertBoard(HttpSession session,@RequestBody BoardManagementVo boardManagementVo) throws SQLException{
		int proj_Num = Integer.parseInt((String) session.getAttribute("joinProj"));
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		boardManagementVo.setBm_Mem_Name(member.getMem_Name());
		boardManagementVo.setBm_Mem_Email(member.getMem_Email());
		boardManagementVo.setBm_Proj_Num(proj_Num);
		System.out.println(boardManagementVo+"@@@@@@@@@@@@@@@@");
		boolean flag =boardManagementService.insertBoardManagement(boardManagementVo);
		return flag;
	}
	
	@RequestMapping(value="insertBoardJoin",method = RequestMethod.POST)
	public @ResponseBody boolean insertBoardJoin(@RequestBody BoardJoinVo boardJoinVo,HttpSession session) throws SQLException{
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		BoardManagementVo vo = boardManagementService.selectLastColumn(member.getMem_Email());
		boardJoinVo.setBm_Num(vo.getBm_Num());
		boardJoinService.insertBoardJoinDao(boardJoinVo);
		return true;
	}
	
	@RequestMapping(value="boardManagementList",method = RequestMethod.POST)
	public @ResponseBody List<BoardManagementVo> boardManagementList(HttpSession session) throws SQLException{
		int proj_Num = Integer.parseInt((String) session.getAttribute("joinProj"));
		List<BoardManagementVo> list = boardManagementService.selectBoardList(proj_Num);
		for(BoardManagementVo x : list){
			int result = boardManagementService.selectBoardCount(x.getBm_Num());
			x.setBm_TotalCount(result);
		}
		return list;
	}
	
	@RequestMapping(value="boardJoinList" ,method = RequestMethod.POST)
	public @ResponseBody List<BoardJoinVo> boardJoinList(HttpSession session,@RequestBody BoardJoinVo boardJoinVo) throws SQLException{
		List<BoardJoinVo> list = boardJoinService.selectBoardJoinList(boardJoinVo.getBm_Num());
		return list;
	}
	
	@RequestMapping(value="deleteBoard",method = RequestMethod.GET)
	public String deleteBoard(@RequestParam String bm_Num) throws SQLException{
		String url="redirect:pmBoardManagementList";
		boardManagementService.deleteBoardManagement(Integer.parseInt(bm_Num));
		return url;
	}


	@RequestMapping(value="updateBoardJoin", method = RequestMethod.POST)
	public @ResponseBody boolean updateBoardJoin(@RequestBody BoardJoinVo boardJoinVo )throws SQLException{
		boolean flag = true;
		boardJoinService.updateBoardJoin(boardJoinVo);
		return flag;
	}
	
	@RequestMapping(value = "pmBoardTotalList",method = RequestMethod.GET)
	public String bmBoardList(BoardJoinVo boardJoinVo,HttpSession session,HttpServletRequest request,
			Model model,@RequestParam(value="page",defaultValue="1")String page,PrintWriter writer) throws SQLException, IOException{
		String url = "project/pmBoardTotalList";
		BoardJoinVo resultVo = new BoardJoinVo();
		int totalCount = 0 ;
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String mem_Email = memberVo.getMem_Email();
		boardJoinVo.setBj_Mem_Email(mem_Email);
		
		resultVo = boardJoinService.selectBoardJoinByEmailBmNum(boardJoinVo);
		
		String refererUrl = request.getHeader("referer");
		if(resultVo==null){
			url ="redirect:"+refererUrl;
			return url;
		}else if(resultVo.getBj_Read().equals("n")){
			url ="redirect:"+refererUrl;
			return url;
		}
		totalCount = boardTotalService.totalCountBoardTotalList(boardJoinVo.getBm_Num());
		Paging paging = new Paging();
	      paging.setPageNo(Integer.parseInt(page));
	      paging.setPageSize(5);
	      paging.setTotalCount(totalCount);
	      model.addAttribute("paging",paging);
		List<BoardTotalVo> boardTotalList = boardTotalService.selectBoardTotalList(resultVo.getBm_Num());
		model.addAttribute("boardTotalList",boardTotalList);
		BoardManagementVo boardManagementVo = boardManagementService.selectBoardByBmNum(resultVo.getBm_Num());
		model.addAttribute("boardTotalName",boardManagementVo.getBm_Title());
		model.addAttribute("boardTotalNum",boardManagementVo.getBm_Num());
		return url;
	}
	
	@RequestMapping(value = "pmBoardTotalWrite",method = RequestMethod.POST)
	public String pmBoardTotalWriteForm(@RequestParam String totalBoad_bm_Num,Model model,@RequestParam String boardTotalName){
		String url = "project/pmBoardTotalWrite";
		model.addAttribute("bm_Num", totalBoad_bm_Num);
		model.addAttribute("bm_Title",boardTotalName);
		return url;
	}
	
	@RequestMapping(value= "pmBoardTotalInsert" , method = RequestMethod.POST)
	public String pmBoardTotalInsert(BoardTotalVo boardTotalVo,HttpSession session) throws SQLException{
		String url = "redirect:pmBoardTotalList?bm_Num="+boardTotalVo.getBm_Num();
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		boardTotalVo.setBt_Mem_Email(memberVo.getMem_Email());
		boardTotalVo.setBt_Mem_Name(memberVo.getMem_Name());
		boardTotalService.insertBoardTotal(boardTotalVo);
		return url;
	}

	@RequestMapping("pmBoardTotalDetail")
	public String pmBoardTotalDetail(BoardTotalVo boarTotalVo,Model model) throws SQLException {
		String url = "project/pmBoardTotalDetail";
		model.addAttribute("bt_Num",boarTotalVo.getBt_Num());
		BoardTotalVo resultVo = boardTotalService.selectBoardTotalByBtNum(boarTotalVo.getBt_Num());
		model.addAttribute("boardTotalVo",resultVo);
		return url;
	}
	
	@RequestMapping(value="checkBoardJoin",method = RequestMethod.POST)
	public @ResponseBody boolean checkBoardJoin(@RequestBody BoardJoinVo boardJoinVo,HttpSession session) throws SQLException{
		boolean flag = false;
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		boardJoinVo.setBj_Mem_Email(memberVo.getMem_Email());
		BoardJoinVo resultVo = boardJoinService.selectBoardJoinByEmailBmNum(boardJoinVo);
		if(resultVo.getBj_Write().equals("y")){
			flag = true;
		}
		return flag;
	}
	@RequestMapping(value="pmBoardTotalUpdate",method = RequestMethod.GET)
	public String pmBoardTotalUpdate(BoardTotalVo boardTotalVo,Model model)throws SQLException{
		String url = "project/pmBoardTotalUpdate";
		BoardTotalVo resultVo = boardTotalService.selectBoardTotalByBtNum(boardTotalVo.getBt_Num());
		model.addAttribute("boardTotalVo",resultVo);
		return url;
	}
	@RequestMapping(value="pmBoardTotalUpdate", method = RequestMethod.POST)
	public String pmBoardTotalUpdate(BoardTotalVo boardTotalVo)throws SQLException{
		String url="redirect:pmBoardTotalDetail?bt_Num="+boardTotalVo.getBt_Num();
		boardTotalService.updateBoardTotal(boardTotalVo);
		return url;
	}
	
	@RequestMapping("pmBoardTotalDelte")
	public String pmBoardTotalDelte(@RequestParam String bt_Num) throws SQLException{
		BoardTotalVo resultVo = boardTotalService.selectBoardTotalByBtNum(Integer.parseInt(bt_Num));
		String url = "redirect:pmBoardTotalList?bm_Num="+resultVo.getBm_Num();
		boardTotalService.deleteBoardTotal(Integer.parseInt(bt_Num));
		return url;
	}
	
	@RequestMapping(value="selectBoardManagementMember",method = RequestMethod.POST)
	public @ResponseBody List<MemberVo> selectBoardManagementMember(@RequestBody BoardJoinVo boardJoinVo, HttpSession session)throws SQLException{
		System.out.println(boardJoinVo);
		List<MemberVo> list = boardJoinService.selectBoardJoinNotInMemberList(boardJoinVo);
		return list;
	}
	
	@RequestMapping(value="boardJoinInsert", method = RequestMethod.POST)
	public @ResponseBody boolean boardJoinInsert(@RequestBody BoardJoinVo boardJoinVo ) throws SQLException{
		boardJoinService.insertBoardJoinDao(boardJoinVo);
		return true;
	}
}
