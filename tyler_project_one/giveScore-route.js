var express = require("express");
var giveScore = express.Router();

giveScore.get("/", function (req, resp, next){
    console.log(req.url);
})

module.exports = giveScore;