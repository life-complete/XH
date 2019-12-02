var HashMap = function() {
	this.elements = new Array();
}
HashMap.prototype = {
	size : function() {
		return this.elements.length;
	},
	isEmpty : function() {
		return (this.elements.length < 1);
	},
	clear : function() {
		this.elements = new Array();
	},
	put : function($key, $value) {
		if (this.containsKey($key)) {
			this.remove($key);
		}
		this.elements.push({
			key : $key,
			value : $value
		});
	},
	remove : function($key) {
		try {
			for (var i = 0; this.elements.length; i++) {
				if (this.elements[i].key == $key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	},
	get : function($key) {
		try {
			for (var i = 0; this.elements.length; i++) {
				if (this.elements[i].key == $key) {
					return this.elements[i].value;
				}
			}
		} catch (e) {
			return null;
		}
	},
	element : function(index) {
		if (index < 0 || index >= this.elements.length) {
			return null;
		}
		return this.elements[index];
	},
	containsKey : function($key) {
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == $key) {
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	},
	containsValue : function($value) {
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].value == $value) {
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	},
	values : function() {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	},
	keys : function() {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	},
	sortByAsc : function() {
		this.values().sort(function(a, b) {
			var dt1 = a.userId;
			var dt2 = b.userId;
			if (dt1 == dt2)
				return 0;
			return 1;
		});
	},
	sortByDes : function() {
		this.values().sort(function(a, b) {
			var dt1 = a.userId;
			var dt2 = b.userId;
			if (dt1 == dt2)
				return 0;
			return -1;
		});
	}
}