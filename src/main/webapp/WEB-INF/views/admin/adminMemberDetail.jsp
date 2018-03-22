<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="/resources/css/bootstrap.min.css"
	rel="stylesheet">
	<script
	src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<c:choose>
		<!-- Projects Row -->
		<c:forEach items="${myProjectList}" var="projectVo" varStatus="status">
			<div class="col-md-4 portfolio-item">
				<a href="#" onclick="goModal(${projectVo.proj_Num});"> <img
					class="img-responsive" src="http://placehold.it/700x400"
					data-toggle="modal" data-target="#${projectVo.proj_Name }"
					data-keyboard="false" data-backdrop="static">
				</a>
				<h3>
					<a href="#">${projectVo.proj_Name }</a>
				</h3>
				<p>${projectVo.proj_Content}</p>
				<c:if test="${status.count%3==0}">
					<br>
				</c:if>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="${projectVo.proj_Name }" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"></h4>
							${projectVo.proj_Name }

						</div>
						<div class="modal-body" id="${projectVo.proj_Num}body">팀원</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" value="입장하기"
								onclick="javascript:gogo(${projectVo.proj_Num})" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:choose>
</body>
</html>