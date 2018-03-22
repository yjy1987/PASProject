<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<body>
	<!-- 	<script src="http://momentjs.com/downloads/moment-with-locales.min.js"></script> -->
	<style>
.tableContents {
	text-overflow: ellipsis;
}
#content > table > tbody > tr > td > ul > li{
word-break: break-all;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
	table-layout: fixed;
	display: block;
}

.weeklychk>tbody>tr>th{
padding:10px !important;
}
</style>

	<div class="col-md-10" id="content">

		<h2 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			주간 일정 체크
		</h2>
		<script>
			
		</script>
		<table class="table table-bordered col-md-7"
			style="table-layout: fixed;">
			<thead>
				<tr>
					<c:forEach items="${weekly_dateList}" var="ScheduleCalendarVo">
						<th class="col-md-1 day">${ScheduleCalendarVo.dy}
							[${ScheduleCalendarVo.dt}] 
						</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "월요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Monday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "월요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Monday_End">${scheduleCalendarVo.sc_Title}</a></li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "화요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Tuesday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "화요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Tuesday_End">${scheduleCalendarVo.sc_Title}</a>
									</li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "수요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Wednesday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "수요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Wednesday_End">${scheduleCalendarVo.sc_Title}</a>
									</li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "목요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Thursday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "목요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Thursday_End">${scheduleCalendarVo.sc_Title}</a>
									</li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "금요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Friday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "금요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Friday_End">${scheduleCalendarVo.sc_Title}</a></li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "토요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Thursday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "토요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Thursday_End">${scheduleCalendarVo.sc_Title}</a>
									</li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
					<td class="tableContents">
						<ul style="font-size: 12px;">
							<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
								<c:if test='${scheduleCalendarVo.start_Day eq "일요일" }'>
									<li><span style="color: #425bd6; font-weight: bold;">시작&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Friday_Start">${scheduleCalendarVo.sc_Title }</a>
									</li>
								</c:if>
							</c:forEach>
							<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">

								<c:if test='${scheduleCalendarVo.end_Day eq "일요일" }'>
									<li><span style="color: #fd7037; font-weight: bold;">마감&nbsp;</span><a
										style="color: black; text-decoration: none;"
										href="javascript:void(0);" data-toggle="modal"
										data-target="#Friday_End">${scheduleCalendarVo.sc_Title}</a></li>
								</c:if>

							</c:forEach>
						</ul>

					</td>
				</tr>
			</tbody>
		</table>


		<br> <Br>

		<!-- 월요일 시작일감 모달 -->
		<div class="modal fade" id="Monday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>

					<div class="modal-body">
						<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
							<c:choose>
								<c:when test='${scheduleCalendarVo.start_Day eq "월요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
										pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
										pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
									<br>
								</c:when>
							</c:choose>
						</c:forEach>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- 화요일 시작일감 모달 -->
		<div class="modal fade" id="Tuesday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">tuesday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "화요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- 수요일 시작일감 모달 -->
		<div class="modal fade" id="Wednesday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">wednesday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "수요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- 목요일 시작일감 모달 -->
		<div class="modal fade" id="Thursday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">thursday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "목요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- 금요일 시작일감 모달 -->
		<div class="modal fade" id="Friday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">friday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "금요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
				<!-- 토요일 시작일감 모달 -->
		<div class="modal fade" id="saturday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">saturday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "토요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- 일요일 시작일감 모달 -->
		<div class="modal fade" id="sunday_Start" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">sunday</h4>
					</div>

					<c:forEach items="${weelyList_start}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.start_Day eq "일요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div> 

		<!-- 월요일 마감일감 모달 --------------------------------------------------------------------------------------------->
		<div class="modal fade" id="Monday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>
					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "월요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 화요일 마감일감 모달 -->
		<div class="modal fade" id="Tuesday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>
					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "화요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 수요일 마감일감 모달 -->
		<div class="modal fade" id="Wednesday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>

					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "수요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 목요일 마감일감 모달 -->
		<div class="modal fade" id="Thursday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>

					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "목요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 금요일 마감일감 모달 -->
		<div class="modal fade" id="Friday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>

					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "금요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 토요일 마감일감 모달 -->
		<div class="modal fade" id="saturday__End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>

					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "토요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!-- 일요일 마감일감 모달 -->
		<div class="modal fade" id="sunday_End" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Monday</h4>
					</div>
					<c:forEach items="${weelyList_end}" var="scheduleCalendarVo">
						<c:choose>
							<c:when test='${scheduleCalendarVo.end_Day eq "일요일" }'> 		
	${scheduleCalendarVo.sc_Title}<br>
	상세내용  : ${scheduleCalendarVo.sc_Description}<br>
	기간 :  <fmt:formatDate value="${scheduleCalendarVo.sc_Start_Date }"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.start_Day})
	~  <fmt:formatDate value="${scheduleCalendarVo.sc_End_Date}"
									pattern="yyyy-MM-dd" /> (${scheduleCalendarVo.end_Day})<Br>
								<br>
							</c:when>
						</c:choose>
					</c:forEach>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>


		<!----------------------------------------------------------------------------------------요일일정 체크 -->

		<form action="weeklyChecklist" name="dayInsert">

			<table class="table table-strip weeklychk" >

				<c:forEach items="${weekly_dateList}" var="ScheduleCalendarVo"
					varStatus="status">

					<tr style="background-color: white">
						<th class="col-md-1"
							style="border: 1px solid #dddddd; text-align: center; ">
							${ScheduleCalendarVo.dy} <input type="hidden"
							value=" ${ScheduleCalendarVo.dt}" id="${status.count}date">
						</th>

						<th class="col-md-7"
							style="border: 1px solid #dddddd; text-align: left; ">
							<c:forEach items="${weekCheckList}" var="WeeklyCheckVo">
								<script>
								$(function(){
									var yn = '${WeeklyCheckVo.wk_Yn}';
									if(yn=='Y'){
										$('#${ WeeklyCheckVo.wk_Num}').css({
											'text-decoration':'line-through'
										})
										$('#g2${ WeeklyCheckVo.wk_Num}').hide();
										$('#${WeeklyCheckVo.wk_Num}~#successBtn').hide();
									}									
								})
										
								</script>
								<c:set var="dateF">
									<fmt:formatDate value="${WeeklyCheckVo.wk_Date}"
										pattern="yyyyMMdd" />
								</c:set>

								<c:if test="${dateF ==ScheduleCalendarVo.dt}">

									<ul>
										<li><span id="${WeeklyCheckVo.wk_Num}"> - ${ WeeklyCheckVo.wk_Content}</span>

											<a href="weeklyCheck_Delete?wk_Num=${WeeklyCheckVo.wk_Num}">
												<span class="glyphicon glyphicon-remove"
												id="g1${WeeklyCheckVo.wk_Num}"
												style="font-size: 12px; margin-left: 5px; margin-right: 5px; color: red;">
											</span>
										</a> <a href="#"> <span class="glyphicon glyphicon-pencil"
												id="g2${WeeklyCheckVo.wk_Num}" style="font-size: 12px;"></span>
										</a> 
										<input type="button" class="btn btn-success btn-xs" id="successBtn" value="완료">
										<input type="hidden" id="wk_Content" value="${ WeeklyCheckVo.wk_Content}">
									    <input type="hidden" id="wk_Num" value="${WeeklyCheckVo.wk_Num }">

										</li>
									</ul>

								</c:if>


				</c:forEach> <input type="text" name="wk_Content" id="${status.count}content"
				size="100" style="background-color:transparent; border: 0px;outline: none;" onKeyDown="onKeyDown(${status.count});" placeholder='이 곳을 클릭하여 일정을 적어주세요'>
							 <c:set var="dateF">
								<fmt:formatDate value="${WeeklyCheckVo.wk_Date}"
									pattern="yyyyMMdd" />
							</c:set>
						</tr>
				</c:forEach>

			</table>
		</form>

	</div>

	<script>        
	function onKeyDown(countNum)
	{
	     if(event.keyCode == 13) {
	    	 var wk_Content = "";
	    	 wk_Content = $('#'+countNum+'content').val();
	    	 var d = $('#'+countNum+'date').val();  
	    	 
	       location.href="weeklyCheckInsert?wk_Content="+wk_Content+"&d="+d;
	     }
	}
