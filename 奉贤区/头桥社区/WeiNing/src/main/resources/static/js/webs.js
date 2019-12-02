var RTC = {
	test : function() {
		navigator.webkitGetUserMedia({
			video : true
		}, function(stream) {
			$("#localVideo").src = webkitURL.createObjectURL(stream);
		}, function(error) {
			console.log("不支持媒体流～ ", error);
		});
	},
	initWebSocketHander : function() {
		var socket = null;
		if ('WebSocket' in window)
			socket = new WebSocket("ws://" + location.host + "/montior");
		else
			socket = new SockJS('/sockjs/montior');
		socket.onopen = function() {
			console.log("channel onopen");
		}
		socket.onmessage = function(e) {
			console.log(e);
		}
		socket.onclose = function() {
			console.log("channel onclose");
		}
	}
}

var a = RTC.test(); 


