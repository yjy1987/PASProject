var wsocket;
var msg;
var loginUserId;
function connect() {
			wsocket = new SockJS(

					"http://"+document.domain+":8181/conSocket.sockjs");
			wsocket.onopen = onOpen;
			wsocket.onmessage = onMessage;
			wsocket.onclose = onClose;
	}
	
	function disconnect() {
		wsocket.close();
	}
	
	function onOpen(evt) {
		
	}
	
	function onMessage(evt) {
		/*alert(evt);
		alert(evt.data);
		var d = JSON.parse(evt.data);
		alert(d.push);
		var data = evt.data;*/
		pushMessage();

	}
	function onClose(evt) {
		appendMessage("연결을 끊었습니다.");
	}
	
	function send(msg) {
		wsocket.send(msg);
	}

	function appendMessage(msg) {
		$("#chatMessageArea").append(msg+"<br>");
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}