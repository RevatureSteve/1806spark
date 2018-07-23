'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var FeedbackSchema = new Schema({
	feedback: String,
	createdAt: {type: Date, default: Date.now}
});


var Feedback = mongoose.model("Feedback", FeedbackSchema);

module.exports.Feedback = Feedback;

