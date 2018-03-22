<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>
<script language="javascript">
      var i = 0
      window.document.onkeydown = protectKey;

      function protectKey() {
         //새로고침을 막는 스크립트.. F5 번키..
         if (event.keyCode == 116) {
            event.keyCode = 0;
            return false;
         }
         //CTRL + N 즉 새로 고침을 막는 스크립트....
         else if ((event.keyCode == 78) && (event.ctrlKey == true)) {
            event.keyCode = 0;
            return false;
         }
      }
   </script> 
   <c:if test="${like == 'yes' }">
      <script type="text/javascript">
         alert("추천완료!");
      </script>
   </c:if>
   <c:if test="${like == 'no' }">
      <script type="text/javascript">
         alert("이미 추천한 게시글 입니다.");
      </script>
   </c:if>
   <c:if test="${delete == 'yes' }">
         <script type="text/javascript">
            alert("댓글이 삭제 되었습니다.");
         </script>
      </c:if>

   <c:if test="${delete == 'no' }">
      <script type="text/javascript">
         alert("작성자만 삭제할 수 있습니다.");
      </script>
   </c:if>
   <c:if test="${modify == 'yes' }">
      <script type="text/javascript">
         alert("수정이 완료 되었습니다.");
      </script>
   </c:if>
   <c:if test="${modify == 'no' }">
      <script type="text/javascript">
         alert("작성자만 수정할 수 있습니다.");
      </script>
   </c:if>

   <!-- 본문! -->
   <form name="frm" id="frm" method="post">
   <div class="col-md-10" id="content">
   <input type="hidden" name="frb_Article_Num" id="frb_Article_Num"
                     value="${freeBoardVo.frb_Article_Num}">   
      <h2 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><span class="glyphicon glyphicon-globe"></span>커뮤니티</h2>
      <table class="table" style="border-top: 2px;">
         <tr>
            <td class="col-md-8"><h4
                  style="margin-top: 5px; margin-bottom: 5px">
                  <b>${freeBoardVo.frb_Title}</b>
               </h4></td>
            <td 
               style="vertical-align: middle; "
            > <span   style="font-size: 11px;">${freeBoardVo.mem_Email }</span></td>
            <td 
               style="vertical-align: middle; "><span
               style="font-size: 13px">조회수</span>&nbsp; <span
               style="font-size: 11px;"> ${freeBoardVo.frb_Inq_Count }</span></td>
            <td 
               style="vertical-align: middle; "><span
               style="font-size: 11px"><fmt:formatDate
                     value="${freeBoardVo.frb_Wt_Date}" pattern="yyyy.MM.dd hh:mm:ss" /></span></td>

         </tr>

         <tr>
            <td colspan="10" style="padding: 40px 0px 50px 0px; ">${freeBoardVo.frb_Content}<br></td>
            
         </tr>
      </table>

      <div>
               <span style="text-align: left;">${freeBoardVo.frb_Tag}</span>
         <div align="right">
            <input type="button" class="btn btn-default" value="수정" onclick="go_update()"> 
            <input type="button" class="btn btn-default" value="삭제" onclick="go_delete()"> 
            <input type="button" class="btn btn-default" value="목록" onClick="go_list()"> 
            <input type="button" class="btn btn-default" value="추천!" onClick="go_like()">
         </div>
         <br>
         <legend></legend>
         <!-- 여기서부터 댓글 -->
         
         <textarea rows="5" cols="100%" id="frb_Reply_Content"></textarea>
      </div>
      <div align="right">
      <input type="button" class="btn btn-default" value="등록" id="replyBtn">
      </div>
      <div id="reply" style="overflow:hidden;"></div>
   </div>
