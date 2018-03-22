<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>

<head>
<title>BLUEMINE</title>	
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<!-- CSS -->
<!-- Bootstrap Core CSS -->
<link
	href="/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link
	href="/resources/css/stylish-portfolio.css"
	rel="stylesheet">
<link
	href="/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">



<!-- jQuery -->

<!-- Bootstrap Core JavaScript -->
<script
	src="/resources/js/bootstrap.min.js"></script>
<!-- bootstrap Validator -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.js"></script>

	<script src="<%=request.getContextPath() %>/resources/js/typed.js"></script>
	<script>
  $(function(){
      $("#headTitle").typed({
    	  
        strings: ["your project with us. ^2000 ","and <b>Finish</b> your project with us. ^5000"],
        contentType: 'html',
        typeSpeed : 10,
        backSpeed : 10,
		loop : true,
		loopCount : 50
      });
  });
</script>
</head>

<style>

.typed-cursor{
	font-size:24px;
    opacity: 1;
    -webkit-animation: blink 0.7s infinite;
    -moz-animation: blink 0.7s infinite;
    animation: blink 0.7s infinite;
}
@keyframes blink{
    0% { opacity:1; }
    50% { opacity:0; }
    100% { opacity:1; }
}
@-webkit-keyframes blink{
    0% { opacity:1; }
    50% { opacity:0; }
    100% { opacity:1; }
}
@-moz-keyframes blink{
    0% { opacity:1; }
    50% { opacity:0; }
    100% { opacity:1; }
}


body.modal-open .background-container {
	-webkit-filter: blur(4px);
	-moz-filter: blur(4px);
	-o-filter: blur(4px);
	-ms-filter: blur(4px);
	filter: blur(4px);
	filter: url("https://gist.githubusercontent.com/amitabhaghosh197/b7865b409e835b5a43b5/raw/1a255b551091924971e7dee8935fd38a7fdf7311/blur"
		.svg #blur);
	filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius='4');
}
a.btn.btn-dark{
font-weight:bold;
color:#337ab7 !important;
background-color:transparent !important;
}
</style>
<body style="overflow:hidden;">
<c:if test="${exit == 'yes' }">
         <script type="text/javascript">
            alert("탈퇴가 완료되었습니다.이용해주셔서 감사합니다.");
         </script>
      </c:if>
	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i
		class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#"
				class="btn btn-light btn-lg pull-right toggle"><i
				class="fa fa-times"></i></a>
			<li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>BlueMine</a>
			</li>
			<li><a href="#top" onclick=$("#menu-close").click();>BlueMine</a></li>
			<li><a href="#about" onclick=$("#menu-close").click();>회원 가입</a></li>

			<li><a href="#portfolio" onclick=$("#menu-close").click();>Portfolio</a>
			</li>
			
		</ul>
	</nav>

	<!-- Header -->
	<header id="top" class="header">
		<div class="text-vertical-center">
			<h1>Blue Mine</h1>
			<Br>
			<!-- <h3>Begin and Finish with us</h3> -->
			<h3 id="a" style="display:inline">Begin&nbsp;</h3><h3 id="headTitle" style="display:inline"></h3>
			<BR>
			<br> <a href="<%=request.getContextPath() %>/main/loginForm" class="btn btn-dark btn-lg">로그인</a>
			<a href="#about" class="btn btn-dark btn-lg">회원가입</a>
		</div>

	</header>



	<!-- joinForm -->
	<section id="about" class="about" style="padding-top:20px; height:100%">
		<div class="include">
	 	<jsp:include page="main/joinForm.jsp" /> 
		</div>
	</section>


	

	<!-- Portfolio -->
	<section id="portfolio" class="portfolio" style="background-color:white;overflow:hidden; height:100%">
	 <iframe src="//slides.com/yeojunyeong/make-better-presentations/embed?style=light" width="100%" height="100%" scrolling="no" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
	<div style="    position: relative;
    width: 100%;
    height: 50px;
    top: -36px;
    background-color: white;"></div>
		<!-- <div class="container">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1 text-center">
					<h2>Our Work</h2>
					<hr class="small">
					<div class="row">
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-responsive"
									src="resources/img/portfolio-1.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-responsive"
									src="resources/img/portfolio-2.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-responsive"
									src="resources/img/portfolio-3.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-responsive"
									src="resources/img/portfolio-4.jpg">
								</a>
							</div>
						</div>
					</div>
					/.row (nested)
					<a href="#" class="btn btn-dark">View More Items</a>
				</div>
				/.col-lg-10
			</div>
			/.row
		</div>
		/.container -->
	</section>

	<!-- Call to Action -->
	<aside class="call-to-action bg-primary">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h3>The buttons below are impossible to resist.</h3>
					<a href="#" class="btn btn-lg btn-light">Click Me!</a> <a href="#"
						class="btn btn-lg btn-dark">Look at Me!</a>
				</div>
			</div>
		</div>
	</aside>

	<!-- Map -->
	<section id="contact" class="map">
		<iframe width="100%" height="100%" frameborder="0" scrolling="no"
			marginheight="0" marginwidth="0"
			src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>
		<br /> <small> <a
			href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a>
		</small>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1 text-center">
					<h4>
						<strong>Start Bootstrap</strong>
					</h4>
					<p>
						3481 Melrose Place <br>Beverly Hills, CA 90210
					</p>
					<ul class="list-unstyled">
						<li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
						<li><i class="fa fa-envelope-o fa-fw"></i> <a
							href="mailto:name@example.com">name@example.com</a></li>
					</ul>
					<br>
					<ul class="list-inline">
						<li><a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
						</li>
						<li><a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
						</li>
						<li><a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
						</li>
					</ul>
					<hr class="small">
					<p class="text-muted">Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</div>
		<a id="to-top" href="#top" class="btn btn-dark btn-lg"><i
			class="fa fa-chevron-up fa-fw fa-1x"></i></a>
	</footer>
