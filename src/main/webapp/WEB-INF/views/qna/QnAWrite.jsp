<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="col-md-10" id="content">
		<div class="col-md-10">
			<form name="form" method="post" action="insertQnABoard" id="qnaForm">
				<h3 class="page-header"
					style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
					QnA<small> 글 쓰기</small>
				</h3>
				<fieldset>

					<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">제목</label>
						<div class="col-lg-10">
							<input type="text" name="qb_Title" size="64" class="form-control"
								id="qb_Title" placeholder="제목"><br>
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">내용</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="18" id="qb_Content"
								name="qb_Content"></textarea><br>
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						
						
					<input type="password" name="qb_Password" size="64" class="form-control"
								id="qb_Password" placeholder="게시물의 비밀번호를 입력해주세요" >
								
								
						
							<span class="help-block text-right"></span>
						</div>
					</div>

					<div class="form-group text-right">
						<div class="col-lg-10 col-lg-offset-2">
							<button type="button" class="btn btn-default" id="insertQnaBtn">등록</button>
							<button type="button"
								onclick="location.href='/SkillSharing/SkillSharingBoardList'"
								class="btn btn-default">취소</button>
							<input type="button" value="목록" class="btn btn-default" onClick="go_list()">
						</div>
					</div>
				</fieldset>
			</form>

			<script>
			
			
			$(function(){
				$('#insertQnaBtn').on('click',function(){
					var qb_Password = $('#qb_Password').val();
					if(qb_Password==null|| qb_Password==""){
						$('#qb_Password').focus();
						alert("비밀번호를 입력하세요");
					}else{
						$('#qnaForm').submit();
					}
				})
			})
				
				function go_list() {
					location.href = "QnAList"

				}
				
				
			</script>



		</div>
	</div>
</body>
</html>