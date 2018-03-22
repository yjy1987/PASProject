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
    <div class="col-md-10" id="content">
        <input type="button" value="저장하기" id="saveDataBtn" class="btn btn-default">
        <input type="hidden" value="${param.doc_Num }" id="doc_Num">      	
        <textarea name="editor1" id="editor1"></textarea>
        <script>  
           
        var a=  "${wordSheetVo.wd_Content}";
        
            CKEDITOR.replace( 'editor1' );
            CKEDITOR.instances['editor1'].setData(a);   
            
            
            $('#saveDataBtn').on('click',function(){
            	var Wordsheet = CKEDITOR.instances.editor1.getData();
            	var doc_Num = $('#doc_Num').val();
                var dataList = {'wd_Content':Wordsheet ,'doc_Num': doc_Num}; 
               $.ajax({
               	type : "POST",
       			url : "saveWord",
       			dataType : "json", 
       			data : JSON.stringify(dataList),
       			contentType : "application/json",
       			success:function(result){
       				
       					location.href="/project/work/workList";
       				
       			}
               })
           });
            
        </script>
     </div>
    </body>
</html>