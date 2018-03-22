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
					FreeBoard <small>글 쓰기</small>
				</h3>

				<div class="col-md-10">
					<form class="form-horizontal" name="formm" method="post"
						action="freeBoardInsert">
						<fieldset>
							<!-- 						<legend>Legend</legend> -->
							<div class="form-group">
								<label for="subject" class="col-lg-2 control-label">제목</label>
								<div class="col-lg-10">
									<input type="text" name="frb_Title" size="64"
										class="form-control" id="frb_Title" placeholder="제목">
								</div>
							</div>
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">내용</label>
								<div class="col-lg-10">
									<textarea class="form-control" rows="18" id="frb_Content"
										name="frb_Content"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">태그</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" rows="1" id="frb_Tag"
										name="frb_Tag">
								<span class="help-block text-right">쉼표(,)를 이용하여 복수 등록</span>
								</div>
							</div>

							<div class="form-group text-right">
								<div class="col-lg-10 col-lg-offset-2">
									<input type="button" onclick="insertFrb()" class="btn btn-default" value="등록"/>
									<button type="button" onclick="location.href='/freeBoard/freeBoardList'" class="btn btn-default">취소</button>

								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		
<script>
function insertFrb() {
	var result = true;
	if($('#frb_Title').val() == ""){
		alert('제목을 작성해 주세요.')
		result = false;
	}else if($('#frb_Content').val() == ""){
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