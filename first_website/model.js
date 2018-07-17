/* 
    This file is a model to structure the data that'll be stored in 
    NoSQL - in the mongoose DB
*/
var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var FitnessSchema = new Schema({
    rating: String,
    createdAt: { type: Date, default: Date.now},
    pros: String,
    cons: String
});

var Fitness = mongoose.model("Fitness", FitnessSchema);

module.exports.Fitness = Fitness;