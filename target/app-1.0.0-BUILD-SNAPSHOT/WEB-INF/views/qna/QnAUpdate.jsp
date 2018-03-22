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
<form name="formm" method="post" action="QnAUpdate">
<div style="margin:auto; width:1300px" ><h1>QnaUpdate</h1><br><br>
<fieldset>
<label>Title</label>
<input type="text" type="hidden" name="qb_Title" size="64" value="${qnaBoardVo.qb_Title}"><br>
<label>Content</label>
<textarea rows="8" cols="65" name="qb_Content" >${qnaBoardVo.qb_Content}</textarea> <br>
</fieldset>

	<input type="submit" value="수정" class="submit">
	<input type="button" value="목록" onClick="go_qnalist()">

</div>
<input type="hidden" value="${qnaBoardVo.qb_Article_Num}" name="qb_Article_Num">

<script>
function go_qnalist(){
	location.href="QnAList"
	
}

</script>
</form>
</body>
</html>