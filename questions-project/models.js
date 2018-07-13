'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var QuestionSchema = new Schema({
	question: String,
	createdAt: {type: Date, default: Date.now},
	answer: String
});


var Question = mongoose.model("Question", QuestionSchema);

module.exports.Question = Question;













