<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

</head>

<body>

<c:if test="${exit == 'no'}">
         <script type="text/javascript">
            alert("진행 중인 프로젝트가 있습니다. 완료 혹은 나가기 후 탈퇴해 주세요.");
         </script>
      </c:if>
<!-- 
	<script>
$(function(){
	
		var popUrl = 'tempNotice';  
		var popOption = 'width=1152, height=495, resizable=no, scrollbars=no, status=no;';   
		    window.open(popUrl,"",popOption);
	
})

</script> -->

<script>
$(function(){
			$(document).on('click','.mp',function(e) {
				var mem_Email = $(this).siblings('#mem').val();
				var proj_Num = $(this).siblings('#proj').val();
				 var dataList = {'mem_Email':mem_Email,'proj_Num':proj_Num};
			 	$.ajax({
					dataType:'json',
					contentType:'application/json',
					type:'post',
					url:'selectMemberInfo',
					data:JSON.stringify(dataList),
					success:function(result){
						var mem_Name = result.mem_Name;
						var date = new Date(result.mem_Recent_Project_Login)
						var year = date.getFullYear();
						var month = (1 + date.getMonth());
						month = month >= 10 ? month : '0'+ month;
						var day = date.getDate();
						day = day >= 10 ? day : '0' + day;
						var fullD = year + '/' + month + '/'+ day;
						var data = "<a class='selftooltip' href='#' id='open'>"+mem_Name+"</a><br>"
						+"<a class='selftooltip' href='#' id='open'>최근 접속일 : "+fullD+"</a>";
						$('#memberInfoZone').empty();
						$('#memberInfoZone').append(data);
					}
				});
				$('.member-info').hide();
				$('.member-info').css({
					'box-shadow': '0 0 6px #666',
					'border-radius' : '3px',
					'background-color' : 'white',
					'z-index':'9999',
					'top' : e.pageY + 20,
					'left' : e.pageX + 10,
					'position' : 'absolute',
					'padding' : '5px'
				});
				$('.member-info').show();

				$('body').mouseup(function(e) {
					/* e.preventDefault(); */
					$('.member-info').hide();
				})
			});
			

})
	</script>

		<div class="member-info" style="display: none;" id="memberInfoZone">
			<%-- <a class="selftooltip"
				href="/main/myProject" id="open">
				</a><br>
				<a class="selftooltip"
				href="/main/myProject" id="open">
				ASDASDFASDFADFASDF
				</a> --%>
		</div>


	<script>
$(function(){
	$('#navbar').css('background-color','#3c5574');
	$('#navbar2').css('background-color','#3c5574');
})
</script>

	<!-- Page Content -->
	<div class="container" id="content" 
		style="padding-left: 14px; padding-right: 14px;
		-webkit-box-shadow :none; border:0px solid black; background-color:transparent;
		">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">
					참여 프로젝트 목록

					<form style="float: right; margin-top: -5px;" class="navbar-form"
						action="myProject" name="myProject" method="post">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="프로젝트 검색"
								name="proj_Search">
							<div class="input-group-btn">
								<button style="width: 40px;" class="btn btn-default"
									type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>




				</h3>

			</div>
		</div>
		<!-- /.row -->

		<c:choose>
			<c:when test="${empty myProjectList}">
				<div class="col-md-12 ">
					<h3 class="text-center" style="line-height: 1.4; margin-top: 50px;">
						참여중이거나 완료된 프로젝트가 없습니다<br>프로젝트를 만들어 주세요
					</h3>
					<br> <br>
					<div class="text-center">
						<img src="/resources/img/f.png"
							id="createProject" value="생성하기" data-toggle="modal"
							data-target="#create" data-keyboard="false"
							style="cursor: pointer; width: 400px; margin-top: 65px;margin-bottom: 65px;" data-backdrop="static" />

					</div>
				</div>

			</c:when>
			<c:otherwise>

				<!-- Projects Row -->

				<c:forEach items="${myProjectList}" var="projectVo"
					varStatus="status">

					<div class="col-md-3" id="box"
						style="margin-bottom: 30px; background-color: white; float: left; padding: 10px 20px !important; width: 350px; height: 370px; position: relative; margin-left: 15px; margin-right: 15px; border-radius: 4px;  -webkit-box-shadow :0 2px 2px 0 rgba(0,0,0,0.14), 0 3px 1px -2px rgba(0,0,0,0.12), 0 1px 5px 0 rgba(0,0,0,0.2);">
						<h4 style="font-weight: bold; margin-top: 10px;">${projectVo.proj_Name }

							<!-- <small>&nbsp;&nbsp;&nbsp;17/02/11</small>	 -->
						</h4>
						<h5>${projectVo.proj_Team}</h5>
						<hr style="margin-top: 10px; margin-bottom: 10px;">
						<div
							style="min-height: 150px; border: 1px solid #ccc; border-radius: 5px; padding: 5px 10px; background-color: #f6faff; margin-bottom: 10px;">
							<p style="text-align:center;font-size:12pt;"><b>${projectVo.proj_Content}</b></p>
						</div>
						<script>
							$(function(){
								goModal(${projectVo.proj_Num});
							});
							</script>

						<div id="${projectVo.proj_Num}body"></div>

						<%-- 사진중에 pl사진은 겉에다가 테두리를 칠거임 --%>
						<!-- <script>
							$(function(){
								var img = "pas/resources/upload/${projectVo.mem_Img}";
								if()
							})
							</script> -->
						<hr style="margin-top: 10px; margin-bottom: 10px;">
						<button class="btn btn-block btn-default"
							onclick="javascript:gogo(${projectVo.proj_Num})" id="greenBtn1">입장하기</button>
					</div>

					<!-- Modal -->
					<div class="modal fade" id="${status.index }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title"></h4>
									${projectVo.proj_Name }
								</div>
								<div class="modal-body" id="${projectVo.proj_Num}body">팀원
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" value="입장하기"
										onclick="javascript:gogo(${projectVo.proj_Num})" />
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</c:otherwise>
		</c:choose>


		<!-- 프로젝트 생성 모달   -->
		<div class="modal fade" id="create" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header"
						style="background: linear-gradient(#FEFEFD, #F9F9F9 3%, #E5E5E5);">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title">프로젝트 생성</h3>
					</div>
					<div class="modal-body" id="createBody">
						<div class="form-group">
							<label class="col-md-4 control-label">생성자 이메일 주소</label>
							<div class="col-md-6  inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i	class="glyphicon glyphicon-envelope"></i></span> <input
										name="mem_Email" id="mem_Email" value="${sessionScope.loginUser.mem_Email}" class="form-control"
										type="text" readonly>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">프로젝트 이름</label>
							<div class="col-md-6  inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i	class="glyphicon glyphicon-envelope"></i></span> 
										<input type="hidden" id="mem_Img" value="${sessionScope.loginUser.mem_Img }"> 
									<input
										name="proj_Name" id="proj_Name" placeholder="프로젝트 이름" class="form-control"
										type="text" readonly>
								</div>
							</div>
						</div>
						
						
						
						
						
						
						
						
								<input type="hidden" id="mem_Img"
							value="${sessionScope.loginUser.mem_Img }"> 프로젝트 이름 : <input
							type="text" id="proj_Name" name="proj_Name"><br> <br>
						프로젝트 팀명 : <input type="text" id="proj_Team" name="proj_Team"><br>
						<br> 프로젝트 내용 :
						<textarea rows="15" cols="30" name="proj_Content"
							id="proj_Content"></textarea>
						<br>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" id="createBtn"
							value="생성" />

						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>



		<%-- 
		<!-- Pagination -->


		<c:if test="${!empty myProjectList}">
			<div class="row text-center">
				<div class="col-lg-12">
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>
		</c:if> --%>

		<!--
		<hr>
		 <footer>
			Footer

			<div class="row">
				<div class="col-lg-12 text-center">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>

			/.row
		</footer>
 -->
	</div>

	<script>

