<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>

</head>

<body>
	<script>
$(function(){
	$('#otherProjectList').css({
		'filter':'brightness(125%)'
	});
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
					외부 프로젝트 목록
					<form style="float: right; margin-top: -5px;" class="navbar-form"
						action="otherProject" method="post">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="프로젝트 검색"
								name="proj_Search" />
							<div class="input-group-btn inline">
								<button style="width: 40px;" class="btn btn-default"
									type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- <small>Secondary Text</small> -->

				</h3>
			</div>
		</div>
		<!-- /.row -->
		<!-- Projects Row -->
		<c:forEach items="${otherProjectList}" var="projectVo"
			varStatus="status">
			<div class="col-md-3" id="box"
				style="-webkit-box-shadow :0 2px 2px 0 rgba(0,0,0,0.14), 0 3px 1px -2px rgba(0,0,0,0.12), 0 1px 5px 0 rgba(0,0,0,0.2);
				margin-bottom: 30px; background-color: white; float: left; padding: 10px 20px !important; width: 350px; height: 370px; position: relative; margin-left: 15px; margin-right: 15px; border-radius: 4px; ">
				<table style="width:100%;">
				<tr>
				<td colspan="2">
				<h4 style="font-weight: bold; margin-top: 10px;">${projectVo.proj_Name }</h4>
				</td>
				
				</tr>
				<tr>
				<td>
				<h5 style="margin-top:5px; margin-bottom:5px;">${projectVo.proj_Team}</h5>
				</td>
				<td>
				<a class="captain" href="#" onclick="goModal(${projectVo.proj_Num});" id="captain"><img
								src="<%=request.getContextPath() %>/resources/upload/${projectVo.proj_Img}"
								onerror="this.src='/resources/upload/captain.png'" style="width:50px;" align="right"></a>
				</td>
				</tr>
				</table>
			<%-- 	
				<h4 style="font-weight: bold; margin-top: 10px;">${projectVo.proj_Name } <a class="captain" href="#" onclick="goModal(${projectVo.proj_Num});" id="captain"><img
								src="<%=request.getContextPath() %>/resources/upload/${projectVo.proj_Img}"
								onerror="this.src='/resources/upload/captain.png'" style="width:50px;" align="right"></a></h4> --%>
				
				
				<div
					style="margin-top:5px; min-height: 150px; border: 1px solid #ccc; border-radius: 5px; padding: 5px 10px; background-color: #fff5f5; margin-bottom: 10px;">
					<p style="text-align:center;font-size:12pt;"><b>${projectVo.proj_Content}</b></p>
				</div>

				<hr style="margin-top: 10px; margin-bottom: 10px;">
				<div id="${projectVo.proj_Num}body"></div>
				<div id="warning" style="display: none;">
					<h4 style="color: red">...</h4>
				</div>
				<div id="${projectVo.proj_Num}btnZone">
								<input class="btn btn-block btn-default" type="button"
									onclick="javascript:goApply(${projectVo.proj_Num})"
									id="applyBtn" style="margin-right:20px;
									margin-top:20px;"
									value="참가 신청하기" />
							</div>
				</div>
	</c:forEach>		 
		<!-- /.row -->

		
		<footer>
			<!-- Footer -->

			
			<!-- /.row -->
		</footer>

	</div>

	<script>
	$(function(){
		$("#applyBtn[value='참가 신청 대기중']").click(function(){
			$('#warning').show();
		});
	})
	
	$(document).ready(function() {
		
 $('.captain').trigger('click');
									});
	 function goModal(proj_Num){
		var data = {'proj_Num':proj_Num};
		$.ajax({
			url:'mdlOtherValue',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'json',
			type:'post',
			success:function(data){
				var tt="";
				$.each(data,function(i){
					if(data[i].position_Num==1){
					tt += '<table><tr><td rowspan="2"><img style="border-radius:50%; width:40px; height:40px; margin-right:5px;" src="/resources/upload/'+data[i].mem_Img+'" onerror=this.src="/resources/upload/no.png"></td><td><b>팀장 : '+data[i].mem_Name+'</td></tr><tr><td><b> 이메일 : '+data[i].mem_Email+'</b></td></tr></table><div>'
					}
				})
				$('#'+proj_Num+'body').empty();
				$('#'+proj_Num+'body').append(tt);
			},
			complete:function(){
				$.ajax({
					url : 'checkApply',
					contentType:'application/json',
					dataType:'json',
					type:'post',
					data:JSON.stringify(data),
					success:function(data){
						if(data!=0){
						$('#'+proj_Num+'btnZone #applyBtn').val('참가 승인 대기중');
						$('#'+proj_Num+'btnZone #applyBtn').css('color','red');
						$('#'+proj_Num+'btnZone #applyBtn').removeAttr('onclick');
						}
					},complete:function(){
						$.ajax({
							url:'checkInvite',
							contentType:'application/json',
							dataType:'json',
							type:'post',
							data:JSON.stringify(data),
							success:function(result){
								if(result!=0){
									$('#'+proj_Num+'btnZone #applyBtn').val('초대 승락 대기중');
									$('#'+proj_Num+'btnZone #applyBtn').css('color','blue');
									$('#'+proj_Num+'btnZone #applyBtn').removeAttr('onclick');
								}
							}
						})
					}
				});
			}
		});
	} 
 	function goApply(proj_Num){
		var data = {'proj_Num':proj_Num};
		$.ajax({
			url:'apply',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'json',
			type:'post',
			success:function(data){
				$('#'+proj_Num+'btnZone #applyBtn').val('참가 승인 대기중');
				$('#'+proj_Num+'btnZone #applyBtn').css('color','red');
				$('#'+proj_Num+'btnZone #applyBtn').removeAttr('onclick');
				var pushData = {'push':data.p_Mem_Email};
				 send(JSON.stringify(pushData)); 
			},error:function(data){
				alert("처리중입니다.");
				location.reload();
			}
		});
	}
</script>

</body>

</html>