</form>


   <script type="text/javascript">
      $(document)
            .ready(
                  function() {
                     var frb_Article_Num = $('#frb_Article_Num').val();
                     var data = {
                        'frb_Article_Num' : frb_Article_Num
                     };
                     $.ajax({
                        url : 'freeBoardReplyList',
                        contentType : 'application/json',
                        dataType : 'json',
                        data : JSON.stringify(data),
                        type : 'post',
                        success : function(data) {
                           $.each(data, function(i) {
                              
                              var date = new Date(data[i].frb_Reply_Time)
                              var year = date.getFullYear();
                              var month = (1 + date.getMonth());
                              month = month >= 10 ? month : '0'+ month;
                              var day = date.getDate();
                              day = day >= 10 ? day : '0' + day;
                              var fullD = year + '.' + month + '.'+ day;
                              var rfd = '<a href="javascript:void(0);" onclick="go_rfd('+data[i].frb_Reply_Num+')"><span class="glyphicon glyphicon-remove" style="font-size:12px;margin-left:5px; margin-right:5px; color: red;"></span></a>'
                                     +'<a href="javascript:void(0);" onclick="go_rfm('+data[i].frb_Reply_Num+')"><span class="glyphicon glyphicon-pencil" style="font-size:12px;"></span></a>'
                              var tt = '<div><hr>'
                                    + data[i].frb_Reply_Mem_Name
                                    + '( ' + data[i].frb_Reply_Mem+ ' )'
                                    +'<span style="font-size: 11px">'+ fullD+'</span>'+rfd+'</div>'
                                    +'<span id="'+data[i].frb_Reply_Num+'">'+ data[i].frb_Reply_Content+'</span>'
                              $('div #reply').append(tt);
                           })
                        }
                     });

                     $('#replyBtn').on('click',
                                 function() {
                                    var frb_Article_Num = $('#frb_Article_Num').val();
                                    var frb_Reply_Content = $('#frb_Reply_Content').val();
                                    if(frb_Reply_Content==null || frb_Reply_Content==""){
                                       alert('내용을 입력해 주세요!');
                                       return;
                                    }
                                    var dataWrite = {
                                       'frb_Article_Num' : frb_Article_Num,
                                       'frb_Reply_Content' : frb_Reply_Content
                                    };
                                    
                                    $.ajax({
                                             url : 'freeBoardReplyWrite',
                                             data : JSON.stringify(dataWrite),
                                             type : 'post',
                                             contentType : 'application/json',
                                             success : function(data) {
                                                $('#frb_Reply_Content').val('');
                                                $('div #reply').empty();
                                                $.each(data,function(i) {
                                                   var date = new Date(data[i].frb_Reply_Time)
                                                   var year = date.getFullYear();
                                                   var month = (1 + date.getMonth());
                                                   month = month >= 10 ? month : '0'+ month;
                                                   var day = date.getDate();
                                                   day = day >= 10 ? day : '0' + day;
                                                   var fullD = year + '.' + month + '.'+ day;
                                                   var rfd = '<a href="javascript:void(0);" onclick="go_rfd('+data[i].frb_Reply_Num+')"><span class="glyphicon glyphicon-remove" style="font-size:12px;margin-left:5px; margin-right:5px; color: red;"></span></a>'
                                                          +'<a href="javascript:void(0);" onclick="go_rfm('+data[i].frb_Reply_Num+')"><span class="glyphicon glyphicon-pencil" style="font-size:12px;"></span></a>'
                                                   var tt = '<div><hr>'
                                                         + data[i].frb_Reply_Mem_Name
                                                         + '( ' + data[i].frb_Reply_Mem+ ' )'
                                                         +'<span style="font-size: 11px">'+ fullD+'</span>'+rfd+'</div>'
                                                         +'<span id="'+data[i].frb_Reply_Num+'">'+ data[i].frb_Reply_Content+'</span>'
                                                   $('div #reply').append(tt);
                                                            })
                                                send('push:def@naver.com');
                                             },
                                             error : function() {
                                                alert('댓글 등록 실패');
                                             }
                                          });
                                 });
                  });
      
   </script>          
             
   <script>
   function go_rfd(data){
       frm.method = "post";
       frm.action = "freeBoardReplyDelete?frb_Reply_Num="+data;
       frm.submit();
    }
    function go_rfm(data){
       var content = $('#'+data).text();
       $('#'+data).empty();
       $('#'+data).html('<textarea cols="100" rows="3" id="ttt" name="ttt">'+content+'</textarea>'
             +'<div align="right"><input class="btn btn-default" type="button" value="수정" id="rfmbtn" onclick="go_rfmm('+data+')">'
             +'<input class="btn btn-default" type="button" value="취소" id="rfcbtn" onclick="go_rfc('+data+')"></div>');
    }
    function go_rfmm(data){
       var content = $('#ttt').val();
       frm.method = "post";
       frm.action = "freeBoardReplyUpdate?frb_Reply_Num="+data+"&content="+content;
       frm.submit();
    }
    function go_rfc(data){
       var content = $('#'+data).text();
       $('span#'+data).empty();
        $('span#'+data).text(content);  
       
    }
    
    function go_list() {
       location.href = "freeBoardList"
    }


    function go_update() {
       location.href = "freeBoardUpdate?frb_Article_Num=${freeBoardVo.frb_Article_Num}";
    }
      
    function go_delete() {
  	  frm.method = "post";
        frm.action = "freeBoardDelete";
        frm.submit();
    }
    function go_like() {
       location.href = "FreeBoardLike?frb_Article_Num=${freeBoardVo.frb_Article_Num}";
    }
   </script>
</body>

</html>                  
