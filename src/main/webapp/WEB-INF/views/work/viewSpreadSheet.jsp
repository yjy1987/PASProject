<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 21.      PC14      최초작성
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
<script type="text/javascript" src="/resources/js/spreadSheetSocket.js"></script>
<div class="col-md-10" id="content" style=" padding-left: 5px;
    padding-right: 5px;
    background-color: white;
    border: 0px solid black;">
    <h2 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			SpreadSheet
			<small>&nbsp;&nbsp;&nbsp;
				<input type="button" value="돌아가기" id="goBackBtn" class="btn btn-default pull-right">
				<input style="margin-right:5px;" type="button" value="전체화면" id="fullScreenBtn" class=" btn btn-default pull-right">
				<input style="margin-right:5px;" type="button" value="저장하기" id="saveDataBtn" class="btn btn-default pull-right">
			</small>
		</h2><br>
		<div style="text-align: right" id="joinMemberZone"></div>
    <div id="spreadsheet" style="width:auto;"></div>
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
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
  
  
<script>

$(function() {
	connectSpreadSheet();
	var ds = "";
	var doc_Num = '${spreadSheetVo.doc_Num}';
	$.ajax({
		dataType:'json',
		contentType:'application/json',
		url:'initContent',
		type:'post',
		data:JSON.stringify({"doc_Num":doc_Num}),
		success:function(result){
			$("#spreadsheet").kendoSpreadsheet({
		        excel: {                
		            // Required to enable saving files in older browsers
		            proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
		        },
		        pdf: {                
		            proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
		        },
		        change:onChange,
		        sheets:[JSON.parse(result.sp_Content)],
		        sheetsbar:false,
		        toolbar:true
		        
		    });
		}
	})
	
	
    $('#saveDataBtn').on('click',function(){
		var spreadsheet = $("#spreadsheet").data("kendoSpreadsheet");
    	var sheet = spreadsheet.sheetByIndex(0);
    	var doc_Num = '${spreadSheetVo.doc_Num}';
        var dataList = {'sheet':JSON.stringify(sheet),'doc_Num':doc_Num};
    	$.ajax({  
        	type : "POST",
			url : "saveFile",
			dataType : "json", 
			data : JSON.stringify(dataList),
			contentType : "application/json",
			success:function(result){
				if(result){
				 alert('저장되었습니다.');
				}else{
					alert("실패하였습니다.");
				}  
			}
        });
    });
    
    $('#goBackBtn').on('click',function(){
    	location.href="/project/work/workList";
    })
    
    $('#fullScreenBtn').on('click',function(){
    	$("#fullBody").empty();
    	setTimeout(function(){
    		$.ajax({
    			dataType:'json',
    			contentType:'application/json',
    			url:'initContent',
    			type:'post',
    			data:JSON.stringify({"doc_Num":doc_Num}),
    			success:function(result){
    				$("#fullBody").kendoSpreadsheet({
    			    	 excel: {                
    			             // Required to enable saving files in older browsers
    			             proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
    			         },
    			        change:onChangeModal,
    			        sheets:[JSON.parse(result.sp_Content)],
    			        sheetsbar:false,
    			        toolbar:true,
    			        column:100,
    			        rows:120
    			    })
    			}
    		})
	        },2000);
    	$('#modal-fullscreen').modal();
    })
    
    
    $('button[class="close"]').on('click',function(){
    	var spreadsheet = $("#fullBody").data("kendoSpreadsheet");
    	var sheet = spreadsheet.sheetByIndex(0);
    	var doc_Num = '${spreadSheetVo.doc_Num}';
        var dataList = {'sheet':JSON.stringify(sheet),'doc_Num':doc_Num};
    	$.ajax({  
        	type : "POST",
			url : "saveFile",
			dataType : "json", 
			data : JSON.stringify(dataList),
			contentType : "application/json",
			success:function(result){
				if(result){
				 location.reload();
				}else{
					alert("실패하였습니다.");
					location.reload();
				}         
			}    
        });
    });
    
    function onChangeModal(arg){
    	var spreadsheet = $("#fullBody").data("kendoSpreadsheet");
    	var sheet = spreadsheet.sheetByIndex(0);
        var data2 = sheet.toJSON();
        var doc_Num = '${spreadSheetVo.doc_Num}';
        var dataList = {'sheet':JSON.stringify(sheet),'doc_Num':doc_Num};
   	 $.ajax({  
        	type : "POST",
			url : "saveFile",
			dataType : "json", 
			data : JSON.stringify(dataList),
			contentType : "application/json",
			success:function(result){
				sendSpreadSheet(JSON.stringify(data2));		
			}    
        });
    }
    
    function onChange(arg){
    	 var spreadsheet = $("#spreadsheet").data("kendoSpreadsheet");
    	 var sheet = spreadsheet.sheetByIndex(0);
         var data2 = sheet.toJSON();
    	 
    	 var doc_Num = '${spreadSheetVo.doc_Num}';
         var dataList = {'sheet':JSON.stringify(sheet),'doc_Num':doc_Num};
    	 $.ajax({  
         	type : "POST",
 			url : "saveFile",
 			dataType : "json", 
 			data : JSON.stringify(dataList),
 			contentType : "application/json",
 			success:function(result){
 				console.log(JSON.stringify(data2).length);
 				sendSpreadSheet(JSON.stringify(data2));
 			}    
         });
     }
}); 
      
    </script>                
</body>                     
</html>        
