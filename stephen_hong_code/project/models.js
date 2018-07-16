'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var PreviewSchema = new Schema({
	html: String,
	css: String,
	js: String,
	createdAt: {type: Date, default: Date.now}
});


var Preview = mongoose.model("Preview", PreviewSchema);

module.exports.Preview = Preview;













