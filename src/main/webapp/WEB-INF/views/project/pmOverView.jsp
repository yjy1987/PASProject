<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<style>

html{
overflow:hidden;
}
.modal-title{
color:black;
}
.ds h3{
    color: #ffffff !important;
    font-size: 14px !important;
    padding: 0 10px !important;
    line-height: 30px !important;
    height: 30px !important;
    margin: 0 !important;
    background: rgba(68, 76, 87, 0.7) !important;
    text-align: center !important;
}
#content > div > div.col-lg-9.main-chart > div.row.mtbox > div> div > h3{
margin-top:10px;
margin-bottom:0px;
}
.mtbox{
margin-top:0px !important;
}
.mtbox>.box0>p{
color:white;
}
.box0:hover p {
color:#989898 !important;
}
.mtbox>.box0>p:hover{
color:#989898 !important;
}
</style>

<script language="javascript">

var i=0
window.document.onkeydown = protectKey;
function down() {
        window.footer_cart.scrollBy(0,31)
        return;
}
function up() {
        window.footer_cart.scrollBy(0,-31)
        return;
}
function protectKey()
{
        //새로고침을 막는 스크립트.. F5 번키..
        if(event.keyCode == 116)
        {
                event.keyCode = 0;
                return false;
        }
        //CTRL + N 즉 새로 고침을 막는 스크립트....
        else if ((event.keyCode == 78) && (event.ctrlKey == true))
        {
                event.keyCode = 0;
                return false;
        }
}

</script>

<div class="col-md-10" id="content">

<%--css --%>
<%-- <link href="<%=request.getContextPath() %>/resources/overview/css/bootstrap.css" rel="stylesheet"> --%>
    <!--external css-->
    <script src="https://code.highcharts.com/highcharts.js"></script>
   <script src="https://code.highcharts.com/modules/exporting.js"></script>


    <link href="<%=request.getContextPath() %>/resources/overview/css/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/overview/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/overview/js/gritter/css/jquery.gritter.css" />
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/overview/lineicons/style.css">   
    
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/resources/overview/css/style.css" rel="stylesheet"> 
    <link href="<%=request.getContextPath() %>/resources/overview/css/style-responsive.css" rel="stylesheet">


<%--js --%>
    <script src="<%=request.getContextPath() %>/resources/overview/js/chart-master/Chart.js"></script>
<script src="<%=request.getContextPath() %>/resources/overview/js/jquery.js"></script>
  <script src="<%=request.getContextPath() %>/resources/overview/js/jquery-1.8.3.min.js"></script> 
 <script src="<%=request.getContextPath() %>/resources/overview/js/bootstrap.min.js"></script>
 <!--   <script src="https://code.jquery.com/jquery-2.2.4.js"></script> -->
   <script src="/resources/kendo/kendo.all.min.js"></script>
    <script class="include" type="text/javascript" src="<%=request.getContextPath() %>/resources/overview/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=request.getContextPath() %>/resources/overview/js/jquery.scrollTo.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/overview/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/resources/overview/js/jquery.sparkline.js"></script>
   <script src="<%=request.getContextPath() %>/resources/admin/js/chart.min.js" type="text/javascript"></script>
   <script src="<%=request.getContextPath() %>/resources/admin/js/excanvas.min.js"></script> 

    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
   <script src="assets/js/zabuto_calendar.js"></script>   


