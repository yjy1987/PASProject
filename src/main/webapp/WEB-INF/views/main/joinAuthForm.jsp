<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
	
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath() %>/resources/css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getContextPath() %>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.js"></script>
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
</head>
<body>
<form>
<div class="content">
<div>
<div id="out" style="background-color:#3c5574; padding:20px;"><h3 style="text-align: center; margin-right: 46px;">
			<h3><p id="teamName">BLUEMINE</p></h3><br><br>
		<p style="font-size:20pt; color:white; text-align:center"><b>회원가입이 완료되셨습니다.<br>이메일 인증을 확인해주세요.</b></p>
		<center><input type="button" class="btn btn-default" onclick="location.href='<%=request.getContextPath() %>/index.jsp'"; value="초기화면"/></center></div>
  

</div>
</div>
</form>
<script>


</script>
</body>
</html>