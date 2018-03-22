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
	<div style="margin: auto; width: 1300px">
	<form name="form" method="post"action = "adminNoticeUpdate">
	<input type="hidden" name="ttnotice_Num" value="${totalNoticeVo.ttnotice_Num}">
		<fieldset>
				<legend>TotalNotice</legend>
				<label>Title</label> 
				<input type="text" name="ttnotice_Title" size="64" value ="${totalNoticeVo.ttnotice_Title}"><br>
				
				<label>Content</label> 
				<textarea rows="8" cols="65" name="ttnotice_Content">${totalNoticeVo.ttnotice_Content}</textarea>
				<br>
			<div class="clear"></div>
			
			<button type="submit" class="btn btn-default">수정</button>
			<input type="reset" value ="초기화" class="cancel">
			<input type= "button" value="목록" onClick = "go_ttNoticList()">
	
			</fieldset>

	</form>
	<script>
		function go_ttNoticList(){
			location.href = "totalNoticeList";
		}
		
	
	</script>

	</div>
</body>
</html>