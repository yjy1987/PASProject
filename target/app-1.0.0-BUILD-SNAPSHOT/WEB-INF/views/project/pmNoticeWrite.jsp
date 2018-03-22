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
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><img src="<%=request.getContextPath() %>/resources/img/megaphone.png"/>&nbsp;&nbsp;프로젝트 공지사항
		</h3>
		<div class="col-md-10">
		
			<form class="form-horizontal">
			 <fieldset>
				<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">제목</label>
						<div class="col-lg-10">
							<input type="text" name="notice_Title" size="64"
								class="form-control" id="notice_Title" placeholder="제목">
						</div>
					</div>
					
							<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">작성자</label>
						<div class="col-lg-10">
							<input type="text" name="mem_Name" size="64"
								class="form-control" id="mem_Name" value="${loginUser.mem_Name }" readonly>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label" >내용</label>
						<div class="col-lg-10">
							<textarea class="form-control" style="resize:none;" rows="18" id="notice_Content"
								name="notice_Content"></textarea>
						</div>
					</div>
				
				
				
				
				
					 <input type="button" class="btn btn-default pull-right"
					value="글쓰기" onClick="noticeBtn(this.form)" />
			</fieldset>
			</form>
			

			<script>
 function noticeBtn(form){
	 form.action="/project/pmNoticeWrite";
					form.method = "post";
					form.submit();
				}
			</script>
				</div>
		
	</div>
</body>
</html>