</script>

	<script>       
											$(function(){
												$(document).on('click','#successBtn',function(){
													// 완료 버튼을 눌렀을때 값을 갖고와서 ajax post방식으로 처리함.
													var obj = $(this).siblings('input[type="hidden"]#wk_Content');
													var wk_Content =$(this).siblings('input[type="hidden"]#wk_Content').val();
													var wk_Num = $(this).siblings('input[type="hidden"]#wk_Num').val();
													var thisObj = $(this);
													var dataList = {'wk_Num':wk_Num};
													$.ajax({  
														contentType:'application/json',  
														dataType:'json',
														data:JSON.stringify(dataList),
														url:'weeklyCheck_YN',
														type:'post',
														success:function(result){
															// 업데이트에 성공하였다면 해당 content에 밑줄을 긋고 버튼을 숨긴다.
															$('#'+wk_Num).css({'text-decoration':'line-through'});
															//$('#g1'+wk_Num).hide();
															$('#g2'+wk_Num).hide();
															thisObj.hide();  
														}
													}) 
													
												})
												
												$(document).on('click','.glyphicon.glyphicon-pencil',function(e){
													// 수정 버튼을 눌렀을때 a태그의 이벤트를 막고 값을 가지고 input태그에 넣어준다.
													e.preventDefault();
													var id = $(this).attr('id');
													var idCode = id.substring(2);
													var wk_Content = $(this).parent().siblings('#wk_Content').val();
													var btnObj = $(this).parent().siblings('#successBtn');
													$('span#'+idCode).empty();
													$('#g1'+idCode).hide();
													$('#g2'+idCode).hide();
													btnObj.hide();
													
				$('span#'+idCode).append('<input type="hidden" value="'+id+'"><input type="text" id="modiBtn" value="'+
	     		wk_Content+'">&nbsp;<input type="button" value="수정완료" class="btn btn-default" id = "wk_UpdateSuccess">');
												})
												
												$(document).on('click','#wk_UpdateSuccess',function(){
													var wk_Content = $(this).siblings('#modiBtn').val();
													var id = $(this).siblings('input[type="hidden"]').val();
													var wk_Num = id.substring(2); 
													var dataList = {'wk_Num':wk_Num,'wk_Content':wk_Content};
													$.ajax({
														dataType:'json',
														contentType:'application/json',
														type:'post',
														url:'wk_UpdateSuccess',
														data : JSON.stringify(dataList),
														success:function(result){
														location.reload();
														
														}
													})
												})
												
											})
											
							</script>
</body>
</html>