</body>

<!-- Custom Theme JavaScript -->
<script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    // Disable Google Maps scrolling
    // See http://stackoverflow.com/a/25904582/1607849
    // Disable scroll zooming and bind back the click event
    var onMapMouseleaveHandler = function(event) {
        var that = $(this);
        that.on('click', onMapClickHandler);
        that.off('mouseleave', onMapMouseleaveHandler);
        that.find('iframe').css("pointer-events", "none");
    }
    var onMapClickHandler = function(event) {
            var that = $(this);
            // Disable the click handler until the user leaves the map area
            that.off('click', onMapClickHandler);
            // Enable scrolling zoom
            that.find('iframe').css("pointer-events", "auto");
            // Handle the mouse leave event
            that.on('mouseleave', onMapMouseleaveHandler);
        }
        // Enable map zooming with mouse scroll when the user clicks the map
    $('.map').on('click', onMapClickHandler);
        
   
    </script>
<script>
$(document).ready(function() {
			$('#reg_form')
					.bootstrapValidator(
							{
								// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
	fields : {
									
									mem_Name : {
										validators : {
											stringLength : {
												min : 2,
												message: '이름은 최소 두글자 이상 입력하셔야 합니다.'
											},
											notEmpty : {
												message : '이름을 기입해 주세요'
											}
										}
									},

									mem_Phone : {
										validators : {
											regexp:{
												 regexp : /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/,
							                     message: '형식에 맞는 휴대폰 번호를 입력해 주세요.'
											},
											
										/* 	stringLength : {
												min : 12,
												max : 13,
												message :  '하이픈 붙혀서 전화번호 똑바로 좀 '
											}, */
											notEmpty : {
												message : '휴대폰 번호를 입력해 주세요.'
											}
											
										}
									},


									mem_Email : {
										
										validators:{
											notEmpty : {
												message : '이메일란을 입력해 주세요.'
											},
											emailAddress : {
												message : '형식에 맞는 이메일 주소를 입력해 주세요.'
											},
			                        		remote : {
			                        			  url : 'main/EmailCheck',
			                        			  dataType:'json',
			                        			  contentType:'application/json',
			                        			  data:function(validator,$field,value){
			                        				  return {
			                        					  mem_Email : JSON.stringify(validator.getFieldElements('mem_Email').val())
			                        				  };
			                        			  },
			                        			  type:'post',
			                        			  message:'이메일 주소가 존재합니다.  다른 이메일 주소를 입력해주세요',
			                        			  delay:1000
			                        		  }
			                        	  }
										/* validators : {
											
										} */
									},

									mem_Pass : {
										validators : {
											regexp:{
												 regexp : /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/,
							                     message: '비밀번호는 영문, 숫자, 특수문자가 꼭 들어가야 합니다.'
											},
											stringLength : {
												min : 8,
												max : 20,
												message :  '비밀번호는 10~20자 사이의 영문+숫자 조합으로 해주세요 '
											},
											notEmpty : {
												message : '공란입니다.'
											},
											identical : {
												message : 'Confirm your password below - type same password please'
											}
											
										}
									},
									mem_Pass_CK : {
										validators : {
											notEmpty : {
												message : '공란입니다.'
											},
											identical : {
												field : 'mem_Pass',
												message : '위와 동일한 비밀번호를 입력해 주시기 바랍니다.'
											}
										}
									},

								}
							}) .on('err.field.fv', function(e, data) {
					            if (data.fv.getSubmitButton()) {
					                data.fv.disableSubmitButtons(false);
					            }
					        })
					        .on('success.field.fv', function(e, data) {
					            if (data.fv.getSubmitButton()) {
					                data.fv.disableSubmitButtons(false);
					            }
					        });
								
								
								/* $('#success_message').slideDown({opacity : "show"}, "slow") // Do something ... */
					/* 			$('#reg_form').data('bootstrapValidator').resetForm();
						e.preventDefault();
						alert(e.target.nodeName);
						var $form = $(e.target);

						// Get the BootstrapValidator instance
						var bv = $form
								.data('bootstrapValidator');

						// Use Ajax to submit form data
						$.post($form.attr('action'), $form.serialize(), 
								function(result) {
							console.log(result);
						}, 'json'); 
					});*/
					
		});
</script>      

</html>
