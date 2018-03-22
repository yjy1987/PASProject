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
<a href="<%=request.getContextPath() %>/freeBoard/freeBoardList">FreeBoard 리스트</a>
<br><a href="<%=request.getContextPath() %>/SkillSharing/SkillSharingList">SkillSharingBoard 리스트</a>
<br><a href="<%=request.getContextPath() %>/project/projectBoardList">projectBoard 리스트</a>
<br><a href="<%=request.getContextPath() %>/qna/QnAList">QnABoard 리스트</a>
</body>
</html>