
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
			기술공유<small>내가쓴글읽기</small>
		</h3>
		
					<table class="table" style="border-top: 2px;">
					<tr style="border-top: 2px solid #ddd">
						<td class="col-md-9"><h3
								style="margin-top: 10px; margin-bottom: 10px">
								<b>${skillSharingBoardVo.ssb_Title}</b>
							</h3></td>
						<td class="col-md-1"
							style="vertical-align: middle; text-align: right"><span
							style="font-size: 13px">조회수</span>&nbsp; <span
							style="font-size: 11px;"> ${skillSharingBoardVo.ssb_Inq_Count }</span></td>
						<td class="col-md-2"
							style="vertical-align: middle; text-align: right"><span
							style="font-size: 11px"><fmt:formatDate
									value="${skillSharingBoardVo.ssb_wt_date}" pattern="yyyy.MM.dd hh:mm:ss" /></span></td>
					</tr>
					<tr>
						<td colspan="3">${skillSharingBoardVo.mem_Email }</td>
					</tr>
					<tr>
						<td colspan="3">${skillSharingBoardVo.ssb_Content}<br>
						</td>
					</tr>
					
					<tr style="border-bottom: 2px solid #ddd">
						<td class="text-right" colspan="3"
							style="border-top: 0px solid blue;">
						
						<form action ="myPostDelete_skill" method="post">
						
						<button class="btn btn-default text-right" type="button"onclick="myPostBoard()">목록</button>
						<button class="btn btn-default text-right" type="button" onClick="myPostUpdateForm_Skill()">수정</button> 
						<input type="hidden" name="num" value="${myPostBoardVo.num}" >
						<button class="btn btn-default text-right" type="submit" >삭제</button>
						
						</form>
						
						</td>	
					</tr>
					
					
					<tr>
						<td>
						<c:forEach items="${ssb_replyList}" var="ssb_replyList" varStatus="status">
							${status.index+1} 번째리플 ><br>
							작성자 이름 : ${ssb_replyList.ssb_Reply_Mem_Name } <br>
							내용 : ${ssb_replyList.ssb_Reply_Content} <br><br>
							</c:forEach>
						
						</td>
					</tr>
					
						
				</table>



			<script>
				function myPostBoard() {
					location.href = "myPostBoard"
	
				}
				function myPostUpdateForm_Skill() {
					location.href = "myPostUpdateForm_Skill?num=${myPostBoardVo.num}";
				}

				function myPostDelete_skill() {
					frm.method = "post"
					frm.action = "myPostDelete_skill";
					frm.submit();
				}
			
			</script>





	</div>

</body>
</html>


































</body>
</html>