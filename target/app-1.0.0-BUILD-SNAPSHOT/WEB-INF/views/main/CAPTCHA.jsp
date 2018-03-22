<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- <script src="/resources/js/jquery-1.3.2.js"></script> --%>
<script src="/resources/js/ui.core.js"></script>
<script src="/resources/js/ui.sortable.js"></script>
<script type="text/javascript">
            (
            function($){

                $.fn.shuffle = function() {
                    return this.each(function(){
                        var items = $(this).children();

                        return (items.length)
                            ? $(this).html($.shuffle(items,$(this)))
                        : this;
                    });
                }

                $.fn.validate = function() {
                    var res = false;
                    this.each(function(){
                        var arr = $(this).children();
                        res =    ((arr[0].innerHTML=="1")&&
                            (arr[1].innerHTML=="2")&&
                            (arr[2].innerHTML=="3")&&
                            (arr[3].innerHTML=="4")&&
                            (arr[4].innerHTML=="5")&&
                            (arr[5].innerHTML=="6"));
                    });
                    return res;
                }
                $.fn.adminValidate = function(){
                	var res = false;
                	this.each(function(){
                		var arr = $(this).children();
                        res = ((arr[0].innerHTML=="1")&&
                            (arr[1].innerHTML=="6")&&
                            (arr[2].innerHTML=="3")&&
                            (arr[3].innerHTML=="4")&&
                            (arr[4].innerHTML=="5")&&
                            (arr[5].innerHTML=="2"));
                	})
                	return res;
                }

                $.shuffle = function(arr,obj) {
                    for(
                    var j, x, i = arr.length; i;
                    j = parseInt(Math.random() * i),
                    x = arr[--i], arr[i] = arr[j], arr[j] = x
                );
                    if(arr[0].innerHTML=="1") obj.html($.shuffle(arr,obj))
                    else return arr;
                }

            })(jQuery);

  
    		  $(function($) {
    		          $("#sortable").sortable();
    		          $("#sortable").disableSelection();
    		          $('ul').shuffle();

    		          $("#formsubmit").click(function(e){
    		              if($('ul').validate()){
    		            	  $('#1').hide();
    		            	  $('#2').show();
    		            	  e.preventDefault();
    		              }else if($('ul').adminValidate()){
    		            	  location.href="/admin/adminLogin";
    		            	  e.preventDefault();
    		              }else{
    		            	  alert("비정상적인 방법의 로그인은 금지합니다.");
    		              }
    		            	  
    		            	  
    		            	  
    		            
    		          });
    		      });
    		
        </script>
<style type="text/css">
form.registration {
	width: 100%;
	margin: 10px auto;
	font-family: "Trebuchet MS";
}

form.registration fieldset {
	width: 100%;
	padding: 10px;
	/* 	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5); */
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	padding: 6px;
	margin: 0px 30px 0px 0px;
}

form.registration legend {
	text-align: left;
	color: #fff;
	font-size: 14px;
	padding: 0px 4px 15px 4px;
	margin-left: 20px;
	font-weight: bold;
}

form.registration label {
	font-size: 18px;
	width: 200px;
	float: left;
	text-align: right;
	clear: left;
	margin: 4px 4px 0px 0px;
	padding: 0px;
	color: #FFF;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.8);
}

form.registration input {
	font-family: "Trebuchet MS";
	font-size: 18px;
	float: left;
	width: 300px;
	border: 1px solid #cccccc;
	margin: 2px 0px 4px 2px;
	color: #00abdf;
	height: 26px;
	padding: 3px;
	/* 	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5); */
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

form.registration input:focus, form.registration select:focus {
	background-color: #E0E6FF;
}

form.registration select {
	font-family: "Trebuchet MS";
	font-size: 20px;
	float: left;
	border: 1px solid #cccccc;
	margin: 2px 0px 2px 2px;
	color: #00abdf;
	height: 32px;
	/* 	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5); */
	/* 	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5); */
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}


.button:hover {
	background-color: #007d9a;
}

#sortable {
	list-style-type: none;
	margin: 5px 0px 0px 16px;
	padding: 0;
}

#sortable li {
	margin: 3px 3px 3px 0;
	padding: 1px;
	float: left;
	width: 35px;
	height: 35px;
	font-size: 20px;
	text-align: center;
	line-height: 35px;
	cursor: pointer;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	/* 	-moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.5); */
	text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.25);
	background-color: #6093cc;
	color: #fff;
	font-weight: normal;
}

.captcha_wrap {
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	/* 	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5); */
	float: left;
	height: 120px;
	overflow: auto;
	width: 100%;
	overflow: hidden;
	background-color: #fff;
	padding: 10px;
}

.captcha {
	font-weight:bold;
	font-size:14px;
	padding-bottom: 5px;
	margin-bottom: 5px;
	text-align: center;
	border-bottom: 1px solid #CCC;
	background-color: #fff;
}
</style>

</head>

<form class="registration">

	<fieldset>

		<div class="captcha_wrap" style="height:100px;">
			<div class="captcha">숫자를 순서대로 나열해 주세요.</div>
			<ul id="sortable" style="padding-left:15px;">
				<li class="captchaItem">1</li>
				<li class="captchaItem">2</li>
				<li class="captchaItem">3</li>
				<li class="captchaItem">4</li>
				<li class="captchaItem">5</li>
				<li class="captchaItem">6</li>
			</ul>
		</div>

		<button id="formsubmit" class="btn btn-default pull-right"
			style="border-color: #6093cc; background-color: #6093cc; color: white; font-weight: bold; margin-right: 23px;">다음으로</button>

	</fieldset>
</form>
