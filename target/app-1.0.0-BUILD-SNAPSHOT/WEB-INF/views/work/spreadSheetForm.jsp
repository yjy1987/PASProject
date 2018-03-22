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
<div class="col-md-10" id="content" style=" padding-left: 5px; padding-top:10px;
    padding-right: 5px;
    background-color: white;
    border: 0px solid black;">
<div><input type="button" value="생성하기" id="createSpreadSheetBtn" class = "btn btn-default pull-right"><input type="button" value="돌아가기" id ="goBackBtn" class="btn btn-default"></div><br>   
<div id="spreadsheet" style="width:auto;"></div>
</div>
<script>
$(function() {
    $("#spreadsheet").kendoSpreadsheet({
        excel: {                
            // Required to enable saving files in older browsers
            proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
        },
        pdf: {                
            proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
        },
        columns:100,
        rows:100,
        sheetsbar:false,
        toolbar:true
       
    });
    $('#createSpreadSheetBtn').on('click',function(){
    	var spreadsheet = $("#spreadsheet").data("kendoSpreadsheet");
    	
    	var sheet = spreadsheet.sheetByIndex(0);
        var dataList = sheet.toJSON();
        $.ajax({
        	type : "POST",
			url : "createSpreadSheet",
			dataType : "json", 
			data : JSON.stringify(dataList),
			contentType : "application/json",
			success:function(result){
				if(result){
					location.href="/project/work/workList";
				}else{
					alert("생성 실패");
				}
			}
        })
    });
    
    $('#goBackBtn').on('click',function(){
    	location.href="/project/work/createWorkForm";
    })
});
</script>
</body>
</html>