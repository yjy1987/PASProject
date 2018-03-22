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

<div class="col-md-10" id="content">

		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">
			파일 생성<small>&nbsp;&nbsp;&nbsp; 새로운 파일 생성하기</small>
		</h3>
		<div style="width:200px; height:200px; border:1px solid black; text-align: center" ><a href = "#" id="spreadSheetView">엑셀</a></div>
		<div style="width:200px; height:200px; border:1px solid black; text-align: center" ><a href = "#" id="canvasView">그림판</a></div> 
		<div style="width:200px; height:200px; border:1px solid black; text-align: center" ><a href = "#" id="spreadWordView">워드</a></div>
		<div id = "spreadSheetDemo" style="width:500px; height:500px; border:1px solid black; background-color: lightgray">
			엑셀 선택 폼
			<input type="button" value="엑셀 생성하기" id="createSpreadSheet" class= " btn btn-default">
		</div>
		
		<div id = "spreadWordDemo" style="width:500px; height:500px; border:1px solid black; background-color: lightgray">
			워드 선택 폼
			<input type="button" value="엑셀 생성하기" id="createWordSheet" class= " btn btn-default">
		</div>
		
		
		<div id="viewZone"></div>
		<!-- <input type="button" value="엑셀 생성하기" id="createExcel" class= " btn btn-default"> -->
</div>
<script>
	$(function(){
		$('#spreadSheetDemo').hide();
		$('#spreadSheetView').on('click',function(){
			$('#spreadSheetDemo').show('slow');
			
		});
		
		$('#createSpreadSheet').on('click',function(){
			location.href="/project/work/spreadSheetForm";
		});
		
		
		$('#spreadWordDemo').hide();
		$('#spreadWordView').on('click',function(){
			$('#spreadWordDemo').show('slow');
		});
		
		$('#createWordSheet').on('click',function(){
			location.href="/project/work/spreadWordForm";
		});
		
		
		
		
		
		
		$('#canvasView').on('click',function(){
			location.href="/project/work/canvasForm";
		})
	})
		
	

</script>
</body>
</html>
