<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 27.      PC25      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>CKEditor</title>
        
    </head>
    <body>
    <div class="col-md-10" id="content" style="padding-left:5px; padding-right:5px; padding-top:10px; padding-bottom:10px;">
    <div style="text-align:right;">
    <input style="margin-bottom:10px; "type="button" value="생성하기" id="createWordSheetBtn" class = "btn btn-default "></div>
        <textarea name="editor1"></textarea>
        <script>
            CKEDITOR.replace( 'editor1' );
            
            $('#createWordSheetBtn').on('click',function(){
            	var Wordsheet = CKEDITOR.instances.editor1.getData();
                 var dataList = {"wd_Content":Wordsheet}; 
                $.ajax({
                	type : "POST",
        			url : "createWordSheet",
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
            
        </script>
     </div>
    </body>
</html>