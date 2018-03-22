<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
table tr td{
padding: 10px;
}

</style>
</head>

<body>
	<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			My Project List <small> &nbsp; 내가 쓴 글</small>
		</h3>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;
			
			 <button type="submit" onclick="pmBoardList()">목록으로</button>
			 <br><br>
			<fieldset>
			<form name="frm" method="post" action="pmBoardInsert">
		<input type="hidden" name="pb_Content" value="${ProjectBoardVo.pb_Content}">
			
				
				<table class="col-md-10" style="border: 2px solid #ddd">
				<tr>
				<td colspan=2>
				
				</td>
				</tr>
					<tr>
						<td class="col-md-1">이경희 BA</td>
						<td class="col-md-7">
						<textarea rows="7" cols="100" name="pb_Content"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td style="text-align:right">
							<button class="btn btn-default " type="submit">글올리기</button>
						</td>
					</tr>
					
				</table>
				<br>
				<br>
				<br>
				</form>
				<!-- boardList -->
					<c:forEach var="pbList" items="${pbList}" varStatus="status">
					<br>
					<br>
					<table class="col-md-10" style="border: 2px solid #ddd">
					<tr>
						<td class="col-md-1">이경희 BA</td>
						<td class="col-md-7">
						게시물 번호 : ${pbList.pb_Article_Num}
						<textarea rows="7" cols="100" name="pb_Content" readonly> ${pbList.pb_Content}</textarea>
						<br><br>
<!-- //----------	projectBoardVo -->					

		<form name="frm" method="post" action="pmBoardUpdate">
		<input type="hidden" name="pb_Article_Num" value="${pbList.pb_Article_Num}">
		
  <!-- Modal -->
  <div class="modal fade" id="${pbList.pb_Article_Num}" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">글 수정하기</h4>
        </div>
        <div class="modal-body">
          <p>
          	<table>
					<tr>
						<td class="col-md-1">이경희 BA</td>
						<td class="col-md-7">
						게시물 번호 : ${pbList.pb_Article_Num}
						<textarea rows="7" cols="100" name="pb_Content"> ${pbList.pb_Content}</textarea>
					</td>
					</tr>
			</table>			
		</p>
        </div>
        <div class="modal-footer">
       		<input type="submit" action ="pmBoardUpdate" value="수정">
<!--           <button type="button" action = "pmBoardUpdate">수정</button> -->
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
				
	</form>					
						
				<!-- 댓글 -->
				<!-- <form  method="post" method="post" action = "insertProjectBoardReply"> -->
					 <form class="anser-write" method="post" action="insertProjectBoardReply">	
						<textarea rows="1" cols="80" name="pb_Reply_Content"></textarea>
						
						<input type="submit" class="btn btn-default" value="댓글달기"/> 

				</form>	
						<br>
					
						</td>
					</tr>
				
			<tr>
				<td>
					<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#${pbList.pb_Article_Num}">글수정
					
					</button>
					<%-- 	<input type="submit" value="글 수정" onClick="updateProjectBoard(${projectBoardVo.pb_Article_Num})"/> --%>
					</td>
					<td>
						<input type="submit" value="삭  제" onClick="deleteProjectBoard(${pbList.pb_Article_Num})"/>
					</td>
			</tr>
		
					</table>
					<br>
					</c:forEach>
					
			</fieldset>
			<script>
				
				function pmBoardList(){
					location.href="pmBoardList";
				}
				
				 function deleteProjectBoard(pb_Article_Num){
				location.href = "deleteProjectBoard?pb_Article_Num="+pb_Article_Num;
					
				}
			
			</script>
		

	</div>
</body>
</html>
