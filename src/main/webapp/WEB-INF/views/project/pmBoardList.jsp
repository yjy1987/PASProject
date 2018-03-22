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
	<div class="col-md-8"  id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX"><img
					src="/resources/img/news.png">&nbsp;&nbsp;뉴스 피드 <small>자유롭게 이야기하세요</small>
		</h3>

		<div class="col-md-12" >
			<div id="pbd"
				style="padding: 10px; background-color: white; border: 1px solid #ddd; border-radius: 2px; margin-bottom: 20px;">
				<form name="frm" method="post" action="pmBoardInsert">
					<table>
						<tr>
							<td><script>
							$(function(){
								 $(document).on('input', 'textarea', function () {
								        $(this).outerHeight(38).outerHeight(this.scrollHeight); // 38 or '1em' -min-height
								    });
							});

							</script> <textarea class="pull-right" rows="1" id="textArea"
									name="pb_Content" placeholder="팀원들에게 남길말을 적어주세요"
									style="width:690px; padding-left: 15px; padding-right: 15px; font-size: 22px; resize: none; border: none; overflow: auto; outline: none; -webkit-box-shadow: none; -moz-box-shadow: none; box-shadow: none;"></textarea></td>
						</tr>
						<tr>
							<td>
								<hr style="color: #ddd; margin-top: 10px; margin-bottom: 10px;">
							</td>
						</tr>

						<tr>
							<td><button class="btn btn-default pull-right" type="submit">글올리기</button></td>
						</tr>

					</table>
				</form>

			</div>


			<div style="margin-top: 20px;">
				<c:forEach var="pbList" items="${pbList}">
					<div style="margin-bottom: 20px;">
						<div id="pbd"
							style="padding: 10px; background-color: white; border: 1px solid #ddd; border-bottom: 0px; border-top-left-radius: 2px; border-top-right-radius: 2px;">

							<table class="col-md-12">
								<tr>
									<td style="width: 70px;" rowspan="2"><img
										src="<%=request.getContextPath() %>/resources/upload/${pbList.mem_Img}"
										id="thumbnail" alt="my image"
										style="border-radius: 0px; width: 60px; height: 60px;" /></td>

									<td>${pbList.mem_Name }</td>
									<td class="text-right"><div class="dropdown">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown"
												role="button" id="${pbList.mem_Email }A"> <span
												class="glyphicon glyphicon-chevron-down"></span></a>
											<c:if
												test="${sessionScope.loginUser.mem_Email == pbList.mem_Email }">
												<ul class="dropdown-menu">
													<li><a href="#" class="img-responsive"
														data-toggle="modal"
														data-target="#${pbList.pb_Article_Num }modal"
														data-keyboard="false" data-backdrop="static">글 수정하기</a></li>
													<li><a
														href="deleteProjectBoard?pb_Article_Num=${pbList.pb_Article_Num}">글삭제하기</a></li>
												</ul>
											</c:if>
										</div></td>
								</tr>
								<tr>
									<td><fmt:formatDate value="${pbList.pb_Wt_Date}"
											pattern="yyyy-MM-dd" /></td>
									<td></td>


								</tr>
								<tr>
									<td
										style="font-size: 22px; padding-top: 20px; padding-bottom: 20px;"
										colspan="3">${pbList.pb_Content}</td>

								</tr>

							</table>
							<div style="clear: both"></div>

						</div>

						<div id="pbd"
							style="padding: 10px; background-color: #f5f5f5; border: 1px solid #ddd; border-bottom-left-radius: 2px; border-bottom-right-radius: 2px;">
							<%-- <div id="${pbList.pb_Article_Num}"></div> --%>
							<table>
								<tr>
									<td colspan="2"><div id="${pbList.pb_Article_Num }"></div></td>
									<td></td>

								</tr>
								<tr>
									<td style="padding-top:5px; padding-right: 5px"><img
										src="<%=request.getContextPath() %>/resources/upload/${loginUser.mem_Img}"
										id="thumbnail" alt="my image"
										style="border-radius: 0px; width: 30px; height: 30px;" /></td>
									<td class="col-md-12"
										style="padding-top:5px; padding-left: 0px; padding-right: 0px;">
										<div class="form-inline">
											
											<input class="form-control" style="min-width: 100%;"
												placeholder="댓글을 입력하세요" name="pb_Reply_Content"
												id="${pbList.pb_Article_Num}pb_Reply_Content" />
											<%-- <input type="button"
												class="btn btn-default ${pbList.pb_Article_Num }"
												id="addReply" value="댓글달기"
												onclick="javascript:reply(${pbList.pb_Article_Num})" /> --%>
										</div>
									</td>

								</tr>

							</table>


						</div>

						<!-- 수정 모달 -->
						<div class="modal fade" id="${pbList.pb_Article_Num }modal"
							role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title"></h4>
										<h1>${pbList.pb_Article_Num}번게시글</h1>
									</div>
									<div class="modal-body" id="${pbList.pb_Article_Num }body">
										<textarea rows="4" cols="70"
											style="resize: none; border: none; overflow: auto; outline: none; -webkit-box-shadow: none; -moz-box-shadow: none; box-shadow: none;"
											id="${pbList.pb_Article_Num }pb_Content">${pbList.pb_Content}</textarea>
									</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-default" value="수정완료"
											onclick="javascript:updatePb(${pbList.pb_Article_Num })" />
										<button type="button" class="btn btn-default"
											data-dismiss="modal">취소</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>



		<script>
			
			$(document).ready(function(){
				
					 $.ajax({
						url:'selectProjectBoardReply',
						contentType:'application/json',
						dataType:'json',
						type:'POST',
						success:function(data){
							var login_Email ="";
							login_Email= "${sessionScope.loginUser.mem_Email}";
							
							var d ="";
							$.each(data,function(i){
								$.each(data[i],function(j){
									var dt="";
									
									if(login_Email==data[i][j].pb_Reply_Mem){
										dt ='<table><tr><td><img style="padding-top:5px; padding-right:5px; width: 30px; height: 30px;" src="/resources/upload/'+data[i][j].pb_Reply_Mem_Img+'" ></td><td style="padding-right:5px; color:#337ab7; font-weight:bold">'
										+data[i][j].pb_Reply_Mem_Name +'</td><td>'+ data[i][j].pb_Reply_Content+' &nbsp; &nbsp;  <a href="#" > <span  style="color:#545454; font-weight:bold; font-size:12px;">수정</span></a> / <a href="deleteProjectBoardReply?pb_Reply_Num='+data[i][j].pb_Reply_Num+'" > <span style="font-weight:bold; color:#545454; font-size:12px;">삭제 </span></a></td></tr><table>';
									}else{
										dt ='<table><tr><td><img style="padding-top:5px; padding-right:5px; width: 30px; height: 30px;" src="/resources/upload/'+data[i][j].pb_Reply_Mem_Img+'" ></td><td style="padding-right:5px; color:#337ab7; font-weight:bold">'
										+data[i][j].pb_Reply_Mem_Name +'</td><td>'+ data[i][j].pb_Reply_Content+'     </td></tr><table>';
									}
									
									$('#'+data[i][j].pb_Article_Num).append(dt);
								});
							});
						}
					})
					$('input').focus(function(){
						var keyEvent=$(this).attr('id')
						$('#'+keyEvent).keyup(function(e){
							if((e.keyCode || e.which) == 13) { 
								 e.preventDefault();   
								var textareaNumber= keyEvent.replace(/[^0-9]/g,"");
								 reply(textareaNumber);
								 e.preventDefault();   
							}
						})						
					});
					 
				
					 
			})
			
				function reply(pb_Article_Num){
					
					var Article_Num = pb_Article_Num;
					var pb_Reply_Content = $('#'+Article_Num+'pb_Reply_Content').val();
					var dataList = {'pb_Reply_Content':pb_Reply_Content,'pb_Article_Num':Article_Num};
					var login_Email ="";
					login_Email= "${sessionScope.loginUser.mem_Email}";
					$.ajax({
						url:'insertProjectBoardReply',
						data: JSON.stringify(dataList),
						contentType:'application/json',
						dataType:'json',
						type:'post',
						success:function(data){
							var dt = "";
							$.each(data,function(i){
								if(login_Email==data[i].pb_Reply_Mem){
									dt +='<table><tr><td style="padding-top:5px; padding-right:5px;"><img style="width: 30px; height: 30px;" src="/resources/upload/'+data[i].pb_Reply_Mem_Img+'" ></td><td style="padding-right:5px; color:#337ab7; font-weight:bold">'
									+data[i].pb_Reply_Mem_Name +'</td><td>'+ data[i].pb_Reply_Content+'  &nbsp; &nbsp;     <a href="#" ><span  style="color:#545454; font-weight:bold; font-size:12px;">수정</span></a> / <a href="deleteProjectBoardReply?pb_Reply_Num='+data[i].pb_Reply_Num+'" ><span  style="color:#545454; font-weight:bold; font-size:12px;">삭제</span></a> </td></tr><table>';
								}else{
									dt +='<table><tr><td style="padding-top:5px; padding-right:5px;"><img style="width: 30px; height: 30px;" src="/resources/upload/'+data[i].pb_Reply_Mem_Img+'" ></td><td style="padding-right:5px; color:#337ab7; font-weight:bold">'
									+data[i].pb_Reply_Mem_Name +'</td><td>'+ data[i].pb_Reply_Content+'</td></tr><table>';
								}
								
							});
							
							$('#'+Article_Num).empty();
							$('#'+Article_Num).append(dt);
							$('#'+Article_Num+'pb_Reply_Content').val("");
						}
					});
				}
				
			function updatePb(Article_Num){
				var pb_Article_Num = Article_Num;
				var pb_Content = $('#'+pb_Article_Num+'pb_Content').val();
				var dataList = {'pb_Article_Num':pb_Article_Num,'pb_Content':pb_Content};
				$.ajax({
					url:'pmBoardUpdate',
					contentType:'application/json',
					dataType:'json',
					type:'post',
					data:JSON.stringify(dataList),
					success:function(){
						location.reload();
					},error:function(){
						alert('에러');
					},
					done:function(){
						$('#'+pb_Article_Num+'Number').focus();
					}
				})
			}

				$(".anser-write input{type=submit}").click(addAnswer);
				function addAnswer(e) {
					e.preventDefault();
					console.log("click!");

					var queryString = $(".anser-write").serialize();
					console.log("query : " + queryString);
				}

				function go_myProjectList() {
					location.href = "pmBoardMyProjectList";
				}
			</script>


	</div>

</body>
</html>
