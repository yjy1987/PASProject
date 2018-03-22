<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<link
	href="/resources/css/bootstrap.min.css"
	rel="stylesheet">
	<script
	src="/resources/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<style>
html {
	background-color: #c0392b;
}

@font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/resources/fonts/FEDERALESCORTHALFITAL.TTF);
}

#titleLogo {
	font-family: 'FEDERALESCORTHALFITAL';

}
a{
color:#fffbd9 !important;
text-decoration:none;
}
a:hover{
text-decoration:none;
}
a:focus{
text-decoration:none;
}
</style>
<title></title>
</head>
<body style="background-color:#c0392b;">
	<h3 id="titleLogo"
		style="font-size: 40px; color:#fffbd9; font-family: 'FEDERALESCORTHALFITAL' !important; text-align: right; margin-right: 35px;">
		<a href="/index">BLUEMINE</a></h3>
	<div style="    text-align: center;    margin-top: 180px !important;font-weight:bold;
    /* min-width: 100%; */
    margin: auto;
    color:#fffbd9 !important;
    font-size:300px;
    width: 900px;">
		#500 
	</div>
	<div style=" text-align: center;margin: auto;color:#fffbd9 !important;font-size:50px; font-weight:bold;line-height:70px;">

	<a href="javascript:history.back();" >뒤로</a><br>
	<a href="javascript:go_index();" >메인으로</a>
	</div>

	<script>
	function go_index() {
		 location.href = "/index";

		}
	</script>

</body>
</html>