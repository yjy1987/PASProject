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
	<div class="col-md-10" id="content" style="padding-left:30px; padding-right:30px;">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><img src="<%=request.getContextPath() %>/resources/img/megaphone.png"/>&nbsp;&nbsp;프로젝트 공지사항 
		</h3>
		<form>

			<table class="table" style="border-bottom: 1px solid black;">
				<tr>
					<td class="col-md-9" style="border-top:1px solid black;">
						<h4 style="margin-top: 5px; margin-bottom: 5px">
							<b>${NoticeVo.notice_Title }</b>
						</h4>

					</td>

					<td class="col-md-4"
						style="vertical-align: middle; text-align: right;border-top:1px solid black;"><h5><fmt:formatDate value="${NoticeVo.notice_Date }" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
							
							
							</td>
				</tr>

				<tr>
					<td colspan="3" style="line-height:35px;">${NoticeVo.mem_Name }</td>
				</tr>

				<tr>
					<td colspan="3" style="padding-top:15px; padding-bottom:50px;">${NoticeVo.notice_Content }
					<input type="hidden" name="notice_Num" id="notice_Num"
						value="${NoticeVo.notice_Num }">
					<input type="hidden" id="proj_Num" id="proj_Num"
						value="${NoticeVo.proj_Num }"></td>
				</tr>

			</table>
			<c:if test="${memPositionView.position_Name eq 'PL' }">
				<input type="button" class="btn btn-default" value="수정"
					onclick="location.href='/project/pmNoticeUpdate?proj_Num=${NoticeVo.proj_Num}&notice_Num=${NoticeVo.notice_Num}'" />
				<input type="button" class="btn btn-danger" value="삭제"
					onclick="deleteBtn(this.form)">

			</c:if>
			<button class="btn btn-default pull-right" type="button"
				onclick="go_NoticeList()">목록</button>
		</form>
	</div>

	<script>
function deleteBtn(form){
	 form.action="/project/pmNoticeDelete";
	 form.method="post";
	 form.submit();
	
}

function go_NoticeList(){
	location.href="/project/pmNoticeList";

		}
	</script>


</body>
</html>