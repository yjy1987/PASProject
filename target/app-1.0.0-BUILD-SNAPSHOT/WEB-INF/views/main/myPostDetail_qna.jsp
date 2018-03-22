
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
	<div class="container" id="content"
		style="padding-left: 14px; padding-right: 14px;">

		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			QnA <small>내가쓴글읽기</small>
		</h3>

		<table class="table" style="border-top: 2px;">
			<tr style="border-top: 2px solid #ddd">
				<td class="col-md-9"><h3
						style="margin-top: 10px; margin-bottom: 10px">
						<b>${qnaBoardVo.qb_Title}</b>
					</h3></td>
				<td class="col-md-1"
					style="vertical-align: middle; text-align: right"><span
					style="font-size: 13px">조회수</span>&nbsp; <span
					style="font-size: 11px;"> ${qnaBoardVo.qb_Inq_Count }</span></td>
				<td class="col-md-2"
					style="vertical-align: middle; text-align: right"><span
					style="font-size: 11px"><fmt:formatDate
							value="${qnaBoardVo.qb_Wt_Date}" pattern="yyyy.MM.dd hh:mm:ss" /></span></td>
			</tr>
			<tr>
				<td colspan="3">${qnaBoardVo.mem_Email }</td>
			</tr>
			<tr>
				<td colspan="3">${qnaBoardVo.qb_Content}<br>
				</td>
			</tr>

			<tr style="border-bottom: 2px solid #ddd">
				<td class="text-right" colspan="3"
					style="border-top: 0px solid blue;">

				<form action ="myPostDelete_qna" method="post">
				<input type="hidden" name="num" value="${myPostBoardVo.num}" >
				
					<button class="btn btn-default text-right" type="button"
						onclick="myPostBoard()">목록</button>
					<button class="btn btn-default text-right" type="button"
						onClick="go_qnaupdate1()">수정</button>
					<button class="btn btn-default text-right" type="submit" >삭제</button>
				</form>
			
				</td>
			</tr>

			<tr>
			<td>
					<c:if test='${qnaBoardVo.qb_yn eq "1"}'>
					관리자 답변 ><br> 
								${qnaBoardReplyVo.qb_Reply_Content}
					</c:if>
					<c:if test='${qnaBoardVo.qb_yn eq "0"}'>
					질문에 대한 답변이 없습니다. 
					</c:if>
					
					
					
					
			</td>
			</tr>
		</table>

		<script>
			function myPostBoard() {
				location.href = "myPostBoard"

			}
			function go_qnaupdate() {
				location.href = "QnAUpdate?qb_Article_Num=${qnaBoardVo.qb_Article_Num}";
			}

			function go_delete() {
				frm.method = "post"
				frm.action = "QnADelete";
				frm.submit();
			}
			function InsertQnAReply() {
				form.method = "post"
				form.action = "InsertQnAReply";
				form.submit();

			}
		</script>
	</div>
</body>
</html>


































</body>
</html>