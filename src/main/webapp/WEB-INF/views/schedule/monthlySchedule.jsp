<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
</head>
<body>
	<div class="col-md-10" id="content">

		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			월별 일정 관리<small>&nbsp;&nbsp;&nbsp;<a href="#" rel="popover"
				data-popover-content="#myPopover">참여인원 보기</a></small>
		</h3>

		<div id="myPopover" class="hide" style="width:170px">         
			<ul> 
				<c:forEach items="${memPositionViewVo}" var="memPositionView" varStatus="status">
					<li style="list-style: none; margin-left: -5%; margin-bottom: 8%"><img
						src="<%=request.getContextPath() %>/resources/upload/${memPositionView.mem_Img}"
						onerror="this.src='/resources/upload/no.png'"
						id="thumbnail" alt="my image" /> ${memPositionView.mem_Name}
						&nbsp;&nbsp;
						<div class="dropdown" style="display: inline">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
								id="${memPositionView.mem_Email}"> <span
								style="background-color:<c:out value='${memPositionView.pjj_Color}'/>">&nbsp;&nbsp;&nbsp;&nbsp;</span>
							</a>
							<c:if test="${memPosition.position_Num==1}">
								<ul class="dropdown-menu">
									<li>
										<div class="row" id="colorPick" style="margin: auto;">
											<span id="${memPositionView.mem_Email }"
												style="background-color: #3c5574; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #303030; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #717171; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #786153; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #ad9f84; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #d55c53; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #974140; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #98b45d; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #58aa48; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #24945a; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #2b9e99; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #38716b; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #58adcc; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #6093cc; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #3978bf; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #39699a; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #21497d; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #7278b2; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #675d91; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #a36bac; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #ce7da6; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #720001; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #297000; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span id="${memPositionView.mem_Email }"
												style="background-color: #4a1059; cursor: pointer">&nbsp;&nbsp;&nbsp;&nbsp;</span>
										</div>
									</li>
								</ul>
							</c:if>
						</div></li>
				</c:forEach>
			</ul>
		</div>



		<br>
		<div id='calendar'></div>
		<div id="addCalendarModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">close</span>
						</button>
						<h4 id="modalTitle" class="modal-title"></h4>
					</div>
					<div id="modalBody" class="modal-body">
						일정명 : <input type="text" id="title"><br>
						<br> 내용 :<br>
						<textarea rows="5" cols="75" name="description" id="description"></textarea>
						<br>
						<br> 시작 날짜 : <input type="text" id="datePicker1"
							readonly="readonly" class="flatpicker-input active"> ~
						종료 날짜 : <input type="text" id="datePicker2" readonly="readonly">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="addCalendar">등록</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>


		<div id="detailCalendarModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">close</span>
						</button>
						<h4 id="detailModalTitle" class="modal-title"></h4>
					</div>
					<div id="modalBody" class="modal-body">
						<div id="detailMember"></div>
						일정명 : <input type="text" id="detailTitle"><br>
						<br> 내용 :<br>
						<textarea rows="5" cols="75" name="detailDescription"
							id="detailDescription"></textarea>
						<br>
						<br> 시작 날짜 : <input type="text" id="detailDatePicker1"
							readonly="readonly" class="flatpicker-input active"> ~
						종료 날짜 : <input type="text" id="detailDatePicker2"
							readonly="readonly">
					</div>
					<div class="modal-footer" id="detailFooter"></div>
				</div>
			</div>
		</div>



	</div>

	<script>
		$(function() {

			$('[rel="popover"]').popover(
					{
						container : 'body',
						html : true,
						content : function() {
							var clone = $($(this).data('popover-content'))
									.clone(true).removeClass('hide');
							return clone;
						}
					}).click(function(e) {
				e.preventDefault();
			});

			$('#calendar')
					.fullCalendar(
							{
								editable : true,
								eventLimit : true,
								buttonIcons : true,
								themeButtonIcons : {
									prev : 'circle-triangle-w',
									next : 'circle-triangle-e',
									prevYear : 'seek-prev',
									nextYear : 'seek-next'
								},
								header : {
									left : 'prev,next,today',
									center : 'title',
									right : 'month,agendaWeek,agendaDay'
								},
								eventSources : [ {
									url : "calendarList",
									type : 'get',
									textColor : 'white'
								} ],
								dayClick : function(date, jsEvent, view) {
									$('#modalTitle').text("일정 등록");
									$('#datePicker1').val(
											date.format() + ' 12:00');
									$('#datePicker2').val(
											date.format() + ' 12:00');
									$('#addCalendarModal').modal();
								},
								eventClick : function(calEvent, jsEvent, view) {
									var loginUser = '${loginUser.mem_Email}';
									ind = (calEvent.id).lastIndexOf(".")+1;
									id = (calEvent.id).substring(ind);
									var dataList={'id':id};
									$.ajax({
										dataType : 'json',
										contentType : 'application/json',
										url : 'selectDetailCal',
										data : JSON.stringify(dataList),
										type : 'post',
										success : function(data) {
											
											var  a= '<img src="/resources/upload/'+data.mem_Img+'" id="thumbnail" alt="my image"  onerror="src=\'/resources/upload/no.png\'" />&nbsp&nbsp'
											+'&nbsp&nbsp&nbsp<span>'+data.mem_Name+' [ '+data.position_Name+' ] </span>&nbsp&nbsp&nbsp<span style="background-color:'+data.pjj_Color+'">&nbsp;&nbsp;&nbsp;&nbsp;</span><br><br>';
											$('#detailMember').html(a);
										},
										error : function() {
											alert("실패");
										}
									});
									
									$('#detailModalTitle').text("일정 확인");
									$('#detailTitle').val(calEvent.title);
									$('#detailDatePicker1').val(
											moment(calEvent.start).format(
													'YYYY-MM-DD HH:mm'));
									if (calEvent.end != null) {
										$('#detailDatePicker2').val(
												moment(calEvent.end).format(
														'YYYY-MM-DD HH:mm'))
									} else {
										$('#detailDatePicker2').val(
												moment(calEvent.start).format(
														'YYYY-MM-DD HH:mm'));
									}
									var loginUser = '${loginUser.mem_Email}';
									var position = '${memPosition.position_Num}';
									ind = (calEvent.id).lastIndexOf(".")+1;
									id = (calEvent.id).substring(ind);
									if ((calEvent.id).indexOf(loginUser) > -1 || position==1) {
										$('#detailFooter')
												.html(
														'<button type="button" class="btn btn-default" id="updateCalendar">수정</button> <button type="button" class="btn btn-default" id="deleteCalendar">삭제</button>'
																+ '<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>'
																+ '<input type="hidden" value="'+id+ '" id="sc_Num">'
																+ '<input type="hidden" value="'+calEvent.color+'" id="sc_Color">');
									} else {
										$('#detailFooter')
												.html('<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>')
									}
									
									$('#detailDescription').val(
											calEvent.description);
									$('#detailCalendarModal').modal();
								},
								eventDrop : function(event, dayDelta,
										minuteDelta, allDay, revertFunc) {
									var loginUser = '${loginUser.mem_Email}';
									var position = '${memPosition.position_Num}';
									if ((event.id).indexOf(loginUser) > -1|| position==1) {
										var id = (event.id)
												.substring(loginUser.length+1);
										var start = moment(event.start).format(
												'YYYY-MM-DD HH:mm');
										var end;
										if (event.end != null) {
											end = moment(event.end).format(
													'YYYY-MM-DD HH:mm');
										} else {
											end = moment(event.start).format(
													'YYYY-MM-DD HH:mm');
										}
										var description = event.description;
										var title = event.title;
										var color = event.color;
										var dataList = {
											'id' : id,
											'start' : start,
											'end' : end,
											'description' : description,
											'title' : title,
											'color' : color
										};
										$.ajax({
											dataType : 'json',
											contentType : 'application/json',
											url : 'updateCal',
											data : JSON.stringify(dataList),
											type : 'post',
											success : function(data) {
												$('#calendar').fullCalendar(
														'refetchEvents');
											},
											error : function() {
												alert("실패");
											}
										})
									} else {
										$('#calendar').fullCalendar(
												'refetchEvents');
									}
								}

							});

			$('#datePicker1').change(function() {
				$('#datePicker2').val($('#datePicker1').val());
			});

			flatpickr(
					"#datePicker1,#datePicker2,#detailDatePicker1,#detailDatePicker2",
					{
						enableTime : true,
						altFormat : "F j, Y h:i K",

					})
			$('#addCalendar').on('click', function() {
				var start = $('#datePicker1').val();
				var end = $('#datePicker2').val();
				var title = $('#title').val();
				var description = $('#description').val();
				var dataList = {
					'start' : start,
					'end' : end,
					'title' : title,
					'description' : description
				};
				$.ajax({
					dataType : 'json',
					contentType : 'application/json',
					url : 'addCal',
					data : JSON.stringify(dataList),
					type : 'post',
					success : function(data) {
						$('#calendar').fullCalendar('refetchEvents');

						$("#addCalendarModal").modal("hide");
						$("#title").val("");
						$("#datePicker1").val("");
						$("#datePicker2").val("");
						$("#description").val("");
					}
				})
			});

			$(document).on(
					'click',
					'#updateCalendar',
					function() {
						var start = $('#detailDatePicker1').val();
						var end = $('#detailDatePicker2').val();
						var title = $('#detailTitle').val();
						var id = $('#sc_Num').val();
						var color = $('#sc_Color').val();

						var calEvent = new Object();
						calEvent = $('#event').val();

						var description = $('#detailDescription').val();
						var dataList = {
							'start' : start,
							'end' : end,
							'title' : title,
							'description' : description,
							'id' : id,
							'color' : color
						};
						$.ajax({
							dataType : 'json',
							contentType : 'application/json',
							url : 'updateCal',
							data : JSON.stringify(dataList),
							type : 'post',
							success : function(data) {
								var item = $("#calendar").fullCalendar(
										'clientEvents', data.id);
								/* calEvent.id = data.id; */
								item.start = data.start;
								item.title = data.title;
								item.end = data.end;
								item.color = data.color;
								item.description = data.description;
								$('#calendar').fullCalendar('refetchEvents');  
								$('#detailCalendarModal').modal("hide");
								$('#detailDatePicker1').val("");
								$('#detailDatePicker2').val("");
								$('#detailDescription').val("");
							}
						})
					});

			$(document).on('click', '#deleteCalendar', function() {
				var sc_Num = $('#sc_Num').val();
				var dataList = {
					"sc_Num" : sc_Num
				};
				$.ajax({
					dataType : 'json',
					contentType : 'application/json',
					url : 'deleteCal',
					data : JSON.stringify(dataList),
					type : 'post',
					success : function(data) {
						if (data) {
							$('#calendar').fullCalendar('refetchEvents');
							$('#detailCalendarModal').modal("hide");
							$('#detailDatePicker1').val("");
							$('#detailDatePicker2').val("");
							$('#detailDescription').val("");
						} else {
							alert("실패");
						}
					}
				})
			});

			$('#colorPick span').on(
					'click',
					function() {

						var color = $(this).css('background-color');
						var b = color.split("(")[1].split(")")[0];
						b = b.split(",");
						var mem_Email = $(this).attr('id');

						var hex = b.map(function(x) {
							x = parseInt(x).toString(16);
							return (x.length == 1) ? "0" + x : x;
						})
						hex = '#' + hex.join("");

						$("a[id='" + mem_Email + "'] > span").css(
								'background-color', hex);

						var dataList = {
							'mem_Email' : mem_Email,
							'pjj_Color' : hex
						}
						$.ajax({
							dataType : 'json',
							contentType : 'application/json',
							url : 'updateCalColor',
							data : JSON.stringify(dataList),
							type : 'post',
							success : function(data) {
								$('#calendar').fullCalendar('refetchEvents');
							}
						});
					});
		})
	</script>
</body>
</html>
