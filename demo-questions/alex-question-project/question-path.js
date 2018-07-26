/*
    This js file is for requests to the path/questions
*/

var express = require("express");
var questionPath = express.Router();
var Question = require("./question-model").Question;

// GET /questions/
questionPath.get("/", function(req, resp, next){
    console.log(req.url);
    
})

// Create /questions/
questionPath.post("/", function(req, resp, next){
    console.log(req.url);
    var question = new Question(req.body);
    question.save(function(err, question){
        if(err){
            return next(err); // can be omitted, just for good practice
        }
        resp.status(201); // 201 means created
        resp.json(question);
    });
})


// allows others to require('questionPath')
module.exports = questionPath; 