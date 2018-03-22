<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.glyphicon {
	margin-right: 10px;
}

.panel-body {
	padding: 0px;
}

.panel-body table tr td {
	padding-left: 40px
}

.panel-body .table {
	margin-bottom: 0px;
}

#colors>div {
	float: left;
	border-radius: 10px;
	width: 20px;
	height: 20px;
	margin: 5px;
}

.panel-title>a {
	font-weight: bold;
}
</style>
</head>
<!-- <div class="container">
	<div class="row"> -->
<!-- 		<div class="col-sm-3 col-md-3"> -->

<div class="panel-group" id="accordion">
<a id="resizing" href="#collapseEight"><img id="resizingImg" src="<%=request.getContextPath() %>/resources/img/left.png">
		<img id="resizingImgRight" style="display:none;"src="<%=request.getContextPath() %>/resources/img/right.png">
		</a>


	<%--프로젝트 이미지 수정해야함 --%>

	<img id="proj_Img"
		style="
		-webkit-box-shadow :0 2px 2px 0 rgba(0,0,0,0.14), 0 3px 1px -2px rgba(0,0,0,0.12), 0 1px 5px 0 rgba(0,0,0,0.2);
		width: 180px; height: 130px; cursor: pointer; margin-bottom: 15px;"
		src="/resources/upload2/${sessionScope.joinProjectVo.proj_Img}"
		data-toggle="modal" data-target="#imgUploadModal2"
		data-keyboard="false" data-backdrop="static"
		onerror="this.src='/resources/upload2/no.png'" />

	<!-- imgUpModal -->
	<div class="modal fade" id="imgUploadModal2" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header"
					style="background: linear-gradient(#FEFEFD, #F9F9F9 3%, #E5E5E5);">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="color:black;">사진을 등록해 주세요</h3>
				</div>
				<div class="modal-body">
					<%@ include file="WEB-INF/views/project/c9.jsp"%>
				</div>
				<div class="modal-footer" style="text-align: left">
					<button id="closeModal" type="button" class="btn btn-default"
						data-dismiss="modal">닫기</button>
					<script>
						$(document).ready(function() {
							$('#closeModal').click(function() {
								location.reload();
							});
						})
					</script>
					<button class="btn btn-default pull-right" id="btn-upload2">사진
						등록하기</button>


				</div>
			</div>
		</div>
	</div>






















     









	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="/project/overView?proj_Num=${joinProjectVo.proj_Num}" ><img
					src="/resources/img/dashboard.png"><span>&nbsp;&nbsp;&nbsp;대시보드</span></a>
			</h4>
		</div>
		<div id="collapseOne" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table"
					style="margin-bottom: 0px; border-top: 0px solid blue;">
					<tr>
						<td><a style="text-decoration: none;" href="#">개괄</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmNoticeList">프로젝트
								공지사항</a></td>
					</tr>
					<%-- <tr>
						<td><a style="text-decoration: none;"
						 href="#" onClick="window.open('http://192.168.202.194:8181/project/pmChat?name=${loginUser.mem_Name}','_blank',
						 'resizable=no,width=350,height=450,top=400,left=1400')">채팅하기</a></td>
					</tr> --%>
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmBoardList">프로젝트
								게시판</a></td>
					</tr>
				</table>
			</div>

		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="/project/pmNoticeList"><img
					src="/resources/img/megaphone.png"><span>&nbsp;&nbsp;&nbsp;공지사항</span></a>
			</h4>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a 
					href="/project/pmBoardList"><img
					src="/resources/img/news.png"><span>&nbsp;&nbsp;&nbsp;뉴스
						피드</span></a>
			</h4>
		</div>
	</div>




	<div class="panel panel-default" >
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse4" id = "boardTotalList"
					style="text-decoration: none;"><img
					src="/resources/img/boards.png"><span>&nbsp;&nbsp;&nbsp;프로젝트
						게시판</span></a>
			</h4>
		</div>
		<div id="collapse4" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
				<tbody  id="boardManagementListTable"> 
				</tbody>
				</table>
			</div>
		</div>
	</div>



	<%-- <td><a style="text-decoration: none;"
						 href="#" onClick="window.open('http://192.168.202.194:8181/project/pmChat?name=${loginUser.mem_Name}','_blank',
						 'resizable=no,width=350,height=450,top=400,left=1400')">채팅하기</a></td> --%>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;" data-toggle="collapse"
					data-parent="#accordion" href="#collapseTwo"><img
					src="/resources/img/work.png"><span>&nbsp;&nbsp;&nbsp;작업
						공간</span></a>
			</h4>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
					<tr>
						<td><a
							href="/project/work/workList">파일리스트</a>
							</td>
					</tr>
					<tr>
						<td><a href="/project/work/spreadSheetForm">스프레드시트 생성</a></td>
					</tr>
					<tr>
						<td><a href="/project/work/spreadWordForm">워드프로세스 생성</a></td>
					</tr>
					<%-- <tr>
						<td><a href="/project/work/loadFile">들어가기</a></td>
					</tr>
					<tr>
						<td><a href="/work/"></a></td>
					</tr>
					<tr>
						<td><a
							href="/work/pmMemberInvite">Tex</a></td>
					</tr> --%>
				</table>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;" data-toggle="collapse"
					data-parent="#accordion" href="#collapseThree"><img
					src="/resources/img/calendar.png"><span>&nbsp;&nbsp;&nbsp;일정
						관리</span></a>
			</h4>
		</div>
		<div id="collapseThree" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px; border-top: 0px;">
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmCalendar">월별 일정
								관리</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmGantChart">간트
								차트</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/schedule/weeklyChecklist">주간
								체크 리스트</a></td>

					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;"
					href="/project/AccountBoardList"><img
					src="/resources/img/piggy-bank.png"><span>&nbsp;&nbsp;&nbsp;프로젝트
						회계</span></a>
			</h4>
		</div>
		<!-- <div id="collapseFour" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
					<tr>
						<td><span class="glyphicon glyphicon-usd"></span><a
							href="http://www.jquery2dotnet.com">Sales</a></td>
					</tr>
					<tr>
						<td><span class="glyphicon glyphicon-user"></span><a
							href="http://www.jquery2dotnet.com">Customers</a></td>
					</tr>
					<tr>
						<td><span class="glyphicon glyphicon-tasks"></span><a
							href="http://www.jquery2dotnet.com">Products</a></td>
					</tr>
					<tr>
						<td><span class="glyphicon glyphicon-shopping-cart"></span><a
							href="http://www.jquery2dotnet.com">Shopping Cart</a></td>
					</tr>
				</table>
			</div>
		</div> -->
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;" data-toggle="collapse"
					data-parent="#accordion" href="#collapseFour"><img
					src="/resources/img/settings.png"><span>&nbsp;&nbsp;&nbsp;프로젝트 관리</span></a>
			</h4>
		</div>
		<div id="collapseFour" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmMemberInvite">새로운 팀원
								초대</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/project/pmMemberList">팀원
								관리</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="#" id="boardManagementBtn">게시판 관리</a></td>
					</tr>
					
					<tr>
						<td><a style="text-decoration: none;" href="#"
							data-toggle="modal" data-target="#outModal">프로젝트 종료</a></td>

						<div class="modal fade" id="outModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content" style="text-align:center">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">
											<b>프로젝트 탈퇴</b>
										</h4>
									</div>
									<div class="modal-body">
										<H2>
											<b>프로젝트 <span style="color:red">탈퇴</span>를 진행하겠습니까?</b>
										</H2>
										
										<center><button type="button" class="btn btn-danger" id="projOut">예</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">아니오</button></center>
									</div>



								</div>

							</div>
						</div>



					</tr>
				</table>
				<script>
  
  $(function(){

		var proj_Num= ${joinProj};
	    var mem_Email= '${loginUser.mem_Email}';
		
		
	    var dataList = {"proj_Num":proj_Num,"mem_Email":mem_Email};
		
	    
		
		$('#projOut').click(function(){
			
		$.ajax({
			type:'POST',
			url:'projOut',
			data:{"proj_Num":proj_Num,"mem_Email":mem_Email},
			dataType:'JSON',
			 success:function(data){
				 if(data=="1"){
				 location.href="/main/myProject";
				 }
				 else{
					 
					 warningBox("PL은 프로젝트 탈퇴가 불가능합니다.");
					
				
					 
					 
					 
				 }
														}
													})

										})

					})
				</script>
			</div>
		</div>
	</div>