/* 	function goModal(proj_Num){
		var data = {'proj_Num':proj_Num};
		$.ajax({
			url:'mdlValue',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'json',
			type:'post',
			success:function(data){
				var tt="";
				$.each(data,function(i){
					tt += '<br> 이름 : '+data[i].mem_Name+'<br> 직책 : '+data[i].position_Name+'<br>'
				})
				$.each(data,function(i){
					tt+= '<img style="width:40px; height:40px" src="/resources/upload/'+data[i].mem_Img+'" >'
				})
				$('#'+proj_Num+'body').empty();
				$('#'+proj_Num+'body').append(tt);
			}
		})
	}
	 */
	 
	 
	 
	 
	 

	 
	<%--  
	
	
	 <img src="/resources/img/sun1.png"
			style="position: relative; width: 68px; height: 68px"/>
			<div style="position:relative; top: -3.84em; left:1.03em; width:80px;">
			<img src="<%=request.getContextPath() %>/resources/img/yeo.png" style="width:40px; height:40px; border-radius:50%"/>
			</div>
	  --%>
	 
	 
	 

	function goModal(proj_Num){
		var data = {'proj_Num':proj_Num};
		$.ajax({
			url:'mdlValue',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'json',
			type:'post',
			success:function(data){
				var tt="";
				$.each(data,function(i){
					if(data[i].position_Num==1){
						tt+= '<span><input type="hidden" value="'+data[i].mem_Email+'" id="mem"><input type="hidden" value="'+proj_Num+'" id="proj">'					
						+'<img class="mp" style="cursor:pointer; border-radius:50%; border-width: 4px; border-style: dotted;border-color: #f16a70 #b1d877 #8cdcda #4d4d4d;width:40px; height:40px; margin-right:5px;" src="/resources/upload/'+data[i].mem_Img+'" ></span>'
								
					}else{
						tt+=  '<span><input type="hidden" value="'+data[i].mem_Email+'"  id="mem"><input type="hidden" value="'+proj_Num+'" id="proj">'
							+'<img class="mp" style="cursor:pointer; border-radius:50%; width:40px; height:40px; margin-right:5px;" src="/resources/upload/'+data[i].mem_Img+'" ></span>'
					}
				})
				$('#'+proj_Num+'body').empty();
				$('#'+proj_Num+'body').append(tt);
			}
		})
	}
	
	
	
	
	function gogo(proj_Num){
		
		
		location.href="../project/overView?proj_Num="+proj_Num;
		
		
	
		
		
	}
	function go_Pb(){
		location.href="/SkillSharing/SkillSharingList"
	}
	function go_ProjectBoard(){
		location.href="/project/pmBoardList"
	}
	function go_Fb(){
		location.href="/freeBoard/freeBoardList"
	}
</script>

</body>

</html>
