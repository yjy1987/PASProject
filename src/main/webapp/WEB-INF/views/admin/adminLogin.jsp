<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

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
<script
	src="/resources/js/bootstrap.min.js"></script>



<style>

/* table tr td { 
border: 1px solid black;
} */
body {
	background-color: rgb(249, 249, 249);
}

.title {
	max-width: 350px;
	margin: auto;
}

.container {
	max-width: 350px;
	outline: 1px solid rgb(216, 222, 226);
	background-color: white;
	margin-top: 30px;
	padding: 30px;
}

.dividercontainer {
	max-width: 350px;
	margin: auto;
}

@font-face {
	font-family: 'NanumGothic';
	src: url(resources/fonts/NANUMBARUNGOTHIC.TTF) format('truetype');
}

body {
	font-family: NanumGothic;
}

.divider {
	position: relative;
	width: 100%;
	height: 1px;
	background: #ddd;
	margin: 30px auto;
}

.divider:after {
	content: 'OR';
	width: 30px;
	height: 30px;
	line-height: 30px;
	border-radius: 15px;
	font-size: 12px;
	color: #666;
	background: #fff;
	border: 1px solid #f0f0f0;
	display: block;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -15px;
	margin-left: -15px;
	text-align: center;
}
</style>


<meta charset="UTF-8">
<title></title>

</head>
<body style="height: 90%">








	<div class="container2">

		<h3 style="text-align: right; margin-right: 46px;">
			<img style="width: 80px"
				src="/resources/img/logo.png">
		</h3>
		<div class="title">


			<h2>ADMIN</h2>
			<hr style="color: rgb(216, 222, 226); margin-top: 5px;">
		</div>

		<div class="container">
			<form>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="admin_Email" name="admin_Email"
						placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="admin_Pass" name="admin_Pass"
						placeholder="Enter password">
				</div>
				<input type="button" id="login" class="btn btn-default btn-block"
					value="LOGIN" name="login1"> <input type="button" id="home"
					class="btn btn-default btn-block" value="HOME" name="home"
					onclick="go_Home()">


			</form>
		</div>

	</div>

</body>
<script>
	
function go_Home(){
	location.href = "/index";

}
	
	$(document).ready(function() {
		$('#forget').click(function() {
			$("#hiddenEmail").hide();
			$("#hiddenDiv").show();
			
		})
		
		$('#forget1').click(function() {
			
			$("#hiddenDiv").hide();
			$("#hiddenEmail").show();
			
		})

	});
	
</script>
<script type="text/javascript">
	$(function() {
		$("#login").click(function() {
			var admin_Email = $('#admin_Email').val();
			var admin_Pass = $('#admin_Pass').val();
			
			$.ajax({
				type : 'POST',
				url : '/admin/login',
				dataType : 'json',
				data : {
					'admin_Email' : admin_Email,
					'admin_Pass' : admin_Pass
				},
				
				success : function(result) {
					if (result == 1) {
                        location.href="/admin/adminMain";
											} else if (result == 0) {
												alert("아이디가 틀렸습니다");

											} else if (result == 2) {
												alert("비밀번호 오류입니다.");

											} else if (result == 3) {
												alert("아이디가 틀렸습니다.");
											}

										}

									});
						});
	});

	$('#login').keypress(function(e) {
		var key = e.which;
		if (key == 13) // the enter key code
		{
			$('input[name = login1]').click();
			return false;
		}
	});
</script>
</html>
