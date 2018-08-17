/*
    This js file is for requests to the path /questions
*/

var express = require("express");
var questionPath = express.Router();
var Question = require('./question-model').Question;

// GET /questions/
questionPath.get("/", function(req, resp, next){
    console.log(req.url);
    Question.find({}).exec(
        function(err, questions){
            if(err) {
                return next(err);
            }
            resp.json({
                "question":"what is life"
            });
        });
})

// Create /questions/
questionPath.post("/", function(req, resp, next){
    console.log(req.url);
    var question = new Question(req.body);
    question.save(function(err, question){
        if(err){ 
            return next(err);
        }
        resp.status(201);
        resp.json(question);
    })
})


// allows others to require('questionPath' )
module.exports = questionPath; 