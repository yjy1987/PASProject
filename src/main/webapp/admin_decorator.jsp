<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<%--css --%>
<link href="<%=request.getContextPath() %>/resources/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/admin/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
        rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/admin/css/font-awesome.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/admin/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/admin/css/pages/dashboard.css" rel="stylesheet">

<%--js --%>
<script src="<%=request.getContextPath() %>/resources/admin/js/jquery-1.7.2.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/admin/js/excanvas.min.js"></script> 
<script src="<%=request.getContextPath() %>/resources/admin/js/chart.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath() %>/resources/admin/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/resources/admin/js/full-calendar/fullcalendar.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/admin/js/base.js"></script> 


<style>
#menuIcon{
margin-bottom:10px;
}
#big_stats .stat .value {
  
    line-height: 1.3em;
}
</style>





<title></title>
</head>
<body>
<header>
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">BLUE MINE 관리자 페이지 </a>
      <div class="nav-collapse">
        <ul class="nav pull-right">
          <li class="dropdown"><a href="#" style="font-size:19px;"class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user"></i> admin <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a style="font-size:15px;"href="<%request.getContextPath();%>/index">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /navbar-inner --> 
</div>
<!-- /navbar -->
<div class="subnavbar">
  <div class="subnavbar-inner">
    <div class="container">
      <ul class="mainnav">
        <li class="active"><a href="adminMain"><i><img id="menuIcon" src="<%=request.getContextPath() %>/resources/admin/img/dashboard.png"></i><span>대시보드</span> </a> </li>
        <li><a href="memberList"><i><img id="menuIcon" src="<%=request.getContextPath() %>/resources/admin/img/multiple-users-silhouette.png"></i><span>회원</span> </a> </li>
        <li><a href="projectList"><i><img id="menuIcon" src="<%=request.getContextPath() %>/resources/admin/img/file.png"></i><span>프로젝트</span> </a></li>
        <li><a href="AdminQnAList"><i><img id="menuIcon" src="<%=request.getContextPath() %>/resources/admin/img/question-mark.png"></i><span>Q&A</span> </a> </li>
        <li><a href="AdminTotalNoticeList"><i><img id="menuIcon" src="<%=request.getContextPath() %>/resources/admin/img/promote.png"></i><span>공지사항</span> </a> </li>
      </ul>
    </div>
    <!-- /container --> 
  </div>
  <!-- /subnavbar-inner --> 
</div>
<!-- /subnavbar -->

</header> 

<decorator:body />


</body>
<script>  
	$(document).ready(function() {  
		$.ajax({  
			dataType:'json',
			url:'chartInit', 
			type:'post',
			success:function(result){
				var lineChartData = {
				    labels: result.dt,
				    datasets: [
						{
						    fillColor: "rgba(151,187,205,0.5)",
						    strokeColor: "rgba(151,187,205,1)",
						    pointColor: "rgba(151,187,205,1)",
						    pointStrokeColor: "#fff",
						    data: result.count
						}
					]
				}
				
				var myLine = new Chart(document.getElementById("area-chart").getContext("2d")).Line(lineChartData);
			}
		})
		
	
		/* {
		    fillColor: "rgba(220,220,220,0.5)",
		    strokeColor: "rgba(220,220,220,1)",
		    pointColor: "rgba(220,220,220,1)",
		    pointStrokeColor: "#fff",
		    data: [65, 59, 90, 81, 56, 55, 40]
		}, */
		
		
		
		var barChartData = {
		    labels: ["January", "February", "March", "April", "May", "June", "July"],
		    datasets: [
				{
				    fillColor: "rgba(220,220,220,0.5)",
				    strokeColor: "rgba(220,220,220,1)",
				    data: [65, 59, 90, 81, 56, 55, 40]
				},
				{
				    fillColor: "rgba(151,187,205,0.5)",
				    strokeColor: "rgba(151,187,205,1)",
				    data: [28, 48, 40, 19, 96, 27, 100]
				}
			]
		
		}    
	
		
		var calendar = $('#calendar').fullCalendar({
		  header: {
		    left: 'prev,next today',
		    center: 'title',
		    right: 'month,agendaWeek,agendaDay'
		  },
		  selectable: true,
		  selectHelper: true,
		  select: function(start, end, allDay) {
		    var title = prompt('Insert your event title ');
		    if (title) {
		      calendar.fullCalendar('renderEvent',
		        {
		          title: title,
		          start: start,
		          end: end,
		          allDay: allDay
		        },
		        true // make the event "stick"
		      );
		      var dataList ={'title':title,'start':start.setDate(start.getDate()+1),'end':end.setDate(end.getDate()+1),'allDay':allDay};
		    	$.ajax({ 
		    		contentType:'application/json',
		    		type:'post',  
		    		url:'adminInsertCal',
		    		data:JSON.stringify(dataList)
		    	}) 
		    }
		    calendar.fullCalendar('unselect');
		  },
		  editable: true,
		  eventSources:[{
			  url : "adminCalendarList",
			  type:"post"
		  }]  
		  
		});
	});  
</script><!-- /Calendar -->

</html>