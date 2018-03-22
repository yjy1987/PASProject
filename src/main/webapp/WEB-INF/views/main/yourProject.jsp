<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form id="frmm" enctype="multipart/form-data">
			<input type="file" name="file" />
			<input type="button" class="btn btn-primary" value="파일 올리기">
</form>

	

	
	
	<h3>MultipartFile 사용</h3>
	<form action="yourProject" method="POST"
		enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br /> 파일 : <input
			type="file" name="f"><br /> <input type="submit" value="전송" />
	</form>
	
</body>
</html>