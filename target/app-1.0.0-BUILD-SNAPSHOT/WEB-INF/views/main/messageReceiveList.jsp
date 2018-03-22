<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script>
		$(function() {
			var input = document.getElementsByName('joinProj');
			var joinProj = input[0].value;

			if (joinProj != '') {
				$('.Message').removeClass('container')
						.addClass('col-md-10');
			}
		})
	</script>

	<div class="container Message" id="content">

		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			받은 쪽지함 <small><a href="<%=request.getContextPath() %>/main/messageWrite">쪽지 보내기</a></small>
		</h3>



		<input type="hidden" name="joinProj" value="${sessionScope.joinProj }" />

		<button class="btn btn-default pull-right" id="send" style="margin-right:25px;">보낸 편지함 가기</button>
	
		<script>
		$(function(){
			$('#send').on('click',function(){
				location.href="/main/messageSendList";
			})
		})
		</script>
		
			<table id="receiveMessageList" class="table table-hover">
			<caption><b>받은 쪽지함</b></caption>
				<tr>
					<th style="width:2%"></th>
					<th style="width:46%">제목</th>
					<th  style="width:15%">보낸이</th>
					<th  style="width:15%">등록일</th>
					<th style="width:17%" >읽은 시간</th>
<th  style="width:5%"><input type="checkbox" id="checkAll" name="checkbox"/></th>
				</tr>
				
				<c:forEach items="${messageList }" var="messageVo" >
			<c:if test="${messageVo.msg_sm_del_yn == 'n' }">
				<tr id="parent_tr${messageVo.msg_Article_Num }">
					<td></td>
					<td>
					
					<c:choose>
					<c:when test="${messageVo.msg_rm_Read_yn=='n' }">
					<a href="<%=request.getContextPath() %>/main/messageReceiveDetail?msg_Article_Num=${messageVo.msg_Article_Num }" ><b>${messageVo.msg_Title }</b></a>
					</c:when>
					<c:otherwise>
					<a href="<%=request.getContextPath() %>/main/messageReceiveDetail?msg_Article_Num=${messageVo.msg_Article_Num }" >${messageVo.msg_Title }</a>
					</c:otherwise>
					</c:choose>
					
					
					
					
					</td>
					<td>${messageVo.msg_sm_Name }</td>
					<td> <fmt:formatDate value="${messageVo.msg_Wt_Date }" pattern="yyyy-MM-dd"/></td>
					
					<td>
					<fmt:parseDate value="${messageVo.msg_Rd_Date }" var="readDate" pattern="yyyy/MM/dd HH:mm:ss"/>
					<fmt:formatDate value="${readDate }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td><input type="checkbox" class="check" name="checkbox" id="checkItem"/>
						<input type="hidden" value="${messageVo.msg_Article_Num}" id="msg_Article_Num">
					</td>
				</tr>
				</c:if>
						</c:forEach>
			</table>

		<button id="deleteMessage"class="btn btn-danger pull-right" style="margin-right:25px;">삭제</button>

	</div>
<script>      
			$(function(){
				$("#checkAll").on('click',function(){
					if($("#checkAll").is(":checked")){
						$(document).find('input[id="checkItem"]').prop("checked",true);
					}else{
						$(document).find('input[id="checkItem"]').prop("checked",false);
					}
				})
				$('#deleteMessage').on('click',function(){
				 $('input:checkbox[name="checkbox"]').each(function() {
					
					 if(this.checked){
						 $(this).parents('tr').hide();
						 var msg_Article_Num = $(this).siblings('#msg_Article_Num').val();
						 var checkboxValues = [];
						 checkboxValues.push($(this).val());
						 var allData = {"msg_Article_Num" : msg_Article_Num, "checkboxValues" : checkboxValues};
						 
						  $.ajax({
							 type : 'post',
							 url : 'messageSendDelete',
							 dataType:'json',
							 data :allData,
							 success : function(result){
								 
							 },
							 error : function(result){
								 alert('실패');
							 }
							 
						 })
						  
						/*  alert($(this).siblings('#msg_Article_Num').val()); */
					 }
				 })
					
				})
				 
						
			})
			</script>
</body>
</html>