<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">

<body style="paddring-right:0 !important;">
<link rel="stylesheet" type="text/css"
	href="/resources/jquery/jquery.autocomplete.css" />
<!-- <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
 -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<%-- 	<script src="/resources/jquery/lib/jquery.bgiframe.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> --%>
<script type="text/javascript"
	src="/resources/jquery/lib/jquery.js"></script>
<script type='text/javascript'
	src="/resources/jquery/lib/jquery.ajaxQueue.js"></script>
<script type='text/javascript'
	src="/resources/jquery/jquery.autocomplete.js"></script>


<form>
	<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			프로젝트 팀원 초대<small>dfef </small>
		</h3>
		
		
	<script>
		var data = "";
		
		$(function() {
			$.ajax({
				type : 'POST',
				url : 'pmMemberInvite',
				dataType : 'JSON',
				success : function(d) {
					alert(d);
					setData(JSON.parse(d));
				}

			})

			function setData(d) {
				$("#searchbox").autocomplete(
						d,
						{
							matchContains : true,
							minChars : 1,
							width : 310,
							max : 10,
							multiple : false,
							scroll : true,
							scrollHeight : 300,
							formatItem : function(d, i, max) { // suggest 목록에 보여줄 글자
								return  "\""
										+ d.mem_Email + "\" ["
										+ d.mem_Name + "]";
							},
							formatMatch : function(d, i, max) { // suggest 검색 대상 필드
								return d.mem_Email + " "
										+ d.mem_Name;
							},
							formatResult : function(d) {
								return d.mem_Email;
							}

						});
			}
			
			$("#inviteInsert")
					.click(
							function() {
								/* var mem_Email = $("input[type=hidden]").val(); */
								var d = "";
								var mem_Email = $("#searchbox").val();
								
								$('#zone').text("");
								 $.ajax({
											type : 'POST',
											url : 'pmInviteInsert',
											dataType : 'JSON',
											contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
											data : {
												'mem_Email' : mem_Email
											},
											success : function(data) {
												alert('초대완료!');
												location.href="/project/pmMemberInvite"

											}
										});
								 
								
								

							})

	</script>
	<a href="#" onclick="" id=""></a>
	<span class="glyphicon glyphicon-user"></span>

	<input type="text" id="searchbox"><input type="button" id="chuga" value="추가"><br><br>
	<div id = "zone" style="border: 1px solid black"></div>
		
		
			<button type="button" class="btn btn-default" data-dismiss="modal"
							id="inviteInsert">초대</button>
		
		
		
		
		
		<table class="table table-hover">
			<tr>
				<td>프로필 사진</td>
				<td>이메일</td>
				<td>이름</td>
				<td>시각</td>
				<td>상태여부</td>
			</tr>
			<c:forEach var="InviteList" items="${InviteList }">
				<tr>
					<td><img src="<%=request.getContextPath() %>/resources/upload/${InviteList.mem_Img}"></td>
					<td>${InviteList.mem_Email }</td>
					<td>${InviteList.mem_Name }</td>
					<td>${InviteList.invite_Time }</td>
					<td>미수락중 / <input type="button" value="초대취소" onclick="deleteBtn(this.form)"></td>
				</tr>
				<input type="hidden" name="inviteMem_Email" value="${InviteList.mem_Email }">
			</c:forEach>
		</table>

		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#invite">초대</button>
		
		
	</div>
	</form>
	
	<script>
	$("#close").click(function(){
		
	    $('#zone').text("");

	})
	
	
	function deleteBtn(form){
		
		form.action="deleteInvite";
		form.method="post";
		form.submit();
		
	}
	</script>
</body>

	
	

