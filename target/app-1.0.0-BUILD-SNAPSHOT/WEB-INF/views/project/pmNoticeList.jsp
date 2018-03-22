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
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><img src="<%=request.getContextPath() %>/resources/img/megaphone.png"/>&nbsp;&nbsp;프로젝트 공지사항</h3>


<c:if test="${memPositionView.position_Name eq 'PL' }">

<input type="button" value="글쓰기" onclick="writeBtn()" style="    margin-right: 17px;
    margin-bottom: 15px;"class="btn btn-default pull-right" />
</c:if>
		<table class="table table-hover">
			<tr class="text-center">
				<th style="width:8%">번호</th>
				<th style="width:70%">제목</th>
				<th style="width:9%">작성자</th>
				<th>작성일</th>


			</tr>
			<c:forEach var="NoticeList" items="${NoticeList }"
				begin="${paging.beginNo}" end="${paging.endNo}">
				<tr>
					<td >${NoticeList.notice_Num }</td>

					<td ><a
							href="<%=request.getContextPath() %>/project/pmNoticeDetail?proj_Num=${NoticeList.proj_Num}&notice_Num=${NoticeList.notice_Num}">${NoticeList.notice_Title }</a></td>

					<td >${NoticeList.mem_Name }</td>

					<td ><fmt:formatDate
							pattern="yyyy-MM-dd" value="${NoticeList.notice_Date }" /></td>



				</tr>

			</c:forEach>

		</table>

	</div>
	<script>
function writeBtn(){
	location.href="/project/pmNoticeWrite";
		}
	</script>

</body>


</html>