'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var QuestionSchema = new Schema({
	question: String,
	createdAt: {type: Date, default: Date.now},
	answer: String
});

var AnimalSchema = new Schema({
	name: String,
	type: String,
	age: Number,
	
})

var Question = mongoose.model("Question", QuestionSchema);

module.exports.Question = Question;













