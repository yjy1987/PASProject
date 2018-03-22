package com.app.pas.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pas.dto.MemberVo;
import com.app.pas.dto.dic.DocumentVo;
import com.app.pas.dto.dic.SpreadSheetVo;
import com.app.pas.dto.dic.WordSheetVo;
import com.app.pas.service.MemberService;
import com.app.pas.service.ProjectService;
import com.app.pas.service.dic.DocumentService;
import com.app.pas.service.dic.SpreadSheetService;
import com.app.pas.service.dic.WordSheetService;

@Controller
@RequestMapping("/project/work")
public class WorkController {
	HttpServletRequest request;

	@Autowired
	MemberService memberService;

	@Autowired
	ProjectService projectService;

	@Autowired
	SpreadSheetService spreadSheetService;
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	WordSheetService wordSheetService;
	
	@RequestMapping(value = "/workList", method = RequestMethod.GET)
	public String workList(HttpSession session, Model model) throws NumberFormatException, SQLException {
		String url = "/work/workList";
		String proj_Num = (String) session.getAttribute("joinProj");
		List<DocumentVo> documentList = documentService.selectDocumentListByProjNum(Integer.parseInt(proj_Num));
		model.addAttribute("documentList", documentList);
		return url;
	}
	
	@RequestMapping(value="createWorkForm")
	public String createWorkForm(HttpSession session){
		String url = "";
		url = "/work/createWorkForm";
		return url;
	}
	
	@RequestMapping(value="spreadSheetForm",method = RequestMethod.GET)
	public String createSheet(HttpSession session) throws SQLException{
		String url = "/work/spreadSheetForm";
		return url;
	}
	
	
	@RequestMapping(value="createSpreadSheet",method=RequestMethod.POST)
	public @ResponseBody boolean createSpreadSheet(@RequestBody String sp_Content,HttpSession session) throws SQLException{
		
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String proj_Num = (String) session.getAttribute("joinProj");
		DocumentVo documentVo = new DocumentVo();
		documentVo.setDoc_Kind(1);
		documentVo.setDoc_Name("SpreadSheet");
		documentVo.setDoc_File_Name("SpreadSheet");
		documentVo.setMem_Email(memberVo.getMem_Email());
		documentVo.setMem_Name(memberVo.getMem_Name());
		documentVo.setProj_Num(Integer.parseInt(proj_Num));
		documentVo.setDoc_Img("excel.png");
		SpreadSheetVo spreadSheetVo = new SpreadSheetVo();
		spreadSheetVo.setSp_Content(sp_Content);
		boolean flag = documentService.insertDictionarySpreadSeet(documentVo,spreadSheetVo);
		return flag;
		
	}
	
	@RequestMapping("deleteDocument")
	public String deleteDocument(DocumentVo documentVo)throws SQLException{
		String url ="redirect:workList";
		boolean flag = documentService.deleteDocumentByDocNum(documentVo);
		if(!flag){
			url = "";
		}
		return url;
	}
	
	@RequestMapping("selectDocument")
	public String selectDocument(DocumentVo documentVo,Model model,HttpSession session) throws SQLException{
		
		String url = "";
		DocumentVo selectVo = documentService.selectDocumentByDocNum(documentVo.getDoc_Num());
		if(selectVo ==null){ return "redirect:workList"; }
			
		if(selectVo.getDoc_Kind()==1){
			SpreadSheetVo spreadSheetVo = spreadSheetService.selectSpreadSheetByDocNum(documentVo.getDoc_Num());
			model.addAttribute("spreadSheetVo", spreadSheetVo);
			
			url = "/work/viewSpreadSheet";
		}else if(selectVo.getDoc_Kind()==2){
			WordSheetVo wordSheetVo = wordSheetService.selectWordSheetByDocNum(documentVo.getDoc_Num());
			wordSheetVo.setWd_Content(((wordSheetVo.getWd_Content().trim()).replace("\n", " ")).replace("\"", "\'"));
			model.addAttribute("wordSheetVo", wordSheetVo);
			url = "/work/viewWordSheet";
		}
		
		session.setAttribute("joinDocNum", documentVo.getDoc_Num());
		return url;
	}
	
	
	
