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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form id="pmBoardTotalFrm" method="post" action = "pmBoardTotalUpdate">
   <div class="col-md-10" id="content">
      <h2 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><span class="glyphicon glyphicon-globe"></span>ProjectBoard</h2>
      <table class="table" style="border-top: 2px;">
         <tr style="border-top: 2px solid #ddd">
            <td class="col-md-8"><h4
                  style="margin-top: 5px; margin-bottom: 5px">
                  <b>${boardTotalVo.bt_Title}</b>
               </h4></td>
            <td 
               style="vertical-align: middle; "
            > <span   style="font-size: 11px;">${boardTotalVo.bt_Mem_Name }</span></td>
            <td 
               style="vertical-align: middle; "><span
               style="font-size: 11px"><fmt:formatDate value="${boardTotalVo.bt_Wt_Date}" pattern="yyyy.MM.dd" /></span></td>

         </tr>

         <tr>
            <td colspan="10" style="padding: 40px 0px 50px 0px; border-bottom: 1px solid #ddd">${boardTotalVo.bt_Content}<br></td>
         </tr>
      </table>

      <div>
         <div align="right">
         	<input type="hidden" id="bm_Num" value="${boardTotalVo.bm_Num}">
            <input type="button" class="btn btn-default" value="수정" id="go_update"> 
            <input type="button" class="btn btn-default" value="삭제" id="go_delete"> 
            <input type="button" class="btn btn-default" value="목록" id="go_list"> 
         </div>
         <br>
         <!-- 여기서부터 댓글 -->
   </div>
</form>
<script>
	$(function(){
		var mem_Email = '${boardTotalVo.bt_Mem_Email}';
		var bt_Num = '${boardTotalVo.bt_Num}';
		var login_Eem_Email = '${loginUser.mem_Email}';
		$('#go_list').on('click',function(){
			var bm_Num = $('#bm_Num').val();
			location.href='/project/pmBoardTotalList?bm_Num='+bm_Num;
		})
		
		$('#go_update').on('click',function(){
			if(mem_Email==login_Eem_Email){
				location.href='/project/pmBoardTotalUpdate?bt_Num='+bt_Num;
			}else{
				alert("본인 게시글이 아닙니다.")
			}
		});
		
		$('#go_delete').on('click',function(){
			if(mem_Email==login_Eem_Email){
				location.href='/project/pmBoardTotalDelte?bt_Num='+bt_Num;
			}else{
				alert("본인 게시글이 아닙니다.")
			}
		})
		
	})
</script>
</body>
</html>