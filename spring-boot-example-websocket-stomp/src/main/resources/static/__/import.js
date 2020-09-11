var __ = {};
~function() {
	__.ctx = (function() {
		var scripts = document.getElementsByTagName('script'), src = scripts[scripts.length - 1].src;
		return src.substring(0, src.length - '/__/import.js'.length);
	})();
	document.writeln('<script src="' + __.ctx + '/__/sockjs/1.5.0/sockjs.min.js"></script>');
	document.writeln('<script src="' + __.ctx + '/__/stomp/2.3.3/stomp.min.js"></script>');
}();