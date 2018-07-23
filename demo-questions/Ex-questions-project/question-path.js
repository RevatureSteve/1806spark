/*
     This js file is for request to the path /questions
*/

var express = require("express");
var questionpath = express.Router();
var Question = require('./question-model').Question;

// GET /questions/
questionpath.get("/", function(req, resp, next){
    console.log(req.url);
    Question.find({}).exec(
        function(err, questions){
            if(err) {
                return next(err);
            }
            resp.json(questions);
        });
})

// Create /questions/
questionpath.post("/", function(req, resp, next){
    console.log(req.url);
    var question = new Question(req.body);
    question.save(function(err, question){
        if(err){
            return next(err);
        }
        resp.status(201);
        res.json(questions);
    })
})

// allows others to require('questionpath' )
module.exports = questionpath;