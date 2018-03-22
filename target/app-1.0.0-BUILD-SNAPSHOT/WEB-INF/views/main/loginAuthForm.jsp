<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap Core CSS -->
<link
	href="/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="/resources/css/stylish-portfolio.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">


<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>


<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>
<title></title>
</head>
<style>
@font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/resources/fonts/FEDERALESCORTHALFITAL.TTF);
		
} 
#teamName{
font-family : 'FEDERALESCORTHALFITAL';
text-align : center;
font-size : 45pt;
color : white;
}
#out{
    width: 600px;
    margin: auto;
    margin-top: 300px;
}
</style>
<body>
<form>

<div class="content">
<div>
<div id="out" style="background-color:#3c5574; padding:20px;"><h3 style="text-align: center; margin-right: 46px;">
			<h3><p id="teamName">BLUEMINE</p></h3><br><br>
		<p style="font-size:20pt; color:white; text-align:center"><b>이메일 인증이 완료되셨습니다.</b></p>
		<center><button type="button" class="btn btn-default" onclick="location.href='<%=request.getContextPath() %>/main/loginForm'";>초기화면</button></center></div>
  

</div>
</div>
</form>


</body>
</html>