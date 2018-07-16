var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var ScoreSchema = new Schema({
    score: String,
    createdAt: { type: Date, default: Date.now }
});

var Score = mongoose.model("Score", ScoreSchema);

module.exports.Score = Score;