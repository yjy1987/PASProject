<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 7.      PC14      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>
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
			ProjectBoard <small>글 수정하기</small>
		</h3>
		
		<div class="col-md-10">
			<form class="form-horizontal" id="boardTotalUpdateFrm" method="post"
				action="pmBoardTotalUpdate">
				<input type="hidden" value="${boardTotalVo.bt_Num }" name = "bt_Num">
				<fieldset>
					<div class="form-group">
						<label for="subject" class="col-lg-2 control-label">제목</label>
						<div class="col-lg-10">
							<input type="text" name="bt_Title" size="64"
								class="form-control" id="bt_Title" 
								value="${boardTotalVo.bt_Title }">
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-lg-2 control-label">내용</label>
						<div class="col-lg-10">
							<textarea class="form-control" rows="18" id="bt_Content"
								name="bt_Content">${boardTotalVo.bt_Content }</textarea>
						</div>
					</div>

					<!-- <div class="clear"></div> -->
					<div class="form-group text-right">
						<div id="buttons" class="col-lg-10 col-lg-offset-2">
							<input type="button" id="updateBoardTotal" class="btn btn-default" value="수정" />
							<button type="button" class="btn btn-default" onClick="go_list()">취소</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
</div>

<script>
	$(function(){
		$('#updateBoardTotal').on('click',function(){
			$('#boardTotalUpdateFrm').submit();
		})
	})
</script>
</body>
</html>