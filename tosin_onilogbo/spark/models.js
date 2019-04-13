'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var AlbumSchema = new Schema({
	title: String,
	artist: String,
	genre: String,
	year: String,
	review: String,
	comment: []
});


var Comment = mongoose.model("Comment", AlbumSchema);

module.exports.Comment = Comment;













