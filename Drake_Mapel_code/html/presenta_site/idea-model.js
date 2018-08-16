var mongoose = require("mongoose");

var Schema = mongoose.Schema;

var IdeaSchema = new Schema({
    idea: String,
    vote: Number,
    downvote: Number
});

var Idea = mongoose.model("Idea", IdeaSchema);

module.exports.Idea = Idea;