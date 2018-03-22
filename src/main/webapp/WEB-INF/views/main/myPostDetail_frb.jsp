
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
			커뮤니티 <small>내가쓴글읽기</small>
		</h3>
		
					<table class="table" style="border-top: 2px;">
					<tr style="border-top: 2px solid #ddd">
						<td class="col-md-9"><h3
								style="margin-top: 10px; margin-bottom: 10px">
								<b>${freeBoardVo.frb_Title}</b>
							</h3></td>
						<td class="col-md-1"
							style="vertical-align: middle; text-align: right">
							
						<td class="col-md-2"
							style="vertical-align: middle; text-align: right"><span
							style="font-size: 11px"><fmt:formatDate
									value="${freeBoardVo.frb_Wt_Date}" pattern="yyyy.MM.dd hh:mm:ss" /></span></td>
					</tr>
					<tr>
						<td colspan="3">${freeBoardVo.mem_Email}</td>
					</tr>
					<tr>
						<td colspan="3">${freeBoardVo.frb_Content}<br>
						</td>
					</tr>
					
					<tr style="border-bottom: 2px solid #ddd">
						<td class="text-right" colspan="3"
							style="border-top: 0px solid blue;">
						
						<form action ="myPostDelete_frb" method="post">
						<button class="btn btn-default text-right" type="button"onclick="myPostBoard()">목록</button>
						
			<!-- <button class="btn btn-default text-right" type="button" onClick="myPostUpdate_frb()">수정</button>  -->
						
						<a class="btn btn-default text-right" type="button"
						 href="/main/myPostUpdateForm_frb?num=${myPostBoardVo.num}">수정</a>
						<input type="hidden" name="num" value="${myPostBoardVo.num}" >
						<button class="btn btn-default text-right" type="submit" >삭제</button>
						</form>
						</td>	
					</tr>
					
					<tr>
						<td>
						<c:forEach items="${frb_replylist}" var="frb_replylist" varStatus="status">
							${status.index+1} 번째리플 ><br>
							작성자 이름 : ${frb_replylist.frb_Reply_Mem_Name } <br>
							내용 : ${frb_replylist.frb_Reply_Content} <br><br>
							</c:forEach>
						
						</td>
					</tr>
					
						
				</table>



			<script>
				function myPostBoard() {
					location.href = "myPostBoard"

				}
				
				function myPostUpdate_frb() {
					location.href = "myPostUpdate_frb";
				}

	
			</script>





	</div>

</body>
</html>

</body>
</html>