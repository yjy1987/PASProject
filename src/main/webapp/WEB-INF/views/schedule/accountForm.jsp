<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>


</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('#AccountInsert').click(function() {
				var acc_Date = $('#acc_Date').val();
				var acc_Imp = $('#acc_Imp').val();
				var acc_Exp = $('#acc_Exp').val();
				var acc_Content = $('#acc_Content').val();
				var proj_Num = $('#proj_Num').val();

				var dataList = {
					'acc_Date' : acc_Date,
					'acc_Imp' : acc_Imp,
					'acc_Exp' : acc_Exp,
					'acc_Content' : acc_Content,
					'proj_Num' : proj_Num
					
				};
				$.ajax({

					type : 'POST',
					url : 'AccountBoardInsert',
					dataType : 'json',
					contentType : 'application/json; charset=UTF-8',
					data : JSON.stringify(dataList),
					success : function(result) {
						
						location.href="AccountBoardList";
					}
				});
			})
			
		

		})
		
		
		
		$(function() {
			$('#AccountUpdate').click(function() {
				var acc_Date = $('#upacc_Date').val();
				var acc_Num = $('#upacc_Num').val();
				var acc_Imp = $('#upacc_Imp').val();
				var acc_Exp = $('#upacc_Exp').val();
				var acc_Content = $('#upacc_Content').val();
				var proj_Num = $('#upproj_Num').val();

				var dataList = {
						
				    'acc_Num' : acc_Num,
					'acc_Date' : acc_Date,
					'acc_Imp' : acc_Imp,
					'acc_Exp' : acc_Exp,
					'acc_Content' : acc_Content,
					'proj_Num' : proj_Num
				};
				$.ajax({

					type : 'POST',
					url : 'AccountBoardUpdate',
					dataType : 'json',
					contentType : 'application/json; charset=UTF-8',
					data : JSON.stringify(dataList),
					success : function(result) {
						
						location.href="AccountBoardList";
					}
				});
			})
			
		

		})
		
		
		$(function() {
			$('#AccountDelete').click(function() {
				var acc_Date = $('#upacc_Date').val();
				var acc_Num = $('#upacc_Num').val();
				var acc_Imp = $('#upacc_Imp').val();
				var acc_Exp = $('#upacc_Exp').val();
				var acc_Content = $('#upacc_Content').val();
				var proj_Num = $('#upproj_Num').val();

				var dataList = {
						
				    'acc_Num' : acc_Num,
					'acc_Date' : acc_Date,
					'acc_Imp' : acc_Imp,
					'acc_Exp' : acc_Exp,
					'acc_Content' : acc_Content,
					'proj_Num' : proj_Num
				};
				$.ajax({

					type : 'POST',
					url : 'AccountBoardDelete',
					dataType : 'json',
					contentType : 'application/json; charset=UTF-8',
					data : JSON.stringify(dataList),
					success : function(result) {
						
						location.href="AccountBoardList";
					}
				});
			})
			
		

		})
		
		


/*    $(document).ready(function(){
	 
	   var Imp = parseInt(${sumImp});
	   var Exp = parseInt(${sumExp});
	   
	   var total = Imp-Exp;
	   
	   
   }) */
   
   function show(acc_Num){
			
			
			$(function() {	
			
			var datalist = {'acc_Num':acc_Num}
	   $.ajax({
			type :'POST',
			url : 'activeModal',
			dataType : 'json',
			contentType : 'application/json; charset=UTF-8',
			data : JSON.stringify(datalist),
			success : function(data){
				var d = new Date(data.acc_Date);
				var today_date =
				    d.getFullYear()+"-"+("0" + (d.getMonth() + 1)).slice(-2)+"-"+("0" + d.getDate()).slice(-2);
				$('#upproj_Num').val(data.proj_Num);
				$("#upacc_Num").val(data.acc_Num);
				$("#upacc_Date").val(today_date);
				$("#upacc_Imp").val(data.acc_Imp);
				$("#upacc_Exp").val(data.acc_Exp);
				$("#upacc_Content").val(data.acc_Content); 
				$('#modalAccount').modal('show');   

				 
			}
		  
		   
		   
		   
		   
	   })
			})
	   
	   
	   
	   
   }
		
		$(function(){
			
			$('#selectDate').change(function(){
				
				var selectedText = $("#selectDate").val();
				 $('#upacc_Date').val(selectedText);
				
				
			})
			
			
		})

	


		
	</script>

