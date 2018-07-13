'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var ReviewSchema = new Schema({
    header: String,
    author: String,
    movieTitle: String,
    reviewBody: String,
    commentsArr: []
});


var Review = mongoose.model("Review", ReviewSchema);

module.exports.Review = Review;













