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
	<div class="container">
		
	<form name="form" method="post" action="AdminQnAList">
	<strong><font size="5" style="margin-left: 8%">Q&A관리</font></strong>
		<select name = "keyField" size = "1" style="width: 100px; margin-left:50% ">
			<option value="title" selected>제목</option>
			<option value = "name" selected>작성자</option>
			<option value ="number" selected>글번호</option>
			<option value ="title_content" selected>제목+내용</option>
		</select>
		<input type ="text" size ="20" name="keyword" value="${keyword}" >
		<input type ="submit" value="검색" >
<br>	
	
			<table style="text-align:center;" class="table table-hover">
				<tr class="text-center">
					<th style="text-align: center;vertical-align:middle !important;">답변여부</th>
					<th style="text-align: center;vertical-align:middle !important;">번호</th>
					<th style="text-align: center;vertical-align:middle !important;">제목</th>
					<th style="text-align: center;vertical-align:middle !important;">작성자</th>
					<th style="text-align: center;vertical-align:middle !important;">작성일</th>
					<th style="text-align: center;vertical-align:middle !important;">조회수</th>
				</tr>
				
				<c:forEach items="${qnaList}" var="qnaBoardVo"
					begin="${paging.beginNo}" end="${paging.endNo}">
					<tr id="boardContents">
					<td style="text-align: center;"> 
				<c:choose>
							<c:when test='${qnaBoardVo.qb_yn=="0"}'>답변미처리</c:when>
							<c:otherwise>답변완료</c:otherwise>
				</c:choose>
					</td>
					
						<td style="text-align: center">${qnaBoardVo.qb_Article_Num}</td>
						<td style="text-align: center;"><a 
							href="/admin/AdminQnADetail?qb_Article_Num=${qnaBoardVo.qb_Article_Num }">
								${qnaBoardVo.qb_Title}</a></td>
						<td style="text-align: center;">${qnaBoardVo.mem_Name }</td>
						<td style="text-align: center">
						<fmt:formatDate	value="${qnaBoardVo.qb_Wt_Date}" pattern="yyyy-MM-dd" /></td>
						<td style="text-align: center">${qnaBoardVo.qb_Inq_Count }</td>

					</tr>
				</c:forEach>
			</table>
		</form>
			
		<script>
										$('li').each(function(){
										    if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
										    {
										    $(this).addClass('active').siblings().removeClass('active');
										    }
										});
										</script>
		<script>
					function QnaWrite() {
						location.href = "QnAWrite";
					} 
				</script>
				</div>
</body>
</html>
