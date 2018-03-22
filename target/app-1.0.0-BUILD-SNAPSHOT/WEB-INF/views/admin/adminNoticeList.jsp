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
		<form name="form" method="post" action="AdminTotalNoticeList">
		<strong><font size="5" style="margin-left: 8%">전체공지사항</font></strong>
		<select name = "keyField" size = "1" style="width: 100px; margin-left:48% ">
			<option value="title" selected>제목</option>
			<option value ="number" selected>글번호</option>
			<option value ="title_Content" selected>제목_내용</option>
		</select>
		<input type ="text" size ="20" name="keyword" value="${keyword}" >
		<input type ="submit" value="검색" >
		<br>	
		<br>
		<table style="text-align:center;" class="table table-hover">
			<tr class="text-center">
				<th  style="text-align: center;vertical-align:middle !important;">번호</th>
				<th  style="text-align: center;vertical-align:middle !important;">제목</th>
				<th  style="text-align: center;vertical-align:middle !important;">작성자</th>
				<th  style="text-align: center;vertical-align:middle !important;">작성일</th>
				
			</tr>
	
	<c:forEach var="noticeList" items="${noticeList}">
			<tr>
				
				<td style="text-align: center">${noticeList.ttnotice_Num}</td>
				<td style="text-align: center">	
				<a href = "
					/admin/adminNoticeDetail?ttnotice_Num=${noticeList.ttnotice_Num}">
						${noticeList.ttnotice_Title}</a></td>
				<td style="text-align: center">관리자</td>
				<td style="text-align: center"> 
				<fmt:parseDate value="${noticeList.ttnotice_Date}" var="date" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${date }" pattern="yyyy/MM/dd"/>
				
			
				</td>
				
			</tr>
	</c:forEach>
		</table>
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	  <button class="btn btn-default text-right" type="button" onClick="tt_NoticeInsert()">글쓰기</button>
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
		function tt_NoticeInsert(){
			location.href = "adminNoticeForm";
			
		}
	
	
	
	</script>
	</div>	
</body>
</html>
