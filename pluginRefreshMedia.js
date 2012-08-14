//Create s singleton class
var refreshMedia = function() {
};

// Dynamically add a method to prototype.
refreshMedia.refresh = function(url) {
	PhoneGap.exec(function() {
		alert("Working!");
	}, function() {
		alert("Not working... so sad");
	}, "pluginRefreshMedia", "refresh", [ url ]);
};
