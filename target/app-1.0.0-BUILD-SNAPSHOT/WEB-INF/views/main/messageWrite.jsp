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

	<input type="hidden" name="joinProj" value="${sessionScope.joinProj }" />
   
	<script>
		$(function() {
			var input = document.getElementsByName('joinProj');
			var joinProj = input[0].value;

			if (joinProj != '') {
				$('.Message').removeClass('container')
						.addClass('col-md-10');
			}
		})
	</script>

	<div class="container Message" id="content">

   
      <h3 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
         쪽지 보내기 <small></small>
      </h3>
      <div class="col-md-10">
         <form name="formm" method="post" action="messageInsert"
            class="form-horizontal">
            <fieldset>
               <div class="form-group">
                  <label for="subject" class="col-lg-2 control-label">받는이</label>
                  <div class="col-lg-10">
                     <input type="text" name="msg_rm_Email" size="64"
                        class="form-control" id="msg_rm_Email" value ="">
                  </div>
               </div>
               <div class="form-group">
                  <label for="subject" class="col-lg-2 control-label">제목</label>
                  <div class="col-lg-10">
                     <input type="text" name="msg_Title" size="64"
                        class="form-control" id="msg_Title" placeholder="제목">
                  </div>
               </div>
               <div class="form-group">
                  <label for="textArea" class="col-lg-2 control-label">내용</label>
                  <div class="col-lg-10">
                     <textarea class="form-control" rows="18" id="msg_Content"
                        name="msg_Content"
                        style="resize: none; overflow: auto; outline: none; -webkit-box-shadow: none; -moz-box-shadow: none; box-shadow: none;"></textarea>
                  </div>
               </div>

               <div class="form-group text-right">
                  <div class="col-lg-10 col-lg-offset-2">
                     <button type="submit" class="btn btn-default" id="submit">보내기</button>
                     <button type="button"
                        onclick="location.href='/SkillSharing/SkillSharingBoardList'"
                        class="btn btn-default">취소</button>
                  </div>
               </div>
            </fieldset>
         </form>
      </div>
   </div>
</body>
</html>