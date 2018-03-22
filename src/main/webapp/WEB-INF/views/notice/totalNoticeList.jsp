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
			TotalNotice<small>전체 공지사항</small>
		</h3>
		
	<form name="form" method="post" action="totalNoticeList">
<!-- 	<form action="QnaBoardSearch" method="post">	 -->

<br> 
		<select name = "keyField" size = "1">
			<option value="title" selected>제목</option>
			<option value ="number" selected>글번호</option>
			<option value ="content" selected>내용</option>
			<option value ="title_Content" selected>제목+내용</option>
		</select>
		<input type ="text" size ="20" name="keyword" value="${keyword}" >
		<input type ="submit" value="검색" >	
<br>	

		<table class="table table-hover">
			<tr class="text-center">

				
				<th class="col-md-1" >번호</th>
				<th class="col-md-4" >제목</th>
				<th class="col-md-2">작성자</th>
				<th class="col-md-1">작성일</th>
				<th class="col-md-1" >조회수</th>
			</tr>
	
	<c:forEach var="noticeList" items="${noticeList}"
	begin="${paging.beginNo}" end="${paging.endNo}">
			<tr id ="boardContents">
				
				<td style="text-align: center">${noticeList.ttnotice_Num}</td>
				<td>
				<a href = "
					/notice/totalNoticeDetail?ttnotice_Num=${noticeList.ttnotice_Num}">
						${noticeList.ttnotice_Title}</a></td>
				<td>관리자</td>
				<td>
				
				${noticeList.ttnotice_Date}</td>
				<td style="text-align: center">${noticeList.ttnotice_Inq_Count}</td>

			</tr>
	</c:forEach>
		</table>
		



		<div class="col-md-12 text-center">
				<c:if test="${paging.finalPageNo>0 }">
					<c:set value="${paging.firstPageNo}" var="firstPageNo" />
					<c:set value="${paging.finalPageNo}" var="finalPageNo" />
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">

							<li class="page-item"><a class="page-link"
								href="totalNoticeList?page=${firstPageNo}" tabindex="-1">첫 페이지</a></li>


							<c:forEach begin="1" end="${paging.finalPageNo}" var="i"
								varStatus="status">
										<li class="page-item" id="number"><a
											class="page-link" href="totalNoticeList?page=${i}">${i}</a></li>
										<script>
										$(function(){
											var page = '${paging.pageNo}';
											if(page==1){
	  											$(document).find('#number').eq(0).addClass('active')
											}
										})
										$('li').each(function(){
										    if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
										    {
										    $(this).addClass('active').siblings().removeClass('active');
										    }
										});
										</script>
							</c:forEach>
							<li class="page-item"><a class="page-link"
								href="totalNoticeList?page=${finalPageNo}">끝 페이지</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
			
		
	</form>
	</div>
	
</body>
</html>
