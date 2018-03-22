<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
#teamImg {
	border-radius: 50%;
	width: 40px;
	height: 40px;
}

</style>
</head>
<body>
<style>
#content > form > table > tbody > tr > td{
padding-left:10px;
padding-right:10px;
}
#content > form > ul > li:nth-child > img{
width:200px !important;
}
</style>

<script type="text/javascript">



         $(function() {
            // 콤보박스가 변경될 때 이벤트 발생
            $('#positionSelect').change(function() {
                // 드롭다운리스트에서 선택된 값을 텍스트박스에 출력
                var selectedText =
                   
                   /*   $("option:selected").text();
                    //$("option:selected").text();
 */                  $(":selected").text(); 
                $('#position_Name').val(selectedText);
                 $('#position_Name option:eq(0)').attr("selected","selected"); 
            });
         })   
            
        
            
            
            
            $(function() {
            $('#TeamMemberUpdate').click(function() {
            var position_Num=$("#positionSelect option:selected").val();   
            var mem_Email =$("#mem_Email_Modal").val();
            var dataList={
                  'position_Num':position_Num,'mem_Email':mem_Email};
             $.ajax({
               type:'POST',
               url:'TeamMemberUpdate',
               dataType:'JSON',
               contentType : 'application/json; charset=UTF-8',
            data : JSON.stringify(dataList),
            success : function(data) {
            	alert('직책수정완료');
            	location.href="<%= request.getContextPath()%>/project/pmMemberList";
            } 
            }); 
            })
        });
         
         function show(mem_Email){
            
            
            $(function(){
               var dataList = {'mem_Email': mem_Email};
               
               $.ajax({
                  type:'POST',
                  url:'activeMemberModal',
                  dataType:'JSON',
                  data:JSON.stringify(dataList),
                  contentType: 'application/json; charset=UTF-8',
                  success:function(data){
                	 if(data.position_Name=='PL'){
                		 $('#positionSelect').attr('style','display:none');
                		 $('#TeamMemberUpdate').attr('style','display:none');
                		 $('#TeamMemberDelete').attr('style','display:none');
                		 $('#ProjectDelete').attr('style','display:inline');
                	 }else{
                		 $('#positionSelect').attr('style','display:inlline');
                		 $('#TeamMemberUpdate').attr('style','display:inline');
                		 $('#TeamMemberDelete').attr('style','display:inline');
                		 $('#ProjectDelete').attr('style','display:none');
                	 } 
                	  
                     $('#mem_Img_Modal').attr('src','/resources/upload/'+data.mem_Img);
                     $('#position_Name').val(data.position_Name);
                     $('#mem_Email_Modal').val(data.mem_Email);
                     $('#mem_Name_Modal').val(data.mem_Name);
                     $('#mem_Phone_Modal').val(data.mem_Phone);
                     $('#positionSelect').val(data.position_Num).attr("selected","selected");
                     $('#memList').modal('show');
                  }
                  
                  
               })  
            })
         }
         
         $(function() {
        
            $('#TeamMemberDelete').click(function(){
               
               
               var mem_Email = $('#mem_Email_Modal').val();
               var dataList={'mem_Email':mem_Email};
               $.ajax({
               type: 'POST',
               url: 'TeamMemberDelete',
               datType:'json',
               data:JSON.stringify(dataList),
               contentType: 'application/json; charset=UTF-8',
               success:function(data){
                
                  alert('팀원탈퇴성공');
                  location.href="<%= request.getContextPath()%>/project/pmMemberList";
               }
                  
               })
              
            })
            
         })
         
         $(function(){
        	$('#ProjectDelete').click(function(){
        		
        		$.ajax({
        			type:'POST',
        			url:'ProjectDelete',
        			success:function(data){
        				location.href="/main/myProject";
        			}
        			
        		})
        		
        	})
        	 
        	 
         })
         
    </script>

