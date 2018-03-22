<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
		$(function() {
			$('.td').click(function() {
				$('#edit').hide();
				$('td').each(function() {
					var content = $(this).html();
					$(this).html('<textarea>' + content + '</textarea>');
				});

				$('#save').show();
				$('.info').fadeIn('fast');
			});

			$('#save').click(function() {
				$('#save, .info').hide();
				$('textarea').each(function() {
					var content = $(this).val();//.replace(/\n/g,"<br>");
					$(this).html(content);
					$(this).contents().unwrap();
				});

				$('#edit').show();
			});
		})
	</script>
	<div class="col-md-10" id="content">
		<h3 class="page-header"
			style="padding-bottom: 0px; border-bottom: 0px;">30만원타고시포</h3>
		<small>스키장</small>
		<div class="container">
			<h1>
				inline editing <small>with jquery & textareas</small>
			</h1>
			<table class="table table-bordered" id="dbclick">
				<thead>
					<tr>th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>At vero invidunt ut labore et dolore magna aliquyam erat,
							sed diam voluptua</td>
						<td>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,
							sed diam nonumy eirmod tempor</td>
						<td>Pellentesque habitant morbi tristique senectus et netus
							et malesuada fames ac turpis egesta</td>
					</tr>
				</tbody>
			</table>
			<button class="btn btn-info" id="edit">
				<span class="glyphicon glyphicon-edit"></span> edit
			</button>
			<button class="btn btn-success" id="save" style="display: none">
				<span class="glyphicon glyphicon-save"></span> save
			</button>
			<span class="info" style="display: none;">(here you can do
				some ajax action...)</span>
		</div>


		<img src="/resources/img/sun1.png"
			style="position: relative; width: 68px; height: 68px"/>
			<div style="position:relative; top: -3.84em; left:1.03em; width:80px;">
			<img src="<%=request.getContextPath() %>/resources/img/yeo.png" style="width:40px; height:40px; border-radius:50%"/>
			</div>
			
		
	</div>


</body>
</html>