<div class="row">
                  <div class="col-lg-9 main-chart">
                 
                     <div class="row mtbox"  style="height: 180px;">
                        <div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                           <div class="box1">
                          <img id="menuIcon" src="<%=request.getContextPath() %>/resources/overview/img/multiple-users-silhouette2.png">
                          <h3>${joinMem }</h3>
                           </div>
                          <p style="width:105%;">현재 <b>${joinMem }</b>명의 인원이 프로젝트를 &nbsp;참가 중 입니다.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                           <div class="box1">
                          <img id="menuIcon" src="<%=request.getContextPath() %>/resources/overview/img/file2.png">
                          <h3>${countDoc }</h3>
                           </div>         
                          <p style="width:105%;">현재 <b>${countDoc }</b>개의 파일이 작업 중 입니다.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                           <div class="box1">
                          <img id="menuIcon" src="<%=request.getContextPath() %>/resources/overview/img/money-bag.png">
                          <h3>${countAccount }</h3>
                           </div>
                          <p>현재 <b>${countAccount }</b>개의 회계정보가 있습니다.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                           <div class="box1">
                          <img id="menuIcon" src="<%=request.getContextPath() %>/resources/overview/img/calendar.png">
                          <h3>${countSchedule }</h3>
                           </div>
                          <p style="width:105%;">현재 <b>${countSchedule }</b>개의 일정이 등록 되었습니다.</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                           <div class="box1">
                          <img id="menuIcon" src="<%=request.getContextPath() %>/resources/overview/img/megaphone.png">
                          <h3>${countProjNotice }</h3>
                           </div>
                          <p>현재 <b>${countProjNotice }</b>개의 프로젝트 공지사항이 등록 되었습니다.</p>
                        </div>
                     
                     </div><!-- /row mt -->   
                  
                      
                      <%-- <div class="row mt">
                      <!-- SERVER STATUS PANELS -->
                         <div class="col-md-4 col-sm-4 mb">
                            <div class="white-panel pn donut-chart">
                               <div class="white-header">
                             <h5>SERVER LOAD</h5>
                               </div>
                        <div class="row">
                           <div class="col-sm-6 col-xs-6 goleft">
                              <p><i class="fa fa-database"></i> 70%</p>
                           </div>
                               </div>
                        <canvas id="serverstatus01" height="120" width="120"></canvas>
                        <script>
                           var doughnutData = [
                                 {
//                                     value: 70,
                                    color:"#68dff0"
                                 },
                                 {
                                    value : 30,
                                    color : "#fdfdfd"
                                 }
                              ];
                              var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
                        </script>
                            </div><! --/grey-panel -->
                         </div><!-- /col-md-4-->
                         

                         <div class="col-md-4 col-sm-4 mb">
                            <div class="white-panel pn">
                               <div class="white-header">
                             <h5>TOP PRODUCT</h5>
                               </div>
                        <div class="row">
                           <div class="col-sm-6 col-xs-6 goleft">
                              <p><i class="fa fa-heart"></i> 122</p>
                           </div>
                           <div class="col-sm-6 col-xs-6"></div>
                               </div>
                               <div class="centered">
                              <img src="assets/img/product.png" width="120">
                               </div>
                            </div>
                         </div><!-- /col-md-4 -->
                         
                  <div class="col-md-4 mb">
                     <!-- WHITE PANEL - TOP USER -->
                     <div class="white-panel pn">
                        <div class="white-header">
                           <h5>TOP USER</h5>
                        </div>
                        <p><img src="assets/img/ui-zac.jpg" class="img-circle" width="80"></p>
                        <p><b>Zac Snider</b></p>
                        <div class="row">
                           <div class="col-md-6">
                              <p class="small mt">MEMBER SINCE</p>
                              <p>2012</p>
                           </div>
                           <div class="col-md-6">
                              <p class="small mt">TOTAL SPEND</p>
                              <p>$ 47,60</p>
                           </div>
                        </div>
                     </div>
                  </div><!-- /col-md-4 -->
                         

                    </div><!-- /row -->
                    
                                 --%>
               <div class="row" style="margin-top:-20px;">
                  <!-- TWITTER PANEL -->
                  <div class="col-md-4 mb">
                            <div class="darkblue-panel pn">
                               <div class="darkblue-header">
                             <h5>주간일정 완료율</h5>
                               </div>
                        <canvas id="serverstatus02" height="120" width="120"></canvas>
                        <script>
                           var doughnutData = [
                                 {
                                    value: ${wkY},
                                    color:"#68dff0"
                                 },
                                 {
                                    value : ${wkN},
                                    color : "#444c57"
                                 }
                              ];
                              var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
                        </script>
                        <br>
                        <p style="color:white; margin-top:20px;">총 일정:${sumYN} | 완료:${wkY} | 미완료:${wkN}</p>
                        
                            </div><! -- /darkblue panel -->
                  </div><!-- /col-md-4 -->
                  
                  
                  <div class="col-md-4 mb">
                     <!-- INSTAGRAM PANEL -->
                     <div class="instagram-panel pn ">
                        
                        <p style="margin: 0px; !important; padding-top: 12px">
                           이달의 우수 팀원
                        </p>
                        <br/>
                        <td rowspan="2" style="width:15%; border-right:1px solid #ddd"><img style="border-radius:50%; width:120px; height:120px; " src="/resources/upload/${selectKing.mem_Img }" onerror="this.src=&quot;/resources/upload/no.png&quot;">
                        </td>
                        <br>
                        <br>
                        <span style="color:white;">${selectKing.mem_Name }</span>
                     </div>
                  </div><!-- /col-md-4 -->
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
                  <div class="col-md-4 col-sm-4 mb">
                     <!-- REVENUE PANEL -->
                     <div class="darkblue-panel pn">
                        <div class="darkblue-header">
                           <h5>회계현황</h5>
                        </div>
                        <div class="chart mt">
                           <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4" data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
                        </div>
                        <p class="mt">
                        <table style="font-size:20px; text-align: left;color:white;margin: auto; margin-top:-35px;">
                        <tr>
                        <td style="padding-left:1px;"><span class="glyphicon glyphicon-plus"></span></td><td id="sumImp" style="padding-bottom:10px; text-align:right">${totalAccountImp }</td>
                        </tr>
                        <tr>
                        <td><span class="glyphicon glyphicon-minus"></span></td><td id="sumExp" style="padding-bottom:10px; text-align:right">${totalAccountExp }</td>
                        </tr>
                        <tr>
                        <td style="padding-top:10px; border-top: 3px solid white;">￦ </td><td id="sum" style="padding-top:10px; border-top: 3px solid white;text-align:right"> ${totalAccount }</td>
                        </tr>
                        </table>                  
                     </div>
                  </div><!-- /col-md-4 -->
                  
               </div><!-- /row -->
               
               <div class="row mt">
                      <!--CUSTOM CHART START -->
                      <div class="border-head" style="margin-top:-50px;">
                          <h3>주간 방문자 추이</h3>
                      </div>
                     <!-- <div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div> -->
                        <div class="widget-content" >
                          <canvas id="area-chart" class="chart-holder" height="250px;" width="740px" style="width:100%"> </canvas>
                          <!-- /area-chart --> 
                     </div>
               </div><!-- /row -->   
               
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->
                  
                  
      <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->                  
                  
                  <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
                  
                   <div class="col-lg-3 ds" style="padding-left: 0px;padding-top:0px; height:auto; width:100%">
                   <h3>프로젝트 공지사항</h3>
                     <table class="table">
                  <c:forEach var="NoticeList" items="${NoticeList }" begin="${paging.beginNo}" end="${paging.endNo}">
                  <tr>
                  <td style="width: 40px;">${NoticeList.notice_Num }</td>
                  <td><a href="<%=request.getContextPath() %>/project/pmNoticeDetail?proj_Num=${NoticeList.proj_Num}&notice_Num=${NoticeList.notice_Num}">${NoticeList.notice_Title }</a></td>
                  </tr>
                  </c:forEach>
                </table>
                   </div>                
               
                  
               <div class="col-lg-3 ds" style="padding-left: 0px; height:auto; width:100%;">
                    <h3>참가 중인 맴버</h3>
                      <table class="table">
 
                  <c:forEach var="joinmember" items="${joinmember }" begin="${paging1.beginNo}" end="${paging1.endNo}">
                  <tr>
                  <td rowspan="2" style="width:15%; border-right:1px solid #ddd"><img style="border-radius:50%; width:40px; height:40px; " src="/resources/upload/${joinmember.mem_Img }" onerror="this.src=&quot;/resources/upload/no.png&quot;">
                  </td>
                  <td>
                  ${joinmember.mem_Name } (${joinmember.position_Name })
                  </td>
                  </tr>
                  <tr>
                  <td style="border-top:1px solid #ddd;">${joinmember.mem_Email }</td>
                  
                  </tr>
               
                  </c:forEach>
                 </table>
                </div>
                
<!--              <div id="overViewCalendarZone" class="col-lg-3 ds" style="padding-left: 0px; height:auto; width:100%;">
 -->               <div class="demo-section k-content col-lg-3 ds"  style="box-shadow:none;border-width:0px; padding-left: 0px; height:auto; width:100%;text-align: center;">
                         <div id="overViewCalendar" style="width:100%"></div>
                       </div>
                        
                      
                 <!--  </div> --><!-- /col-lg-3 -->
              </div><!--/row --></div>
           
<script>
/* $(function(){
   $.ajax({
      url:"",
      type:'post',
      dataType:'',
      success:function(data){
         Highcharts(data);
      }
   })
}); */
$(document).ready(function() {  
   $("#overViewCalendar").kendoCalendar();
   $.ajax({  
      dataType:'json',
      url:'overViewChart', 
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


</script>
</body>

</html>









