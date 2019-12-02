var map = new HashMap();
var line = new HashMap();
var vm = new Vue({
	el : "#wrapper",
	data : {
		heartData : [],
		heartAbnormal : false,
		breathAbnormal : false
	},
	created : function() {
		this.initWebSocketHander();
		this.initDataTimeOut();
	},
	methods : {
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
				var data = JSON.parse(e.data);
				var timeDate = vm.getDate();
				data.time = timeDate;
				data.index = map.size() + 1;
				data.heartAbnormal = 0;
				data.breathAbnormal = 0;
				data.offline = false;
				if (parseInt(data.heart) < 100) {
					if (parseInt(data.heart) > 60) {
						data.heartAbnormal = 1;
					}
					if (parseInt(data.heart) == 0) {
						data.heartAbnormal = 1;
					}
				}
				if (parseInt(data.breath) < 20) {
					if (parseInt(data.breath) > 16) {
						data.breathAbnormal = 1;
					}
					if (parseInt(data.breath) == 0) {
						data.breathAbnormal = 1;
					}
				}
				map.put(data.userId, data);
				var online = map.values().sort(function(a, b) {
					var dt1 = a.userId;
					var dt2 = b.userId;
					if (dt1 > dt2)
						return 1;
					return -1;
				});
				var offline = line.values().sort(function(a, b) {
					var dt1 = a.userId;
					var dt2 = b.userId;
					if (dt1 > dt2)
						return 1;
					return -1;
				});
				var temp = new Array();
				for ( var oIndex in online) {
					var online1 = online[oIndex];
					temp.push(online1);
				}
				for ( var oIndex in offline) {
					var offline1 = offline[oIndex];
					if (data.userId == offline1.userId) {
						line.remove(data.userId);
					} else {
						temp.push(offline1);
					}
				}
				vm.heartData = temp;
			}
			socket.onclose = function() {
				console.log("channel onclose");
			}
		},
		initDataTimeOut : function() {
			setInterval(function() {
				var timeDate = vm.getDate();
				for ( var index in map.values()) {
					var details = map.values()[index];
					if (typeof (details.time) != "undefined"
							&& details.time != null) {
						var timeMinutes5 = timeDate - details.time;
						if (Math.abs(timeMinutes5) > 5) {
							details.offline = true;
							line.put(details.userId, details);
							map.remove(details.userId);
						}
					}
				}
			}, 300000);
		},
		getDate : function() {
			var time = new Date();
			var hours = time.getHours()
			var minutes = time.getMinutes();
			if (minutes < 10) {
				minutes = '0' + minutes;
			}
			var timeDate = hours * 60 + minutes;
			return timeDate;
		}

	}
});