<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<style>
td{

}
</style>

<div class="container">
	<form>
	<strong><font size="5" style="">회원 관리</font></strong>
			<font style="">이메일 : <input type="text" name="mem_Email" style="width:15%;"/>&nbsp; 
			<input type="button" onclick="searchEmail(this.form);" value="이메일검색" style="width:5%;"></font>
	</form>


	<table style="" class="table table-hover" style="text-align:center;">
		<tr>
			<th style="text-align:center;vertical-align:middle !important;"><input type="button" value="제명" onclick="go_delete()" style="margin-top: 0px; margin-bottom: 0px;"></th>
			<th style="text-align:center;vertical-align:middle !important;">회원이메일</th>
			<th style="text-align:center;vertical-align:middle !important;">회원이름</th>
			<th style="text-align:center;vertical-align:middle !important;">회원전화번호</th>
			<th style="text-align:center;vertical-align:middle !important;">가입일자</th>
			<th style="text-align:center;vertical-align:middle !important;">회원탈퇴여부</th>
		</tr>
		<c:forEach items="${memberList }" var="memberVo"
			begin="${paging.beginNo}" end="${paging.endNo}" varStatus="status">
			<tr>
				<td style="text-align: center;"><input name= "check" type="checkbox" value='${memberVo.mem_Email}'></td>
				<td style="text-align: center;"><a href="#" data-toggle="modal"
					onclick="goModal('${memberVo.mem_Email}','${status.index}')"
					data-target="#${status.index }" data-keyboard="false"
					data-backdrop="static">${memberVo.mem_Email} </a> <!-- Modal -->
					<div class="modal fade" id="${status.index }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									${memberVo.mem_Name } 님의 참여 프로젝트
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title"></h4>
								</div>
								<div class="modal-body" id="${status.index}body"></div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div></td> 
				<td style="text-align: center;">${memberVo.mem_Name}</td>
				<td style="text-align: center;">${memberVo.mem_Phone }</td>
				<td style="text-align: center;">${memberVo.mem_Join_Date }</td>
				<td style="text-align: center;"><select id="quitCheck" name="quitCheck" 
				 style="width:70px; margin-top: 0px; margin-bottom: 0px;" onchange="change_go(this.value,'${memberVo.mem_Email}')">
						<option value="y"
							<c:if test="${memberVo.quit_Check=='y'}">selected="selected"</c:if>
						>&nbsp;&nbsp;&nbsp;YES</option>
						<option value="n"
							<c:if test="${memberVo.quit_Check=='n'}">selected="selected"</c:if> 
						>&nbsp;&nbsp;&nbsp;NO</option>
				</select></td>
	
			</tr>
			
		</c:forEach>
	</table>
	<%-- <div class="col-md-12 text-center">
				<c:if test="${paging.finalPageNo>0 }">
					<c:set value="${paging.firstPageNo}" var="firstPageNo" />
					<c:set value="${paging.finalPageNo}" var="finalPageNo" />
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center" style="">

							<li class="page-item"><a class="page-link"
								href="memberList?page=${firstPageNo}" tabindex="-1">첫 페이지</a></li>


							<c:forEach begin="1" end="${paging.finalPageNo}" var="i"
								varStatus="status">
										<li class="page-item" id="number"><a
											class="page-link" href="memberList?page=${i}">${i}</a></li>
									
							</c:forEach>
							<li class="page-item"><a class="page-link"
								href="memberList?page=${finalPageNo}">끝 페이지</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
			<br><br> --%>
				<script>
										$('li').each(function(){
										    if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
										    {
										    $(this).addClass('active').siblings().removeClass('active');
										    }
										});
										</script>
	<script>
	
	function check_go(value){
		location.href = "memberDelete?mem_Email="+value;
	}
	
	function go_Home(){
			location.href = "/index";

	}
	
	function change_go(value,mem_Email){
		
		location.href = "memberQuitCheck?mem_Email="+mem_Email+"&quit_Check="+value;
	}
	
	function go_delete(mem_Email) {		
// 		$("input[name=mem_Email]").val();
		var ck = "";
		$(":checkbox[name='check']:checked").each(function(i,ve){
			ck +=ve.value+",";
		});
		alert('삭제가 완료되었습니다.');
			 
		location.href = "memberDelete?mem_Email="+ck;
	}
	
	function go_cart_delete() {
		var count = 0;
		for (var i = 0; i < document.formm.cseq.length; i++) {
			if (document.formm.cseq[i].checked == true) {
				count++;
			}
		}
		if (count == 0) {
			alert("삭제할 항목을 선택해 주세요.");

		} else {
			document.formm.action = "cartDelete.do";
			document.formm.submit();
		}
	}
	
	function searchEmail(form) {
		form.action="searchMemEmail";
		form.method="get";
		form.target="_self";
		form.submit();
	};
	function goModal(mem_Email,index){
		var data = {'mem_Email':mem_Email};
		$.ajax({
			url:'mdlValue2',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'json',
			type:'post',
			success:function(data){
				var tt="";
				if(data==null || data==""){
					tt+='<div> 참여 프로젝트가 없습니다.</div>'
				}
				$.each(data,function(i){
					tt += '<div> 프로젝트번호 : '+data[i].proj_Num+'&nbsp&nbsp&nbsp&nbsp프로젝트이름 : '+data[i].proj_Name+'<hr color=\'red\'></div>'
				})
				$("#"+index+"body").empty();
				$("#"+index+"body").append(tt);
				
			}
		});
	}
	
	
	
	
	
	
	</script>
	</div>
</body>

</html>