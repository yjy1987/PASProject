<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>몰아붙입시다</title>
<link
	href="/resources/css/bootstrap.min.css"
	rel="stylesheet">
	<script
	src="/resources/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<style>
   #dday {margin-left: 50px; font-weight:bold; font-size:70px; color:#f94f4c; letter-spacing:0px; font-family:arial;}
</style>
</head>
<script>

$(function(){
	if($('#asdf').prop("checked")){
		alert('asdfasdfasdf?');		
	}
	/* var $checkbox = $('#cb').val();
	if(($checkbox).prop('checked')){
	window.close(); */

})


</script>
<body>
	<script>
   var now = new Date();
   var then = new Date('March 2,2017');
   var gap = now.getTime() - then.getTime();
   gap = Math.floor(gap / (1000 * 60 * 60 * 24)) * -1;
   document.write('<div id="dday">D-<span style=color: "#f94f4c; font-size:70px;">' + gap + '</span></div>');
</script>  

<div class="container">
	<h3>CRUD 기능은 없습니다. 변동사항 생길시 <b>main/tempNotice.jsp</b> 에서 수작업 하시길</h3>
	<table class="table table-striped">
		<tr>
			<th>누가?</th>
			<th>무엇을?</th>
			<th>누구랑?</th>
			<th>언제까지?</th>
			<th>얼마나 함?</th>
		</tr>
		<tr>
			<td>이경희</td>
			<td>주간체크리스트(feat.김형기,백승부),내가쓴 게시물 보기-수정,삭제 완료 </td>
			<td>송중호겨수님,형기,승봅빠</td>
			<Td>3/1</Td>
			<td>주간체크리스트 덜했음. 끝나면 admin 해야함</td>
		</tr>
		<tr>
			<td>여준영</td>
			<td>overview, admin dash보드 만들기, 쪽지함</td>
			<td>혼자</td>
			<Td>2/24</Td>
			<td>0%</td>
		</tr>
		<tr>
			<td>허석원</td>
			<td>음성채팅, 걍채팅(△)</td>
			<td>혼자</td>
			<Td></Td>
			<td>0%</td>
		</tr>
		<tr>
			<td>김형기</td>
			<td>캘린더, 쪽지함, 문서</td>
			<td></td>
			<Td></Td>
			<td>캘린더는 거의 끝나감</td>
		</tr>
		<tr>
			<td>박동석</td>
			<td>게시판 TAG기능, 회원정보 수정기능, validation</td>
			<td>김형기(validation)</td>
			<Td>아스팔트 ㄴㄴ해</Td>
			<td>회원정보 수정기능</td>
		</tr>
	</table>
	<h4 class="text-right">오늘 하루 팝업창 안보기<input id="asdf" type="checkbox"/></h4>

	</div>
</body>
</html>