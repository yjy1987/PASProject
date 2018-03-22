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
	<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			<span class="glyphicon glyphicon-volume-up"></span>
			전체 공지사항 <small>글 읽기</small>
		</h3>
		<form name="frm" method="post" action="totalNoticeDetail">
				<input type="hidden" name="ttnotice_Num">
				
<!-- 		<form name="frm" method="post" action="totalNoticeDetail"> -->
<!-- 			<input type="hidden" name="ttnotice_Num" -->
<%-- 				value="${totalNoticeVo.ttnotice_Num }"> --%>

			<table class="table" style="border-top: 2px;">
				<tr >
					<td class="col-md-9">
						<h3 style="margin-top: 10px; margin-bottom: 10px">
							<b>${totalNoticeVo.ttnotice_Title}</b>
						</h3>
					</td>

					<td class="col-md-2"
						style="vertical-align: middle; text-align: right">날짜:
						${totalNoticeVo.ttnotice_Date}</td>
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

						<button class="btn btn-default text-right" type="button"
							onclick="go_NoticeList()">목록</button>
					</td>
				</tr>
			</table>
		</form>
		<script>
			function go_NoticeList() {
				location.href = "totalNoticeList";

			}
		</script>
	</div>
</body>
</html>