</div>
<hr style="border-color: #ddd; margin-bottom:5px; margin-top:5px;">
<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;" data-toggle="collapse"
					data-parent="#accordion" href="#collapseSix"><img
					src="/resources/img/comments.png"><span>&nbsp;&nbsp;&nbsp;전체
						게시판</span></a>
			</h4>
		</div>
		<div id="collapseSix" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
					<tr>
						<td><a style="text-decoration: none;"
							href="/notice/totalNoticeList">전체
								공지사항</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/SkillSharing/SkillSharingBoardList">기술공유
								게시판</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/freeBoard/freeBoardList">커뮤니티</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/qna/QnAList">QnA 게시판</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
<hr style="border-color: #ddd; margin-bottom:5px; margin-top:5px;">
<!-- 		</div> -->
<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a style="text-decoration: none;" data-toggle="collapse"
					data-parent="#accordion" href="#collapseSeven"><img
					src="/resources/img/color.png"><span>&nbsp;&nbsp;&nbsp;색깔
						바꾸기</span></a>
			</h4>
		</div>
		<div id="collapseSeven" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table" style="margin-bottom: 0px;">
					<tr>
						<td style="padding-left: 20px; padding-top: 0px;">
							<div class="row" id="colors" style="margin: auto;">
								<div class="cc" style="background-color: #3c5574"></div>
								<div class="cc" style="background-color: #303030"></div>
								<div class="cc" style="background-color: #717171"></div>
								<div class="cc" style="background-color: #786153"></div>
								<div class="cc" style="background-color: #ad9f84"></div>
								<div class="cc" style="background-color: #d55c53"></div>
								<div class="cc" style="background-color: #974140"></div>
								<div class="cc" style="background-color: #98b45d"></div>
								<div class="cc" style="background-color: #58aa48"></div>
								<div class="cc" style="background-color: #24945a"></div>
								<div class="cc" style="background-color: #2b9e99"></div>
								<div class="cc" style="background-color: #38716b"></div>
								<div class="cc" style="background-color: #58adcc"></div>
								<div class="cc" style="background-color: #6093cc"></div>
								<div class="cc" style="background-color: #3978bf"></div>
								<div class="cc" style="background-color: #39699a"></div>
								<div class="cc" style="background-color: #21497d"></div>
								<div class="cc" style="background-color: #7278b2"></div>
								<div class="cc" style="background-color: #675d91"></div>
								<div class="cc" style="background-color: #a36bac"></div>
								<div class="cc" style="background-color: #ce7da6"></div>
								<div class="cc" style="background-color: #720001"></div>
								<div class="cc" style="background-color: #297000"></div>
								<div class="cc" style="background-color: #4a1059"></div>
							</div> <script>
	$(function() {
		$('.cc').click(function() {
			var $color = $(this).css('background-color');
			var b = $color.split("(")[1].split(")")[0];
			b = b.split(",");

			var hex = b.map(function(x) {
				x = parseInt(x).toString(16);
				return (x.length == 1) ? "0" + x : x;
			})
			hex = hex.join("");
			var resultColor ="";
			$.ajax({
				url : '/project/color',
				type : 'post',
				data : hex,
				dataType : 'json',
				success : function(result) {
					resultColor=result.proj_Color
					var a = location.href;
					if (a.indexOf("otherProject") == -1) {
						$('#myProjectList').animate({
							backgroundColor :resultColor
						}, 'slow');
					}
					
					$('#navbar').animate({
						backgroundColor :resultColor
					}, 'slow');
					$('#navbar2').animate({
						backgroundColor : resultColor
					}, 'slow');
					$('#myProjectList').animate({
						backgroundColor :resultColor
					}, 'slow');
					$('#otherProjectList').animate({
						backgroundColor : resultColor,
						'filter' : 'brightness(125%)'
					}, 'slow');
					$('#navbar2').animate({
						boderBottomColor : resultColor
					}, 'slow');

					$('#droptoggle').click(function() {
						$(this).css({
							backgroundColor : resultColor
						})
					})
					$('#droptoggle').animate({
						backgroundColor : resultColor
					}, 'slow');

					$('#alarmMenu').animate({
						backgroundColor :resultColor
					}, 'slow');
					$('#alarmMenu').click(function() {
						$(this).css({
							backgroundColor : resultColor
						})
					})
				},
				error : function(result) {
					alert('천천히 시도하세요.');
				}
			})

		})
	})
