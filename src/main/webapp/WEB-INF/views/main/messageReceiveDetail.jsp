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
   <script>
      $(function() {
         var input = document.getElementsByName('joinProj');
         var joinProj = input[0].value;

         if (joinProj != '') {
            $('.Message').removeClass('container').addClass('col-md-10');
         }
         $('#goList').on('click',function(){
        	 location.href="/main/messageReceiveList";
         })
      })
   </script>
   <input type="hidden" name="joinProj" value="${sessionScope.joinProj }" />

   <div class="container Message" id="content">
      <h3 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
         쪽지 읽기<small></small>
      </h3>
      <table class="table table-hover">
         <tr>
         	<th style="width:1%"></th>
            <th style="width:99%">${messageVo.msg_Title}</th>
         </tr>
         <tr>
         	<td></td>
            <td><a href="#">${messageVo.msg_sm_Name }</a><span class="pull-right" style="color:#888888;">
            <fmt:formatDate value="${messageVo.msg_Wt_Date }" pattern="yyyy-MM-dd HH:mm:ss"/>
            </span></td>
         </tr>
         <tr>
         	<td></td>
            <td >${messageVo.msg_Content }</td>
         </tr>
      </table>
      <button type="button" class="btn btn-default" style="margin-left:20px;">삭제</button>
      
     	<button type="button" id="goList" class="btn btn-default pull-right" style="margin-right:20px;">목록</button>
         <button type="button" class="btn btn-default pull-right" style="margin-right:5px;">답장</button>
         

   </div>
</body>
</html>