<script>
			$(function(){
				
				function numberWithCommas(x) {
				    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				}
				var a = $('#sumImp').text();
				var aa = numberWithCommas(a);
				var b = $('#sumExp').text();
				var bb = numberWithCommas(b);
				var c = $('#sum').text();
				var cc = numberWithCommas(c);
				
				$('#sumImp').text(aa);
				$('#sumExp').text(bb);
				$('#sum').text(cc);
				
			})
			
			</script>
			
	<div class="col-md-10" id="content" style="padding-left:30px;padding-right:30px;">
		<h3 class="page-header"
			style="    margin-left: -20px;PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><img
					src="/resources/img/piggy-bank.png">&nbsp;
			프로젝트 회계
		</h3>
		
		<jsp:include page="test.jsp"></jsp:include>
			<table class="table" style="width:600px;">
			<caption>1. 총 수입/지출 테이블</caption>
			<tr>
			<td >총 수입</td>
			
			<td>총 지출</td>
		
			<td>총 잔액</td>
			</tr>
			<tr>
			<td id="sumImp">${sumImp}원</td>
			
			<td id="sumExp">${sumExp}원</td>
		
			<td id="sum">${Sum }원</td>
			</tr>
			
			</table>
			
				
			<button type="button" class="btn btn-default pull-right" data-toggle="modal"
				data-target="#myModal">등록하기</button>
				
				
				
			<table class="table">
			
			<caption>2. 일자별 수입/지출 테이블
			
			</caption>
				<tr>
					<th class="text-center">날짜</th>
					<th class=" text-center">수입</th>
					<th class="text-center">지출</th>
					<th class="text-center">내용</th>
					<th class="text-center">총합</th>

				</tr>
				<c:forEach var="AccountBoardList" items="${AccountBoardList }">
					<tr>
						<td class="text-center">
						<button type="button"  class="btn btn-default" onclick="show(${AccountBoardList.acc_Num})">
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${AccountBoardList.acc_Date}" /></button></td>
						<td class="text-center"><b>${AccountBoardList.acc_Imp }</b></td>
						<td class="text-center"><b>${AccountBoardList.acc_Exp }</b></td>
						<td class="text-center"><b>${AccountBoardList.acc_Content }</b></td>
						<td class="text-center"><b>${AccountBoardList.acc_Total }</b></td>

					</tr>
				</c:forEach>
			<%-- 	<tr>
					<td colspan="5" align="center"><c:if
							test="${paging.finalPageNo>0}">
							<c:set value="${paging.prevPageNo}" var="prevPageNo" />
							<c:set value="${paging.finalPageNo}" var="finalPageNo" />

							<c:if test="${paging.pageNo>prevPageNo}">
								<a href="noticeList?page=${prevPageNo}">[이전]</a>
							</c:if>
							<c:forEach begin="1" end="${paging.finalPageNo}" var="i"
								varStatus="status">
								<a href="noticeList?page=${i}">[${i}]</a>
							</c:forEach>
							<c:if test="${paging.pageNo<finalPageNo}">
								<a href="noticeList?page=${finalPageNo}">[다음]</a>
							</c:if>
						</c:if></td>
				</tr> --%>
			</table>
			
			<!-- Modal -->
							<div class="modal fade" id="modalAccount"
		    						role="dialog">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">회계 정보</h4>
										</div>
										<div class="modal-body">
										<div class="row">
										<div class="col-md-12">
										<div id="bubble" style="height: auto; padding-left: 30px;">
				                       <div class="row">
				                       <div id="1">
						              
											<input type="hidden" id="upacc_Num"><br>
										    <input type="hidden" id="upproj_Num"> <br>
											
											<div class="form-group">
								<label class="col-md-4 control-label">날짜</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-time"></i></span> <input type="text" 
											id ="upacc_Date" class="form-control" type="text" ><input type="date" id="selectDate">
									</div>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">수입</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-plus"></i></span> <input
											id="upacc_Imp"
											class="form-control" type="text" >
									</div>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">지출</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-minus"></i></span> <input
											id="upacc_Exp"
											class="form-control" type="text" >
									</div>
								</div>
							</div>
							
							<div class="form-group" style=" display: inline-block">
						<label for="textArea" class="col-lg-2 control-label">내용</label>
						<div class="col-lg-8">
							<textarea class="form-control" rows="9" id="upacc_Content"
								name="upacc_Content" ></textarea>
						</div>
					</div><br>
							
					
											
										

										</div>
										<div class="modal-footer">
											<input type="button"  class="btn btn-default pull-right"  style="margin-left: 5px;"
												data-dismiss="modal" id="AccountUpdate" value="회계 수정">
											<input type="button" 
												data-dismiss="modal"  class="btn btn-danger" id="AccountDelete" value="회계삭제">
											<button type="button" class="btn btn-default pull-right"
												data-dismiss="modal">Close</button>
										</div>
										
										
										
										</div>
										
										</div>
										</div>
										</div>
										</div>
									</div>

								</div>
							</div>
		
			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">회계 등록</h4>
						</div>
						<div class="modal-body">
						
						<div class="row">
										<div class="col-md-12">
										<div id="bubble" style="height: auto; padding-left: 30px;">
				                       <div class="row">
				                       <div id="1">
						              <form class="form-horizontal" id="update_form" >
						
						
						
						
							
							 <input type="hidden" id="proj_Num" value="${joinProj }" readonly><br>
							 
							 <div class="form-group">
								<label class="col-md-4 control-label">날짜</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-envelope"></i></span> <input
											id ="acc_Date" class="form-control" type="date" >
									</div>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">수입</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-envelope"></i></span> <input
											id="acc_Imp"
											class="form-control" type="text"  value=0>
									</div>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">지출</label>
								<div class="col-md-6  inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-envelope"></i></span> <input
											id="acc_Exp"
											class="form-control" type="text"  value=0>
									</div>
								</div>
							</div>
						
							  내용:<textarea id="acc_Content"></textarea>
							  
							  </form>
							  </div>
							  </div>
							  </div>
							  </div>
							  </div>
							  

						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								id="AccountInsert" value="회계 등록">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>







		
	</div>



</body>
</html>
