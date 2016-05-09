var gulp = require('gulp');
var pjson = require('./package.json');
var xeditor = require("gulp-xml-editor");
var pluginXml = 'plugin.xml';
console.log('Updating '+pluginXml+' version to ', pjson.version);


gulp.src("./" + pluginXml)
  .pipe(xeditor(function(xml) {
    var elem = xml.root();
    elem.attr('version').value(pjson.version);
    console.log('version updated to %s', elem.attr('version').value());
    return xml;
  }))
  .pipe(gulp.dest("./"));
