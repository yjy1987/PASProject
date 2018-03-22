
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
<div class="container" id="content" style="padding-left:14px; padding-right:14px;">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			커뮤니티 <small>수정하기!</small>
		</h3>
					<form action="myPostUpdate_frb" method="post" >
					<input type="hidden" name="num" value="${myPostBoardVo.num}" >
		
					<table class="table" style="border-top: 2px;">
					<tr style="border-top: 2px solid #ddd">
						<td class="col-md-9"><h3
								style="margin-top: 10px; margin-bottom: 10px">
						<input type="text" name="frb_Title" value="${freeBoardVo.frb_Title}">
							</h3></td>
						<td class="col-md-1"
							style="vertical-align: middle; text-align: right"><span
							style="font-size: 13px">조회수</span>&nbsp; <span
							style="font-size: 11px;"> ${freeBoardVo.frb_Content }</span></td>
						<td class="col-md-2"
							style="vertical-align: middle; text-align: right"><span
							style="font-size: 11px"><fmt:formatDate
									value="${freeBoardVo.frb_Wt_Date}" pattern="yyyy.MM.dd hh:mm:ss" /></span></td>
					</tr>
				
					<tr>
						<td>
						<textarea name="frb_Content">${freeBoardVo.frb_Content}</textarea>
						
						</td>
					</tr>
					
					<tr style="border-bottom: 2px solid #ddd">
						<td class="text-right" colspan="3"
							style="border-top: 0px solid blue;">
						
						<button class="btn btn-default text-right" type="button"onclick="myPostBoard()">목록</button>
						<button class="btn btn-default text-right" type="submit" >수정</button> 
						
						</td>	
					</tr>
	
				</table>
</form>


			<script>
				function myPostBoard() {
					location.href = "myPostBoard"

				}
				function myPostUpdate_frb() {
					location.href = "myPostUpdate_frb?num=${myPostBoardVo.num}";
				}

				
			</script>





	</div>

</body>
</html>

</body>
</html>