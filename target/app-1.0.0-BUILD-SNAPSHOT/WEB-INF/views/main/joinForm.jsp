<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>

/* table tr td { 
border: 1px solid black;
} */
#body {
	background-color: rgb(249, 249, 249) !important;
}

.container {
	max-width: 800px;
	outline: 1px solid rgb(216, 222, 226);
	background-color: white;
	margin-top: 30px;
	padding: 30px;
}


@font-face {
	font-family: 'NanumGothic';
	src: url(/resources/fonts/NANUMBARUNGOTHIC.TTF) format('truetype');
}
@font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/resources/fonts/FEDERALESCORTHALFITAL.TTF);
}
#title{
	font-family:'NanumGothic';
}

#titleLogo{
	font-family : 'FEDERALESCORTHALFITAL';
	color:#337ab7;
}
body {
	font-family: NanumGothic;
}
</style>
<!-- <script src="https://code.jquery.com/jquery-3.1.1.js"></script> -->
	
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath() %>/resources/css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getContextPath() %>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.js"></script>
<body id="body">
<h3 id="titleLogo" style="font-family : 'FEDERALESCORTHALFITAL' !important; text-align: right; margin-right: 46px;">
			BLUEMINE
		</h3>
<div class="container2" style="width:800px;margin:auto;">
	<!-- 로고는 일단 지저분하니까 빼자
	<h3 style="text-align: center;">
		<img style="width: 80px" src="resources/img/logo.png">
	</h3> -->
	<!-- <h2 style="text-align: center">회원가입</h2> -->

		<div class="title">
			<h2 style="font-weight:bold;">회원 가입</h2>
			<hr style="color: rgb(216, 222, 226); margin-top: 5px;">
		</div>
	<div class="container container-fluid" style="padding-bottom:0px;">


		<form class="form-horizontal" action="main/join" method="post" name="reg_form" id="reg_form">
				<!-- Form Name -->
						<!-- Email -->
				<div class="form-group">
					<label class="col-md-4 control-label">이메일 주소</label>
					<div class="col-md-6  inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon">
							<i class="glyphicon glyphicon-envelope"></i></span> 
							<input type="hidden" id="check_Email" value="n">
							<input name="mem_Email" id="mem_Email" placeholder="이메일 주소" class="form-control" type="text" 
							 required="required">
						</div>
					</div>
				</div>
			

				<!-- Password -->
				<div class="form-group has-feedback">
					<label for="password" class="col-md-4 control-label"> 비밀번호
					</label>
					<div class="col-md-6  inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input
								class="form-control" id="userPw" type="password"
								placeholder="비밀번호" name="mem_Pass" data-minLength="5"
								data-error="some error" required /> <span
								class="glyphicon form-control-feedback"></span> <span
								class="help-block with-errors"></span>
						</div>
					</div>
				</div>

				<!-- password confirm -->
				<div class="form-group has-feedback">
					<label for="비밀번호 확인" class="col-md-4 control-label">
						비밀번호 확인 </label>
					<div class="col-md-6  inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-repeat"></i></span> <input
								class="form-control {$borderColor}" id="userPw2" type="password"
								placeholder="비밀번호 확인" name="mem_Pass_CK"
								data-match="#confirmPassword" data-minLength="5"
								data-match-error="some error 2" required /> <span
								class="glyphicon form-control-feedback"></span> <span
								class="help-block with-errors"></span>
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">이름</label>
					<div class="col-md-6  inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="mem_Name"
								id="mem_Name" placeholder="이름" class="form-control" type="text">
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">전화번호</label>
					<div class="col-md-6  inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="mem_Phone"
								id="mem_Phone" placeholder="하이픈(-)을 제외하고 입력해주세요." class="form-control" type="text">
						</div>
					</div>
				</div>
 
				<!-- Button -->
				<div class="form-group" style="text-align:right;">
					<label class="col-md-6 control-label"></label>
					<div class="col-md-4">
<!-- 						<button type="button" class="btn btn-warning" onclick="aa(this.form)" id="joinBtn"> -->
						<button type="submit" class="btn btn-warning" id="joinBtn">
							확인 <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>
			<script type="text/javascript">
			/* $(function(){
				if()
			}) */
			var EC_Result = false;
			
			function setEmailCheck(result){
				EC_Result = result;
			}
			
			function aa(form){
				
			//이메일 정규식	
			var E_Result = true;
			var Email_Pt = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            var Email= $('#mem_Email').val();
				if(!Email_Pt.test(Email)){
					E_Result = false;
				}else{
					E_Result = true;
				}
		    //비밀번호 정규식
		    var P_Result = true;
		    var Pass_Pt = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
		    var Pass = 	$('#userPw').val();
		    	if(!Pass_Pt.test(Pass)){
		    		P_Result = false;
				}else{
					P_Result = true;
				}
		    //비밀번호 확인 정규식
		    var PC_Result = true;
		   	var Pass = $('#userPw').val();
		    var Pass_Check= $('#userPw2').val();
		    	if(Pass != Pass_Check){
		    		PC_Result = false;
				}else{
					PC_Result = true;
				}
			//이름 정규식
			var N_Result = true;
		    var name_Pt = /^[가-힝]{2,5}$/;
		    var mem_name= $('#mem_Name').val();
		    	if(!name_Pt.test(mem_name)){
		    		N_Result = false;
				}else{
					N_Result = true;
				}	
		    //전화번호 정규식	
		    var PH_Result = true;
		    var Phone_Pt = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
			var mem_Phone= $('#mem_Phone').val();
		    	if(!Phone_Pt.test(mem_Phone)){
		    		PH_Result = false;
				}else{
					PH_Result = true;
				}	
			
				if(E_Result == true && EC_Result == true && 
				   P_Result == true && PC_Result == true &&
				   N_Result == true && PH_Result == true ){
					form.action = "main/join"
					form.method = "POST"
					form.submit();
				}
			}
			</script>
		</form>

	</div>



</div>
</body>

