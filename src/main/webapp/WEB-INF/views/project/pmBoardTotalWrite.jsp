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
					ProjectBoard &nbsp;&nbsp;<small>글 쓰기</small>
				</h3>
				<div class="col-md-10">
					<form class="form-horizontal" method="post" id="pmBoardTotalWriteForm"
						action="pmBoardTotalInsert">
						<fieldset>
							<!-- 						<legend>Legend</legend> -->
							<div class="form-group">
								<label for="subject" class="col-lg-2 control-label">제목</label>
								<div class="col-lg-10">
									<input type="text" name="bt_Title" size="64"
										class="form-control" placeholder="제목">
								</div>
							</div>
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">내용</label>
								<div class="col-lg-10">
									<textarea class="form-control" rows="18" 
										name="bt_Content"></textarea>
								</div>
							</div>
							<div class="form-group text-right">
								<div class="col-lg-10 col-lg-offset-2">
									<input type="hidden" value="${bm_Num}" name="bm_Num">
									<input type="button" id="insertPmBoardTotalBtn" class="btn btn-default" value="등록"/>
									<button type="button" onclick="location.href='/project/pmBoardTotalList?bm_Num=${bm_Num}'" class="btn btn-default">취소</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
</div>

<script>
	$(function(){
		$('#insertPmBoardTotalBtn').on('click',function(){
			$('#pmBoardTotalWriteForm').submit();
		})
		
	})
</script>
</body>
</html>