</script>
						</td>

					</tr>
					<%-- <tr>
						<td><a style="text-decoration: none;"
							href="/SkillSharing/SkillSharingBoardList">기술공유
								게시판</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/freeBoard/freeBoardList">커뮤니티</a></td>
					</tr>
					<tr>
						<td><a style="text-decoration: none;"
							href="/qna/QnAList">QnA 게시판</a></td>
					</tr> --%>
				</table>
			</div>
		</div>
	</div>




</div>
<script>
	/* 	$('#collapseEight').toggle(function(){			
	 $('#content').removeClass('col-md-10').addClass('col-md-11');
	 $('#submenu').removeClass('col-md-2').addClass('col-md-1');
	 })
	
	 */

	 $(function(){
		 $('#boardTotalList').on('click',function(e){
			 var dt = "";
			 $.ajax({
				 dataType:'json',
				 type:'post',
				 url:'/project/boardManagementList',
				 success:function(result){
					 $.each(result,function(i){
						 dt += "<tr><td><a href='/project/pmBoardTotalList?bm_Num="+result[i].bm_Num+"'>"+result[i].bm_Title+"</a></td></tr>";
					 });
					 $('#boardManagementListTable').empty();
					 $('#boardManagementListTable').append(dt);
				 }
			 })
		 });
		 
		 $('#boardManagementBtn').on('click',function(e){
			 e.preventDefault();
			 $.ajax({
				 dataType:'json',
				 type:'post',
				 url:'/project/checkAuthority',
				 success:function(result){
					 if(result){
						 location.href="/project/pmBoardManagementList"
					 }else{
						 alert("권한이 없습니다.");
					 }
				 }
			 })
		 });
	 })
	function decrease() {
		$('#content').removeClass('col-md-10').addClass('col-md-12');
		$('#submenu').removeClass('col-md-2').addClass('col-md-0');
		$('.panel-title>a>span').hide();
		$('.panel-body').hide();
		$('.panel-title').css('text-align', 'center');
		$('#resizingImg').hide();
		$('#area-chart').addClass('area-chart-open');
		
		
		$('#proj_Img').css({
			'webkit-box-shadow': 'none'
		})
		
		
		$('#resizingImgRight').show();
		$('#resizing').one("click", increase);

	}
	/* k-spreadsheet-pane k-top k-left */
	function increase() {
		$('#content').removeClass('col-md-12').addClass('col-md-10');
		$('#submenu').removeClass('col-md-0').addClass('col-md-2');
		$('.panel-body').show();
		
		$('.panel-title>a>span').show();
		$('.panel-title').css({
			'text-align' : 'left'
		})
		$('#proj_Img').css({
			'webkit-box-shadow' : '0 2px 2px 0 rgba(0,0,0,0.14), 0 3px 1px -2px rgba(0,0,0,0.12), 0 1px 5px 0 rgba(0,0,0,0.2)'
		})
		
		$('#area-chart').removeClass('area-chart-open');
		
		
		$('#resizingImgRight').hide();
		$('#resizingImg').show();
		$('#resizing').one("click", decrease);

	}
	$(function() {
		$('#resizing').one('click', decrease);

	})
</script>

<!-- 	</div>
</div> -->
