<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
html {
	background-color: #f9f9f9;
}

@font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/resources/fonts/FEDERALESCORTHALFITAL.TTF);
}

#titleLogo {
	font-family: 'FEDERALESCORTHALFITAL';
	color: #337ab7;
	.
	effect2
}

.effect2 {
	position: relative;
}

.effect2:before, .effect2:after {
	z-index: -1;
	position: absolute;
	content: "";
	bottom: 15px;
	left: 10px;
	width: 50%;
	top: 80%;
	max-width: 300px;
	background: #777;
	-webkit-box-shadow: 0 15px 10px #777;
	-moz-box-shadow: 0 15px 10px #777;
	box-shadow: 0 15px 10px #777;
	-webkit-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-o-transform: rotate(-3deg);
	-ms-transform: rotate(-3deg);
	transform: rotate(-3deg);
}

.effect2:after {
	-webkit-transform: rotate(3deg);
	-moz-transform: rotate(3deg);
	-o-transform: rotate(3deg);
	-ms-transform: rotate(3deg);
	transform: rotate(3deg);
	right: 10px;
	left: auto;
}
</style>
<title></title>
</head>
<body>
	<h3 id="titleLogo"
		style="font-size: 40px; font-family: 'FEDERALESCORTHALFITAL' !important; text-align: right; margin-right: 35px;">
		BLUEMINE</h3>
	<div style="margin: auto;" class="box effect2">
		<h3>
			서비스 이용에<br> <span style="color: #f09101">불편을 드려서 </span>죄송합니다.<br>
			찾으시려는 페이지가 존재하지 않거나, 현재 사용할 수 없는 페이지입니다.
		</h3>
	</div>
	<input type="button" value="메인으로 가기" onclick="go_index()">
	<script>
	function go_index() {
		 location.href = "/index";

		}
	</script>

</body>
</html>