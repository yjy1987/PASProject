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
	<div class="col-md-10">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			QnA <small>글 읽기</small>
		</h3>

		<fieldset>
			<form name="frm" method="post" action="QnADetail">
				<input type="hidden" name="qb_Article_Num"
					value="${param.qb_Article_Num }">


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
						<td colspan="3">${qnaBoardVo.qb_Content}<br></td>
					</tr>
			</table>
			</form>
			
			<form name="form" method="post" action="InsertQnAReply">
				<table>
					<tr>
						<td>
						<textarea rows="25" cols="70" name="qb_Reply_Content">답변할 내용입력</textarea>
						</td>	
					</tr>
					<tr style="border-bottom: 2px solid #ddd">
						<td class="text-right" colspan="3"
							style="border-top: 0px solid blue;">
							<button class="btn btn-default text-right" type="button"
								onclick="go_qnalist()">목록</button>
							<button class="btn btn-default text-right" type="button"
								onclick="InsertQnAReply()">답변달기</button>
						</td>
					</tr>
				</table>
			</form>
			
		</fieldset>
		
			<script>
			
				function go_qnalist() {
					location.href = "AdminQnAList"
				}
			
				function InsertQnAReply() {
					form.method = "post"
					form.action = "InsertQnAReply?qb_Article_Num=${qnaBoardVo.qb_Article_Num}";
					form.submit();
					
				}
			</script>

	</div>

</body>
</html>
