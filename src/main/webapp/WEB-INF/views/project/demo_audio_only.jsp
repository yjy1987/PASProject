<%--
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017. 2. 21.      PC25      최초작성
* Copyright (c) 2017 by DDIT All right reserved
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> <!--skip-->
        <title>EasyRTC Demo: Audio Only</title>
        <link rel="stylesheet" type="text/css" href="/resources/css/easyrtc.css" />

        <!--hide-->
        <link rel="stylesheet" type="text/css" href="/resources/css/landing.css" />

        <!-- Prettify Code -->
        <script type="text/javascript" src="/resources/js/prettify.js"></script>
        <script type="text/javascript" src="/resources/js/loadAndFilter.js"></script>
        <%-- <script type="text/javascript" src="/resources/js/jquery.min.js"></script> --%>
        <link rel="stylesheet" type="text/css" href="/resources/css/prettify.css" />
        <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <!--show-->
        <!-- Assumes global locations for socket.io.js and easyrtc.js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/1.7.3/socket.io.js"></script>
        <script type="text/javascript" src="http://192.168.202.194:1313/easyrtc/easyrtc.js"></script>
        <script type="text/javascript" src="/resources/js/demo_audio_only.js"></script>
        <!--hide-->
        <!-- Styles used within the demo -->
        <style type="text/css">
        @font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/resources/fonts/FEDERALESCORTHALFITAL.TTF);
		
         } 
         
         #roomToAdd{
         outline: none;
    border-left: 0px solid blue;
    border-top: 0px solid blue;
    border-right: 0px solid blue;
    border-bottom: 1px solid black;
         
         }
         
        #teamName{
                font-family : 'FEDERALESCORTHALFITAL';
            }
            #connectControls {
                float:left;
                width:300px;
                text-align:center;
                border: 2px solid black;
            }
            #otherClients {
                height:200px;
                overflow-y:scroll;
            }
            #callerAudio {
                /* display:none; */
                height:10em;
                width:10em;
                margin-left:10px;
            }
            #acceptCallBox {
                display:none;
                z-index:2;
                position:absolute;
                top:50px;
                left:30px;
                border:red solid 2px;
                background-color:white;
                padding:10px;
            }
        </style>
        <!--show-->
    </head>
    <body>
        <div id="container" style="width:330px">
        <input type="hidden" id="username" value="${param.name }">
        
         
           
            <div id="main">
                <!-- Main Content -->
                <h1 id="teamName"><b>Voice Room</b></h1>

                <!--show-->
                <div id="demoContainer">
                    <div id="connectControls">
                        <button class="btn btn-default" id="connectButton" onclick="connect()" ><span class="glyphicon glyphicon-earphone"></span></button>
                        <button class="btn btn-default" id="hangupButton" disabled="disabled" onclick="hangup()"><span class="glyphicon glyphicon-stop"></span></button>
                        <div id="iam"><b>접속 중이 아닙니다.</b></div>
                        <br />
                        <strong>접속 중인 유저</strong>
                        <div id="otherClients"></div>
                        <input  type="text" id="roomToAdd" placeholder="방 이름을 입력해주세요.">
                        <button id="connectButton" onclick="addRoom(null, null, true);" class="btn btn-default"><b>Join</b></button>
                    </div>

                    <!-- Note... this demo should be updated to remove video references -->
                    <div id="videos">
                        <video id="callerAudio"></video>
                        <div id="acceptCallBox"> <!-- Should be initially hidden using CSS -->
                            <div id="acceptCallLabel"></div>
                            <button id="callAcceptButton" >수락</button> <button id="callRejectButton">거절</button>
                        </div>
                    </div>
                </div>
                </div>
                </div>
    </body>
</html>
