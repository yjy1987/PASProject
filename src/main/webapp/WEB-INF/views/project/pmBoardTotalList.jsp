<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 3. 6.      PC14      최초작성
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
 <div class="col-md-10" id="content">
    <h3 class="page-header"
            style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
            <span class="glyphicon glyphicon-globe"></span>ProjectBoard
         </h3>
         
         
        <table class="table table-hover">
               <tr class="text-center">
                  <th style="width:10%">번호</th>
                  <th style="width:60%">제목</th>
                  <th style="width:15%">작성자</th>
                  <th style="width:15%">작성일</th>
               </tr>
               <c:forEach items="${boardTotalList}" var="boardTotalVo" varStatus="status"  begin="${paging.beginNo}" end="${paging.endNo}">
                  <tr id="boardContents">
                     <td>${paging.beginNo+status.count}</td>
                     <td><a href="/project/pmBoardTotalDetail?bt_Num=${boardTotalVo.bt_Num}">${boardTotalVo.bt_Title}</a></td>
                     <td>${boardTotalVo.bt_Mem_Name}</td>
                     <td><fmt:formatDate value="${boardTotalVo.bt_Wt_Date}" pattern="yyyy-MM-dd" /></td>
                  </tr>  
               </c:forEach>
            </table>
            <form id="targetForm" action="pmBoardTotalWrite" method="post">
             <input type="button" class="btn btn-default" value="글쓰기" id="insertPmBoardTotalBtn">
             <input type="hidden" value="${boardTotalNum}" id="totalBoad_bm_Num" name="totalBoad_bm_Num">
             <input type="hidden" value="${boardTotalName}" name="boardTotalName">
             </form>
               <div class="col-md-12 text-center">
                     <c:if test="${paging.finalPageNo>0}">
                        <c:set value="${paging.prevPageNo}" var="prevPageNo" />
                        <c:set value="${paging.finalPageNo}" var="finalPageNo" />
                        <nav aria-label="Page navigation example">
                           <ul class="pagination justify-content-center">

                              <li class="page-item"><a class="page-link"
                                 href="pmBoardTotalList?bm_Num=${boardTotalNum}&page=${firstPageNo}" tabindex="-1">첫                                 
                                    페이지</a></li>
                              <c:forEach begin="1" end="${paging.finalPageNo}" var="i"
                                 varStatus="status">
                                 <li class="page-item" id="number"><a class="page-link"
                                    href="pmBoardTotalList?bm_Num=${boardTotalNum}&page=${i}">${i}</a></li>
                              </c:forEach>
                              <li class="page-item"><a class="page-link"
                                 href="pmBoardTotalList?bm_Num=${boardTotalNum}&page=${finalPageNo}">끝 페이지</a></li>
                           </ul>
                        </nav>
                     </c:if>
                  </div>   
              
</div>

<script>
	$(function(){
		$('#insertPmBoardTotalBtn').on('click',function(){
			var bm_Num = $(this).siblings('#totalBoad_bm_Num').val();
			var dataList = {'bm_Num':bm_Num};
		 	$.ajax({
				dataType:'json',
				contentType:'application/json',
				url:'checkBoardJoin',
				type:'post',
				data:JSON.stringify(dataList),
				success:function(result){
					if(result){
						$('#targetForm').submit();
					}else{
						alert("글쓰기 권한이 없습니다.");
					}
				}
			})
		});
		
		$('li').each(function() {
        	if (window.location.href.indexOf($(this).find('a:first').attr('href')) > -1){
        		 $(this).addClass('active').siblings().removeClass('active');
        		 }
                    });
	})
</script>
</body>
</html>