<div class="col-md-10" id="content">
      <h3 class="page-header"
         style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
         프로젝트 인원<small> ${memPositionView.proj_Name}</small>
      </h3>
      <form style="padding:30px;">
         

               <ul>
                           <c:forEach var="pmMemberList" items="${pmMemberList }">
               <li style="float:left; padding:30px;"><img src="/resources/upload/${pmMemberList.mem_Img }" style="border-radius: 50%; width:200px; height:200px;" onerror="this.src='/resources/upload/human.jpg'">
               <br><br><center><b><input type="button" class="btn btn-default" onclick="show('${pmMemberList.mem_Email }')" value="${pmMemberList.mem_Name } "/></b><br>
               <b>${pmMemberList.proj_Log_Time}</b>
               </center>
               </li>
               </c:forEach>
               </ul>
            
        
         
         
         
         
         <!-- Modal -->
  <div class="modal fade" id="memList" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">상세 정보</h4>
        </div>
        <div class="modal-body">
            
            <div class="row">
		<div class="col-md-16">
			<h2 class="page-header"
				style="border: 0px; padding-bottom: 0px; margin-top: 0px; text-align:center">
				<img class="img-thumbnail"
					src="#" 
					id="mem_Img_Modal" style="width: 200px; height: 200px; border-radius: 50%;" onerror = "this.src='/resources/upload/no.png'"/>

			</h2>
			<div id="bubble" style="height: auto; padding-left: 30px;">
				<div class="row">
					<div id="1">
						<form class="form-horizontal" id="update_form" >
						<div class="form-group">
								<label class="col-md-4 control-label">직책</label>
								<div class="col-md-6  inputGroupContainer">
						    <c:choose>
            <c:when test="${memPositionView.position_Name eq 'PL' }">
            
            <select id="positionSelect">
            <option value="1">PL</option>
            <option value="2">PM</option>
            <option value="3">TA</option>
            <option value="4">AA</option>
            <option value="5">DA</option>
            <option value="6">BA</option>
            <option value="7">UA</option>
            <option value="8">PE</option>
            <option value="9">NotRole</option>
           </select>
         
           <div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-folder-open"></i></span> 
			<input name="position_Name" id="position_Name" class="form-control" type="text" readonly>
									</div><br>
 
            </c:when>
            <c:otherwise>
                  
                   <div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-folder-open"></i></span> 
			<input name="position_Name" id="position_Name" class="form-control" type="text" readonly>
									</div><br>
           </c:otherwise>
            </c:choose>
            </div>
            </div><br>
            
            
						
							<div class="form-group">
								<label class="col-md-4 control-label">이메일 주소</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-envelope"></i></span> <input
											name="mem_Email" id="mem_Email_Modal" 
											class="form-control" type="text" readonly>
									</div>
								</div>
							</div><br>

							<div class="form-group" >
								<label class="col-md-4 control-label">이름</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <input name="mem_Name"
											 id="mem_Name_Modal" class="form-control"
											type="text" readonly>
									</div>
								</div>
							</div><br>
							<div class="form-group">
								<label class="col-md-4 control-label">전화번호</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-earphone"></i></span> <input
											name="mem_Phone" 
											id="mem_Phone_Modal" class="form-control" type="text" readonly>
									</div>
								</div>
							</div>
							</form>
							</div>
							</div>
							</div>
							</div>
							</div>
							
  
        </div>
        <div class="modal-footer">
        
        <c:if test="${memPositionView.position_Name eq 'PL' }">
	         <input type="button" id="TeamMemberUpdate" class="btn btn-default" data-dismiss="modal" id="TeamMemberUpdate" value="직책 수정">
	         <input type="button" id="TeamMemberDelete" class="btn btn-danger" data-dismiss="modal" id="TeamMemberDelete" value="팀원 탈퇴">
	         <input type="button" id="ProjectDelete" class="btn btn-danger" data-dismiss="modal" id="ProjectDelete" value="프로젝트 삭제">
	         
        </c:if>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          
        </div>
      </div>
      
    </div>
  </div>
      <!--         모달 구분선                                -->   
      </form>
   </div>

</body>
</html>
