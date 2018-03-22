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
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			SkillSharingBoard <small>글 쓰기</small>
		</h3>

		<div class="col-md-10">
			<form name="formm" method="post" action="SkillSharingInsert"
				class="form-horizontal">
				<fieldset>
					<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">제목</label>
						<div class="col-lg-10">
							<input type="text" name="ssb_Title" size="64"
								class="form-control" id="ssb_Title" placeholder="제목">
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">내용</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="18" id="ssb_Content"
								name="ssb_Content"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">태그</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="1" id="ssb_Tag"
								name="ssb_Tag"></textarea>
							<span class="help-block text-right">새해 복 많이 받으세요</span>
						</div>
					</div>

					<div class="form-group text-right">
						<div class="col-lg-10 col-lg-offset-2">
							<input type="button" onclick="insertFrb()" class="btn btn-default" value="등록"/>
							<button type="button"
								onclick="location.href='/SkillSharing/SkillSharingBoardList'"
								class="btn btn-default">취소</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script>
function insertFrb() {
	var result = true;
	if($('#ssb_Title').val() == ""){
		alert('제목을 작성해 주세요.')
		result = false;
	}else if($('#ssb_Content').val() == ""){
		alert('내용을 작성해 주세요.')
		result = false;
	}
	if(result == true){
	document.formm.method="post";
	document.formm.submit();
	}
};
</script>
</body>
</html>