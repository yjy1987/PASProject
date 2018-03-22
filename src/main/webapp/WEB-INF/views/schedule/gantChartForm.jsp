<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 24.      PC14      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>
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

        <style type="text/css">

            /*center treelist cell content vertically*/
            .k-gantt .k-treelist td
            {
                vertical-align: middle;
            }

            /*hide the resource labels, as they are present in the task template*/
            .k-gantt .k-resource
            {
                display: none;
            }

            /*style the task template*/
            .k-task-template {
                height: 100%;
                padding: 0 !important;
            }

            .template {
                height: 100%;
                overflow: hidden;
            }

            .resource-img {
                float: left;
                width: 32px;
                height: 32px;
                border-radius: 50%;
                margin: 8px;
            }

            .wrapper {
                padding: 8px;
                color: #fff;
            }

            .k-task-template .wrapper > * {
                display: block;
                overflow: hidden;
                text-overflow: ellipsis;
            }

            .title {
                font-weight: bold;
                font-size: 13px;
            }

            .resource {
                text-transform: uppercase;
                font-size: 9px;
                margin-top: .5em;
            }

            .progress
            {
                position: absolute;
                left: 0;
                bottom: 0;
                width: 0%;
                height: 4px;
                background: rgba(0, 0, 0, .3);
            }
        </style>
  
<div class="col-md-10" id="content">  
<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			간트 차트
		</h3>
		<input type="button" id = "updateGant"  value="저장" class="btn btn-default">
		<input type="button" id = "fullGantBtn" value="전체화면" class="btn btn-default">

        <div id="gantt"></div>
</div>


<!-- Modal fullscreen -->    
<div class="modal modal-fullscreen fade" id="modal-fullscreen" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width:auto;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">전체화면</h4>
      </div>
      <div class="modal-body" >
      	<div id="fullBody" style="width:1800px; height: 800px"></div>
      </div>
      <div class="modal-footer">
        <button type="button" id="closeBtn" class="btn btn-default " data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>    
  

<script>   
$(function(){  
	
	$.ajax({
		url:'setGant',
		dataType:'json',
		contentType:'application/json',
		success:function(data){
			go(data);
		}
	});
	
	
	function go(data){  
          $("#gantt").kendoGantt({
            dataSource: data,  
            columns: [
                      { field: "title", title: "Title", width:70},
                      { field: "start", title: "Start Time", width: 200,format: "{0:yyyy-MM-dd hh:mm}"  },
                      { field: "end", title: "End Time", width: 200,format: "{0:yyyy-MM-dd hh:mm}"  }
                    ],
                    showWorkHours: false,
                    showWorkDays: false,
                    snap: false
          });
          
          $('#updateGant').on('click',function(){
	          var gantt = $("#gantt").data("kendoGantt");
	          task = gantt.dataSource;
			      	$.ajax({
			    		url:' updateGant',
			    		dataType:'json',
			    		contentType:'application/json',
			    		data:JSON.stringify(task),
			    		type:'post',
			    		success:function(result){
			    			if(result){
				    			var gantt = $("#gantt").data("kendoGantt");  
				    			location.reload();
			    			}else{
			    				alert("실패");
			    			}
			    			
			    		}
			    	});
          });
          $('#fullGantBtn').on('click',function(){
        		$("#fullBody").empty();
            	setTimeout(function(){
            		 $("#fullBody").kendoGantt({
            	            dataSource: data,  
            	            columns: [
            	                      { field: "title", title: "Title", width:70},
            	                      { field: "start", title: "Start Time", width: 200,format: "{0:yyyy-MM-dd hh:mm}"  },
            	                      { field: "end", title: "End Time", width: 200,format: "{0:yyyy-MM-dd hh:mm}"  }
            	                    ],
            	                    showWorkHours: false,
            	                    showWorkDays: false,
            	                    snap: false
            	          });
        	        },3000);
            	$('#modal-fullscreen').modal();
          });
          
          
          

          $('button[class="close"],#closeBtn').on('click',function(){
          	var gantt = $("#fullBody").data("kendoGantt");
          	 task = gantt.dataSource;
		      	$.ajax({
		    		url:' updateGant',
		    		dataType:'json',
		    		contentType:'application/json',
		    		data:JSON.stringify(task),
		    		type:'post',
		    		success:function(result){
		    			if(result){
			    			var gantt = $("#gantt").data("kendoGantt");  
			    			location.reload();
		    			}else{
		    				alert("실패");
		    				location.reload();
		    			}
		    			
		    		}
		    	});
          })
          
          
	}
})             
</script>             
</body>        
</html>       
  


<!--  {     
                id: 1,
                orderId: 0,
                title: "Task1",
                start: new Date("2014/6/17 9:00"),
                end: new Date("2014/6/17 11:00"),
                percentComplete :"0.3"
              },
              {
                id: 2,
                orderId: 1,
                title: "Task2",
                start: new Date("2014/6/17 12:00"),
                end: new Date("2014/6/17 13:00")
              },
              {
                  id: 3,
                  orderId: 2,
                  title: "Task3",
                  start: new Date("2014/6/18 12:00"),
                  end: new Date("2014/6/19 13:00")
                },
                {
                    id: 4,
                    orderId: 3,
                    title: "Task5",
                    start: new Date("2014/6/17 12:00"),
                    end: new Date("2014/6/17 13:00")
                  } -->