	@RequestMapping(value="downloadFile",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> downloadFile(@RequestBody DocumentVo documentVo) throws SQLException{
		DocumentVo selectVo = documentService.selectDocumentByDocNum(documentVo.getDoc_Num());
		
		Map<String,Object> downloadFileMap = new HashMap<String, Object>();
		
		if(selectVo.getDoc_Kind()==1){
			SpreadSheetVo spreadSheetVo = spreadSheetService.selectSpreadSheetByDocNum(documentVo.getDoc_Num());
			downloadFileMap.put("data", spreadSheetVo.getSp_Content());
		}
		
		
		return downloadFileMap;
	}
	
	@RequestMapping(value="initContent",method = RequestMethod.POST)
	public @ResponseBody SpreadSheetVo initContent(@RequestBody DocumentVo documentVo) throws SQLException{
		SpreadSheetVo spreadSheetVo = spreadSheetService.selectSpreadSheetByDocNum(documentVo.getDoc_Num());
		return spreadSheetVo;
	}
	
	
	@RequestMapping(value="saveFile",method = RequestMethod.POST)
	public @ResponseBody boolean saveFile(@RequestBody Map<String,Object> map ) throws SQLException{
		String sp_Content = (String) map.get("sheet");
		String doc_Num = (String) map.get("doc_Num");
		SpreadSheetVo spreadSheetVo = new SpreadSheetVo();
		spreadSheetVo.setDoc_Num(Integer.parseInt(doc_Num));
		spreadSheetVo.setSp_Content(sp_Content);
		boolean flag = spreadSheetService.updateSpreadSheet(spreadSheetVo);
		return flag;
	}
	
	
	@RequestMapping(value="preViewFile",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> preViewFile(@RequestBody Map<String,Object> map, HttpSession session,Model model) throws SQLException{
		DocumentVo documentVo= documentService.selectDocumentByDocNum(Integer.parseInt(map.get("doc_Num").toString()));		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		if(documentVo.getDoc_Kind()==1){
		SpreadSheetVo spreadSheetVo = new SpreadSheetVo();
		spreadSheetVo.setDoc_Num(Integer.parseInt(map.get("doc_Num").toString()));
		spreadSheetVo = spreadSheetService.selectSpreadSheetByDocNum(Integer.parseInt(map.get("doc_Num").toString()));
		resultMap.put("type", 1);
		resultMap.put("content", spreadSheetVo.getSp_Content());
		}else if(documentVo.getDoc_Kind()==2){
		WordSheetVo wordSheetVo = new WordSheetVo();
		wordSheetVo.setDoc_Num(Integer.parseInt(map.get("doc_Num").toString()));
		wordSheetVo = wordSheetService.selectWordSheetByDocNum(Integer.parseInt(map.get("doc_Num").toString()));
		resultMap.put("type", 2);
		resultMap.put("content", wordSheetVo.getWd_Content());
		}
		
		return resultMap;
		
	}

	////////////////////////////////// Spread Sheet ///////////////////////////////////////////////////
	
	
	@RequestMapping("canvasForm")
	public String canvasForm(){
		String url = "/work/canvasForm";
		return url;
	}
	
	//워드프로세스 생성
	@RequestMapping(value="createWordSheet",method=RequestMethod.POST)
	public @ResponseBody boolean createWordSheet(@RequestBody Map<String,Object> map,HttpSession session) throws SQLException{
		
		
		
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		String proj_Num = (String) session.getAttribute("joinProj");
		DocumentVo documentVo = new DocumentVo();
		documentVo.setDoc_Kind(2);
		documentVo.setDoc_Name("WordProcess");
		documentVo.setDoc_File_Name("WordProcess");
		documentVo.setMem_Email(memberVo.getMem_Email());
		documentVo.setMem_Name(memberVo.getMem_Name());
		documentVo.setProj_Num(Integer.parseInt(proj_Num));
		documentVo.setDoc_Img("doc.png");
		WordSheetVo wordSheetVo = new WordSheetVo();
		wordSheetVo.setWd_Content(map.get("wd_Content").toString());
		boolean flag = documentService.insertDictionaryWordSeet(documentVo,wordSheetVo);
		return flag;
		
	}
	//워드프로세스 폼 
	@RequestMapping(value="spreadWordForm",method = RequestMethod.GET)
	public String WordSheet(HttpSession session) throws SQLException{
		String url = "/work/wordSheetForm";
		return url;
	}
	
	@RequestMapping(value="saveWord",method=RequestMethod.POST)
	public @ResponseBody int SaveWord(@RequestBody Map<String,Object> map) throws SQLException{
		int result=1;
		WordSheetVo wordSheetVo = new WordSheetVo();
		wordSheetVo.setWd_Content(map.get("wd_Content").toString());
		wordSheetVo.setDoc_Num(Integer.parseInt(map.get("doc_Num").toString()));
		
		wordSheetService.updateWordSheet(wordSheetVo);
		
		return result;
		
		
		
	}
	
	@RequestMapping(value="exportWord",method=RequestMethod.POST)
	public void ExportWord(@RequestBody String wd_Content){
		System.out.println(wd_Content+"이것은 내용!!");
		
	}
	
	@RequestMapping(value="updateDocName",method = RequestMethod.POST)
	public @ResponseBody boolean updateDocName(@RequestBody DocumentVo documentVo) throws SQLException{
		boolean flag = documentService.updateDocumentName(documentVo);
		return flag;
	}
	
	
}
