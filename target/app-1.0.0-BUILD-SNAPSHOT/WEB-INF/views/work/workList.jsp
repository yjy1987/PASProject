<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="PADDING-BOTTOM: 0PX; BORDER-BOTTOM: 0PX">파일 리스트</h3>
		
		<div>
		
		</div>
		<table class="table table-hover" id="fileList" style="border-bottom: 1px solid #ddd; ">
		<c:if test="${empty documentList}">
			<tr>
				<td>생성한 파일이 없습니다.    </td>
			</tr>
		</c:if>
		<c:forEach items="${documentList}" var = "documentVo">
			<tr>
				<td class="col-md-1" style="text-align:center;"><img
						src="/resources/img/${documentVo.doc_Img}">
				</td>
				<td class="col-md-4" style="padding:4px;"><a href="/project/work/selectDocument?doc_Num=${documentVo.doc_Num}&doc_Kind=${documentVo.doc_Kind}" >${documentVo.doc_Name}</a><br>파일 명 :<span id="file_Name"> ${documentVo.doc_File_Name}</span> <br>생성 일자 : <fmt:formatDate value="${documentVo.doc_Wt_Date}" pattern="yyyy-MM-dd HH:mm:ss"/><br> 생성자 : ${documentVo.mem_Name } </td>
				<td class="col-md-4 text-right"><a href="#" id="downloadFile" class="${documentVo.doc_Num}"> 미리보기 /  추출 </a>  |  <a href="/project/work/deleteDocument?doc_Num=${documentVo.doc_Num}">삭제</a> |<a href="#" id="${documentVo.doc_Num}" class="updateName"> 변경 </a> </td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<div id="preViewModal" class="modal fade" >
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">close</span>
						</button>
						<h4 id="modalTitle" class="modal-title">미리보기</h4>
					</div>
					<div id="modalBody" class="modal-body">
						<div id="preViewZone" style="width:auto; height: 800px;"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="exportBtn">다운로드</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="preWordViewModal" class="modal fade" >
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span> <span class="sr-only">close</span>
						</button>
						<h4 id="modalTitle" class="modal-title">미리보기</h4>
					</div>
					<div id="modalBody" class="modal-body">
						<textarea name="editor1"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="exportWordBtn">다운로드</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		
		
	<script>
		$(function(){
			
			$(document).on('click','#downloadFile',function(e){
				e.preventDefault();
				var ds ="";
				var doc_Num = $(this).attr('class');
				var dataList = {'doc_Num':doc_Num};
				$.ajax({
					contentType:'application/json',
					type:'post',
					url:'preViewFile',
					data: JSON.stringify(dataList),
					success:function(resultMap){
						if(resultMap.type==1){
							view(resultMap.content);
						}else if(resultMap.type==2){
							viewWord(resultMap.content);
						}
						
						
					}
					
				});
				
			})
			
		});
		function view(ds){
			$("#preViewZone").empty();
			setTimeout(function(){
			    $("#preViewZone").kendoSpreadsheet({
			    	 excel: {                
			             // Required to enable saving files in older browsers
			             proxyURL: "https://demos.telerik.com/kendo-ui/service/export"
			         },
			        sheets:[JSON.parse(ds)],
			        columns:100,
			        rows:100,
			        sheetsbar:false,
			        toolbar:true,
			    })
		     	var spreadsheet = $("#preViewZone").data("kendoSpreadsheet");
		        var sheet = spreadsheet.sheetByIndex(0);
		        var range = sheet.range("A1:XY999");  
 		        $('.k-spreadsheet-toolbar').hide();
				$('ul.k-tabstrip-items.k-reset').hide();
				$('div.k-tabstrip-wrapper').hide();
		        range.enable(false);    
		        },2000);     
			
		    $('#preViewModal').modal();

		    /* $('#preViewModal').data('kendoSpreadsheet').dataSource.read(); */
		     var spreadsheet = $("#spreadsheet").data("kendoSpreadsheet"); // the widget instance

        	var range = spreadsheet.activeSheet();
		     range = range.enable(false);
   		    
		};
		
		function viewWord(ds){
			$('#preWordViewModal').modal();
			 CKEDITOR.replace('editor1');
			 CKEDITOR.instances['editor1'].setData(ds); 
			
		};
		
		$('#exportBtn').on('click',function(){
			var spreadsheet = $("#preViewZone").data("kendoSpreadsheet");
			$('.k-i-file-excel').trigger('click');
		});
		
		$('#exportWordBtn').on('click',function(){
			var Wordsheet = CKEDITOR.instances.editor1.getData(); 
			 $.ajax({
             	type : "POST",
     			url : "exportWord",
     			dataType : "json", 
     			data : {"wd_Content":Wordsheet},
     			contentType : "application/json",
     			success:function(){
     				
     			}
             })
         });
	
		$(document).on('click','a',function(){
			if($(this).attr('class')=="updateName"){
				 var doc_Num = $(this).attr('id');
				var doc_Name = prompt("이름을 입력하세요");
				if(doc_Name==null || doc_Name ==""){
					return;
				}
				var dataList = {"doc_Num":doc_Num,"doc_File_Name":doc_Name};
				var selectObj = $(this).parent("td").siblings().eq(1).find('#file_Name');
				 $.ajax({
					dataType:'json',
					contentType:'application/json',
					type:'post',
					data:JSON.stringify(dataList),
					url:'/project/work/updateDocName',
					success:function(result){
						if(result){
							selectObj.text("");
							selectObj.text(" "+doc_Name); 
						}else{
							alert("변경을 실패하였습니다.");
						}
					}
				}); 
			}
		})
	  
	</script>      
</body>          
</html>       
