//cordova.define("sv-plugins-indooratlas.IndoorAtlas", function(require, exports, module) {
var exec = require('cordova/exec');

exports.echo = function(arg0, success, error) {
  exec(success, error, "IndoorAtlas", "echo", [arg0]);
};

exports.current = function(arg0, success, error) {
  exec(success, error, "IndoorAtlas", "current", [arg0]);
};

exports.echojs = function(arg0, success, error) {
  // Do something
  success(arg0);
};

//});
