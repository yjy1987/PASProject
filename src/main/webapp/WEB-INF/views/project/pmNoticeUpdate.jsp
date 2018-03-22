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
			프로젝트 공지사항 <small>글 수정</small>
		</h3>
		<div class="col-md-10">
<form class="form-horizontal">
			 <fieldset>
			 
<input type="hidden" name="proj_Num" value="${NoticeVo.proj_Num }" readonly>
<input type="hidden" name="notice_Num" value="${NoticeVo.notice_Num }" readonly>

<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">제목</label>
						<div class="col-lg-10">
							<input type="text" name="notice_Title" size="64"
								class="form-control" id="notice_Title" placeholder="제목" value="${NoticeVo.notice_Title }">
						</div>
					</div>
					
					
					
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">내용</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="18" id="notice_Content"
								name="notice_Content" >${NoticeVo.notice_Content }"</textarea>
						</div>
					</div>

<input type="button" class="btn btn-default pull-right" value="수정하기" onclick="updateBtn(this.form)">
</fieldset>
</form>
</div>
</div>
<script>
function updateBtn(form){
	form.action="/project/pmNoticeUpdate";
	form.method="post";
	form.submit();
}

</script>

</body>
</html>