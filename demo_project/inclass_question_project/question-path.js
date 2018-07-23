// this js file is for request path/qusetions

var express = require('express');
var qusetionPath = express.Router();
var question = require('./question-models').question;

// GET /questions/hello
qusetionPath.get("/", function(req, resp, next){
    console.log(req.url);
})

//allow other to require(question-path)
qusetionPath.post("/", function(req, resp, next){
    console.log(req.url);
    var question = new question(req.body);
    question.save(function(err, question){
        if(err) return next(err);
        resp.status(201);
        resp.json(question);
    })
})

//allow other to require(question-path)
module.exports = qusetionPath;