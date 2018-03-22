

//
//Copyright (c) 2016, Skedans Systems, Inc.
//All rights reserved.
//
//Redistribution and use in source and binary forms, with or without
//modification, are permitted provided that the following conditions are met:
//
//    * Redistributions of source code must retain the above copyright notice,
//      this list of conditions and the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright
//      notice, this list of conditions and the following disclaimer in the
//      documentation and/or other materials provided with the distribution.
//
//THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
//AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
//IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
//ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
//LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
//CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
//SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
//INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
//CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
//ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
//POSSIBILITY OF SUCH DAMAGE.
//
var selfEasyrtcid = "";
//웨이팅포룸리스트는 트루
var waitingForRoomList = true;
//isConnected는 펄스
var isConnected = false;

 





function disable(domId) {
	document.getElementById(domId).disabled = "disabled";
}

function enable(domId) {
	document.getElementById(domId).disabled = "";
}

function connect() {
	easyrtc.setSocketUrl(":1313");
	console.log("Initializing.");
	easyrtc.enableVideo(false);
	easyrtc.enableVideoReceive(false);
	easyrtc.setRoomOccupantListener(convertListToButtons);
	easyrtc.initMediaSource(function() { // success callback
		easyrtc.connect("easyrtc.audioOnly", loginSuccess, loginFailure);

	}, function(errorCode, errmesg) {
		easyrtc.showError(errorCode, errmesg);
	} // failure callback
	);
}



function terminatePage() {
	easyrtc.disconnect();
}

function hangup() {
	easyrtc.hangupAll();
	disable('hangupButton');
}



function clearConnectList() {
	otherClientDiv = document.getElementById('otherClients');
	while (otherClientDiv.hasChildNodes()) {
		otherClientDiv.removeChild(otherClientDiv.lastChild);
	}

}

function genRoomDivName(roomName) {
    return "roomblock_" + roomName;
}
//방이름 리턴!
function genRoomOccupantName(roomName) {
    return "roomOccupant_" + roomName;
}


function addRoom(roomName, parmString, userAdded) {
    //룸네임이 없으면
		if (!roomName) {
			//room to add 값을 roomname 에 너는다
        roomName = document.getElementById("roomToAdd").value;
				//paramString 에 optroomparams값을 넣는다.
        parmString = null;
    }
		//룸id 에 "roomblock"+roomName
    var roomid = genRoomDivName(roomName);
    if (document.getElementById(roomid)) {
        return;
    }
		//addRommButton function
				

    var roomParms = null;
    if (parmString && parmString !== "") {
        try {
            roomParms = JSON.parse(parmString);
        } catch (error) {
            roomParms = null;
            easyrtc.showError(easyrtc.errCodes.DEVELOPER_ERR, "Room Parameters must be an object containing key/value pairs. eg: {\"fruit\":\"banana\",\"color\":\"yellow\"}");
            return;
        }
    }
    if (!isConnected || !userAdded) {
        console.log("adding gui for room " + roomName);
    }
    else {
        console.log("not adding gui for room " + roomName + " because already connected and it's a user action");
    }
    if (userAdded) {
        console.log("calling joinRoom(" + roomName + ") because it was a user action ");

        easyrtc.joinRoom(roomName, roomParms,
                function() { 
                 	document.getElementById("iam").innerHTML = roomName+"방에 입장하였습니다.";    	 	
                },
                function(errorCode, errorText, roomName) {
                    easyrtc.showError(errorCode, errorText + ": room name was(" + roomName + ")");
                });
    }
}



function convertListToButtons(roomName, occupants, isPrimary) {
	clearConnectList();
	var otherClientDiv = document.getElementById('otherClients');
	for ( var easyrtcid in occupants) {
		var button = document.createElement('button');
		button.onclick = function(easyrtcid) {
			return function() {
				performCall(easyrtcid);
			};
		}(easyrtcid);

		var label = document.createElement('text');
		var name = document.getElementById("username").value;
		label.innerHTML = easyrtc.idToName(easyrtcid);
		button.appendChild(label);
		otherClientDiv.appendChild(button);
	}
}

function performCall(otherEasyrtcid) {
	easyrtc.hangupAll();
	var acceptedCB = function(accepted, caller) {
		if (!accepted) {
			easyrtc.showError("CALL-REJECTED", "상대방이 요청을 거절하였습니다. ");
			enable('otherClients');
		}
	};
	var successCB = function() {
		enable('hangupButton');
	};
	var failureCB = function() {
		enable('otherClients');
	};
	easyrtc.call(otherEasyrtcid, successCB, failureCB, acceptedCB);
}

function loginSuccess(easyrtcid) {
	easyrtcid =document.getElementById("username").value;
	console.log(easyrtcid+"이것은 큐야!");
	disable("connectButton");
	// enable("disconnectButton");
	enable('otherClients');
	selfEasyrtcid = easyrtcid;
	document.getElementById("iam").innerHTML = easyrtcid+"님! 접속하셨습니다.";
}

function loginFailure(errorCode, message) {
	easyrtc.showError(errorCode, message);
}

function disconnect() {
	document.getElementById("iam").innerHTML = "logged out";
	easyrtc.disconnect();
	console.log("disconnecting from server");
	enable("connectButton");
	// disable("disconnectButton");
	clearConnectList();
}

easyrtc.setStreamAcceptor(function(easyrtcid, stream) {
	var audio = document.getElementById('callerAudio');
	easyrtc.setVideoObjectSrc(audio, stream);
	enable("hangupButton");
});

easyrtc.setOnStreamClosed(function(easyrtcid) {
	easyrtc.setVideoObjectSrc(document.getElementById('callerAudio'), "");
	disable("hangupButton");
});

easyrtc.setAcceptChecker(function(easyrtcid, callback) {
        	easyrtcid =document.getElementById("username").value;
			document.getElementById('acceptCallBox').style.display = "block";
			if (easyrtc.getConnectionCount() > 0) {
				document.getElementById('acceptCallLabel').textContent = "Drop current call and accept new from "
						+ easyrtcid + " ?";
			} else {
				document.getElementById('acceptCallLabel').textContent = 
						"/'"+ easyrtcid + "/'님에게 보이스채팅 요청이 왔습니다.";
			}
			var acceptTheCall = function(wasAccepted) {
				document.getElementById('acceptCallBox').style.display = "none";
				if (wasAccepted && easyrtc.getConnectionCount() > 0) {
					easyrtc.hangupAll();
				}
				callback(wasAccepted);
			};
			document.getElementById("callAcceptButton").onclick = function() {
				acceptTheCall(true);
			};
			document.getElementById("callRejectButton").onclick = function() {
				acceptTheCall(false);
			};
		});
