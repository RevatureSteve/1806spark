
var express = require("express");
var scorePath = express.Router();
var Score = require('./score-model').Score;

scorePath.get("", function(req,resp,next){
    console.log(req.url);
    Score.find({}).exec(
        function(err, score){
            if(err){
                return next(err);
            } else {
                resp.json(score);
            }
        }
    )
})

scorePath.post("/", function (req, resp, next) {
    console.log(req.url);
    var aScore = new Score(req.body);
    aScore.save(function (err, aScore) {
        if (err) {
            return next(err);
        }
        resp.status(201);
        resp.json(aScore);
    })
})

module.exports = scorePath;