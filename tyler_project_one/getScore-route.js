var express = require("express");
var getScore = express.Router();
var Score = require('./score-model').Score;

getScore.get("/", function (req, resp, next){
    console.log(req.url);
    Score.find({})
        .exec(function(err, scoreSaver){
            if(err){
                return next(err);
            }
            resp.json(scoreSaver);
        });
});

getScore.post("/", function(req, resp, next){
    console.log(req.url);
    var score = new Score(req.body);
    score.save(function(err, scoreSaver){
        if (err){
            return next(err);
        }
        resp.status(201);
        resp.json(scoreSaver);
    });
});

module.exports = getScore;

