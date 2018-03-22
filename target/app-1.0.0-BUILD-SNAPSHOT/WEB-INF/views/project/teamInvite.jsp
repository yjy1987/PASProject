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
<link rel="stylesheet" type="text/css"
   href="/resources/jquery/jquery.autocomplete.css" />
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>

<!-- <link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script type="text/javascript"
   src="/resources/jquery/lib/jquery.js"></script>
<script type='text/javascript'
   src="/resources/jquery/lib/jquery.ajaxQueue.js"></script>
<script type='text/javascript'
   src="/resources/jquery/jquery.autocomplete.js"></script>


   <div class="col-md-10" id="content">
      <h3 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
         프로젝트 팀원 초대
      </h3>
      
      
   <script>
      var data = "";
      
      $(function() {
         $.ajax({
            type : 'POST',
            url : 'pmMemberInvite',
            dataType : 'JSON',
            success : function(d) {
               setData(JSON.parse(d));
            }
         })
         function setData(d) {
            $("#searchbox").autocomplete(d,{
                     matchContains : true,
                     minChars : 1,
                     width : 310,
                     max : 10,
                     multiple : false,
                     scroll : true,
                     scrollHeight : 300,
                     formatItem : function(d, i, max) { // suggest 목록에 보여줄 글자
                        return "\""
                              + d.mem_Email + "\" ["
                              + d.mem_Name + "]";
                     },
                     formatMatch : function(d, i, max) { // suggest 검색 대상 필드
                        return d.mem_Email + " "
                              + d.mem_Name;
                     },
                     formatResult : function(d) {
                        return d.mem_Email;
                     }
                  });
         }
         
         $("#inviteInsert").click(
                     function() {
                        var mem_Email = $('#searchbox').val();
                        var d = "";
                        $('#zone').text("");
                         $.ajax({
                                 type : 'POST',
                                 url : 'pmInviteInsert',
                                 dataType : 'json',
                                 contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
                                 data : {
                                    'mem_Email' : mem_Email
                                 },
                                 success : function(result) {
                                    var pushData = {'push':result.mem_Email};
                   					 send(JSON.stringify(pushData)); 
                                    location.href="/project/pmMemberInvite";
                                 }
                              });
                         
                         
                        
                     })
                     
      })
      
     function deleteBtn(mem_Email){  
         $(function(){
            var Email = mem_Email;
         $.ajax({
            
            type:'POST',
              url:'deleteInvite',
              dataType:'JSON',
              data:{'mem_Email':Email},
              contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
              success:function(data){
                 alert('초대취소완료!');
                  location.href="/project/pmMemberInvite"
              }
            
            
         });
         })
      }
   </script>
   <a href="#" onclick="" id=""></a>
   <span class="glyphicon glyphicon-user"></span>
   <input type="text" id="searchbox">
         <button type="button" class="btn btn-default" data-dismiss="modal"
                     id="inviteInsert">초대</button>
      
      
      
      
      
      <table class="table table-hover">
         <tr>
            <td>프로필 사진</td>
            <td>이메일</td>
            <td>이름</td>
            <td>시각</td>
            <td>상태여부</td>
         </tr>
         
         <c:forEach var="InviteList" items="${InviteList }">
            <tr>
               <td style="vertical-align:middle"><b><img src="<%=request.getContextPath() %>/resources/upload/${InviteList.mem_Img}" style="width:80px"></b></td>
               <td style="vertical-align:middle"><b>${InviteList.mem_Email }</b></td>
               <td style="vertical-align:middle"><b>${InviteList.mem_Name }</b></td>
               <td style="vertical-align:middle"><b>${InviteList.invite_Time }</b></td>
               <td style="vertical-align:middle"><input type="button" class="btn btn-default" value="초대취소" onclick="deleteBtn('${InviteList.mem_Email}')"></td>
            </tr>
         </c:forEach>
      </table>

     
      
   </div>
</body>
</html>