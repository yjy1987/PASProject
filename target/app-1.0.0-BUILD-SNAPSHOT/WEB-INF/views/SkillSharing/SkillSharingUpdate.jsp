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
<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			SkillSharingBoard <small>글 수정하기</small>
		</h3>
	    <div class="col-md-10">
		<form class="form-horizontal" name="formm" method="post"
			action="SkillSharingUpdate">
			<fieldset>
				<div class="form-group">
					<label for="subject" class="col-lg-2 control-label">제목</label>
					<div class="col-lg-10">
						<input type="text" name="ssb_Title" size="64" class="form-control"
							id="ssb_Title" placeholder="제목" value="${skillSharingBoardVo.ssb_Title }">
					</div>
				</div>
				<div class="form-group">
					<label for="textArea" class="col-lg-2 control-label">내용</label>
					<div class="col-lg-10">
						<textarea class="form-control" rows="18" id="ssb_Content"
							name="ssb_Content" >${skillSharingBoardVo.ssb_Content }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="textArea" class="col-lg-2 control-label">태그</label>
					<div class="col-lg-10">
						<textarea class="form-control" rows="1" id="ssb_Tag"
							name="ssb_Tag">${skillSharingBoardVo.ssb_Tag}</textarea>
						<span class="help-block text-right">새해 복 많이 받으세요</span>
					</div>
				</div>

				<!-- <div class="clear"></div> -->
				<div class="form-group text-right">
					<div id="buttons" class="col-lg-10 col-lg-offset-2">
						<input type="button" onclick="insertFrb()"
								class="btn btn-default" value="수정" />
						<button type="button" class="btn btn-default" onClick="go_list()">취소</button>
					</div>
				</div>
				<input type="hidden" value="${skillSharingBoardVo.ssb_Article_Num}"
					name="ssb_Article_Num">
			</fieldset>
		</form>
		</div>
	</div>
<script>
function insertFrb() {
	var result = true;
	if ($('#ssb_Title').val() == "") {
		alert('제목을 작성해 주세요.')
		result = false;
	} else if ($('#ssb_Content').val() == "") {
		alert('내용을 작성해 주세요.')
		result = false;
	}
	if (result == true) {
		document.formm.method = "post";
		document.formm.submit();
	}
};
		function go_list(){
			location.href="SkillSharingDetail?ssb_Article_Num=${skillSharingBoardVo.ssb_Article_Num}&message=1";
		}
</script>
</body>
</html>