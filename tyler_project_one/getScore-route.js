var express = require("express");
var getScore = express.Router();
var Score = require('./score-model').Score;

getScore.get("/", function (req, resp, next){
    console.log(req.url);
    Score.find({})
        .exec(function(err, scores){
            if(err){
                return next(err);
            }
            res.json(scores);
        });
});

getScore.post("/", function(req, resp, next){
    console.log(req.url);
    var score = new Score(req.body);
    score.save(function(err, question){
        if (err){
            return next(err);
        }
        resp.status(201);
        resp.json(score);
    });
});

module.exports = getScore;

