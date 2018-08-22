// This JS file is for requests to the path /questions

var express = require("express");
var questionPath = express.Router();
var Question = require('./question-model').Question;


// GET /questions/
questionPath.get('/', (req,resp,next) =>{
    console.log(req.url);
    Question.find({}).exec((err,questions) =>{
        if(err){
            return next(err);
        }
        resp.json(questions);
    })
});

questionPath.post('/',(req,resp,next) =>{
    console.log(req.url);
    let question = new Question(req.body);
    question.save((err,question)=>{
        if (err) {
            return next(err);
        }
        // 201 means okay, created
        resp.status(201);
        resp.json(question);
    })
});
// Need to be listed to be required by other files
// allows require('questionPath')
module.exports = questionPath;

