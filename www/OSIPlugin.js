var exec = require('cordova/exec');

function OSIPlugin() { 
	console.log("OSIPlugin.js: is created");
}


OSIPlugin.prototype.getAPILevel = function(success, error){
	exec(success, error, "OSIPlugin", 'getAPILevel', []);
}


// FIRE READY //
exec(function(result){ console.log("OSIPlugin Ready OK") }, function(result){ console.log("OSIPlugin Ready ERROR") }, "OSIPlugin",'ready',[]);





var osiPlugin = new OSIPlugin();
module.exports = osiPlugin;
