var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var CommentSchema = new Schema({
	name: String,
	createdAt: {type: Date, default: Date.now},
	comment: String
});

var Comment = mongoose.model("Comment", CommentSchema);

module.exports.Comment = Comment;