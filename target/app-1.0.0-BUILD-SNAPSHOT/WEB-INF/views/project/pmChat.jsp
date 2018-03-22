<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 
<script type="text/javascript">
 
    var chatSock = null;
 
    $(document).ready(function () {
        // 페이지가 시작됨과 동시에 소켓 서버 주소로 접속한다.
        chatSock = new SockJS("/board/echo-ws");
        chatSock.onopen = function () {
             
            message = {};
            message.message = "반갑습니다~";
            message.type = "all";
            message.to = "all";
             
            chatSock.send( JSON.stringify(message) );
        };
         
        chatSock.onmessage = function (evt) {
            $("#chatMessage").append(evt.data + "<br/>");
            $("#chatMessage").scrollTop(99999999);
        };
         
        chatSock.onclose = function () {
            //sock.send("10.225.152.164 퇴장합니다~~~");
        };
         
        $("#message").keydown(function (key) {
            if (key.keyCode == 13) {
                $("#sendMessage").click();
            }
        });
         
        $("#sendMessage").click(function () {
            if ( $("#message").val() != "") {
                message = {};
                message.message = $("#message").val();
                message.type = "all";
                message.to = "all"
                 
                var to = $("#to").val();
                if (to != "" ) {
                    message.type = "one";
                    message.to = to;
                }
                 
                chatSock.send( JSON.stringify(message) );
                $("#chatMessage").append("나 -> "+ $("#message").val() + "<br/>");
                $("#chatMessage").scrollTop(99999999);
                 
                $("#message").val("");
            }
        });
    });
     
</script>
</head>
<body>
    <input type="text" id="to" placeholder="귓속말" />
    <input type="text" id="message" placeholder="메시지" />
    <input type="button" id="sendMessage" value="메시지 보내기" />
     
    <div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>
</body>
</html>


