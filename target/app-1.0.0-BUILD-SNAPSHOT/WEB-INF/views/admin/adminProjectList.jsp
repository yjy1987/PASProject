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
<style>
input[type=button]{
vertical-align:middle;
}
</style>
<body>
	 <div class="container">
	<form>
	<strong><font size="5">프로젝트 관리</font></strong>
			<font >프로젝트명 : <input type="text" name="proj_Name" style="width:15%;"/>&nbsp; 
			<input type="button" onclick="searchProj(this.form);" value="검색" ></font>
	</form>


	<table style="text-align:center;" class="table table-hover">
		<tr>
			<th style="text-align:center; vertical-align:middle !important;"><input type="button" value="삭제" onclick="go_delete()"style="margin-top: 0px; margin-bottom: 0px;"></th>
			<th style="text-align:center; vertical-align:middle !important;">프로젝트이름</th>
			<th style="text-align:center; vertical-align:middle !important;">프로젝트팀이름</th>
			<th style="text-align:center; vertical-align:middle !important;">프로젝트내용</th>
			<th style="text-align:center; vertical-align:middle !important;">생성자이메일</th>
			
		</tr>
		<c:forEach items="${projectList }" var="projectVo"
			begin="${paging.beginNo}" end="${paging.endNo}" varStatus="status">
			<tr>
				<td style="text-align: center;"><input name= "check" type="checkbox" value='${projectVo.proj_Num}'></td>
				<td style="text-align: center;"><a href="#" data-toggle="modal"
					onclick="goModal('${projectVo.proj_Num}','${status.index}')"
					data-target="#${status.index }" data-keyboard="false"
					data-backdrop="static">${projectVo.proj_Name} </a> <!-- Modal -->
					<div class="modal fade" id="${status.index }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									${projectVo.proj_Name } 프로젝트의 참여 멤버
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
				<td style="text-align: center;">${projectVo.proj_Team}</td>
				<td style="text-align: center;">${projectVo.proj_Content}</td>
				<td style="text-align: center;">${projectVo.mem_Email }</td>	
			</tr>
		</c:forEach>
	</table>
		
		
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
		location.href = "projectDelete?proj_Num="+value;
	}
	
	function go_Home(){
			location.href = "/index";

	}
	
	
	function go_delete(proj_Num) {		
// 		$("input[name=mem_Email]").val();
		var ck = "";
		$(":checkbox[name='check']:checked").each(function(i,ve){
			ck +=ve.value+",";
		});
		alert('삭제가 완료되었습니다.');
			 
		location.href = "projectDelete?proj_Num="+ck;
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
	
	function searchProj(form) {
		form.action="searchProj";
		form.method="get";
		form.target="_self";
		form.submit();
	};
	
	
	
	function goModal(proj_Num,index){
		var data = {'proj_Num':proj_Num};
		$.ajax({
			url:'mdlValue3',
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
					var date = new Date(data[i].pjj_Final_In_Time)
					var year = date.getFullYear();
					var month = (1 + date.getMonth());
					month = month >= 10 ? month : '0'+ month;
					var day = date.getDate();
					day = day >= 10 ? day : '0' + day;
					var fullD = year + '.' + month + '.'+ day;
					if(data[i].position_Num=="1"){var position = "PL";}
					else if(data[i].position_Num=="2"){var position = "PM";}
					else if(data[i].position_Num=="3"){var position = "TA";}
					else if(data[i].position_Num=="4"){var position = "AA";}
					else if(data[i].position_Num=="5"){var position = "DA";}
					else if(data[i].position_Num=="6"){var position = "BA";}
					else if(data[i].position_Num=="7"){var position = "UA";}
					else if(data[i].position_Num=="8"){var position = "PE";}
					else if(data[i].position_Num=="9"){var position = "NotRole";}
					else{var position = "NotMember";}
					tt += '<div> 멤버 이메일 : '+data[i].mem_Email+'&nbsp;&nbsp;&nbsp;&nbsp;직책: '
					+position+'&nbsp;&nbsp;&nbsp;&nbsp;마지막 접속 시간 : '+fullD+'<hr color=\'red\'></div>'
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