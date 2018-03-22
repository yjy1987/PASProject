<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>
<style>
#blah {
	border-radius: 50%;
	width: 160px;
	height: 160px;
}
#fileId{
font-size:12px;
}
</style>
</head>


<body>



	<table>
		<tr>
			<td style="padding-left:20px;"><img style="width:150px; height:150px;"
				src="<%=request.getContextPath() %>/resources/upload2/${sessionScope.joinProjectVo.proj_Img}"
				id="asdf" alt="your image" onerror="this.src='/resources/upload2/no.png'" /></td>
			<td style="padding-left: 75px;">
			프로젝트 사진을 업로드 해주세요.<br>사진 크기는 1mb이하만 가능합니다.<br><br><br>
				<form id="projImg" enctype="multipart/form-data">
					<input class="" type="file" id="fileId" name="ff" onchange="document.getElementById('asdf').src = window.URL.createObjectURL(this.files[0])">
				</form>
			</td>
		</tr>
	</table>

	<script>

	</script>

</body>
<script>
	
</script>
</html>