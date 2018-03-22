<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			QnA <small>글 읽기</small>
		</h3>



 		<form name="frm" method="post" action="adminNoticeDetail"> 
			<input type="hidden" name="ttnotice_Num"value="${totalNoticeVo.ttnotice_Num }">
			
		<table class = "table" style="border-top:2px;">
			<tr>
				<td class="col-md-9"> 
				<h3 style="margin-top : 10px; margin-bottom:10px">
					<b>${totalNoticeVo.ttnotice_Title}</b>
				</h3></td>
				
						<td class="col-md-2"
							style="vertical-align: middle; text-align: right">
							
							날짜:	${totalNoticeVo.ttnotice_Date}
						</td>
					</tr>
					
					<tr>
						<td colspan="3">관리자 이메일 : ${totalNoticeVo.admin_Email }</td>
					</tr>
					<tr>
						<td colspan="3">공지글 내용 : ${totalNoticeVo.ttnotice_Content}<br>
						</td>
					</tr>
					
				<tr style="border-bottom: 2px solid #ddd">
						<td class="text-right" colspan="3"
							style="border-top: 0px solid blue;">
						
						<button class="btn btn-default text-right" type="button"onclick="go_tt_NoticeList()">목록</button>
						<button class="btn btn-default text-right" type="button" onClick="tt_NoticeUpdateForm()">수정</button> 
						<button class="btn btn-default text-right" type="button" onClick="adminNoticeDelete()">삭제</button>
						
						</td>	
					</tr>
		
		</table>

 </form> 
 <script>
 	function go_tt_NoticeList(){
 		location.href = "AdminTotalNoticeList"
	 
 	}
 	
 	function tt_NoticeUpdateForm(){
 		location.href = "adminNoticeUpdateForm?ttnotice_Num=${totalNoticeVo.ttnotice_Num}";
 		
 	}
 
 	function adminNoticeDelete(){
 		
 			frm.method = "post"
			frm.action = "adminNoticeDelete";
			frm.submit();

 	}
 
 
 </script>
 
</body>
</html>




