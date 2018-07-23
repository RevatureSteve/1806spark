/* 
    this js file is for requests to the path / questions.
*/

var express = require("express");
var questionPath = express.Router(); //specifies "where should I send your request?"
//             use this file name + this specific object within
var Question = require('./server-code/question-model').Question;

// GET /questions/
questionPath.get("/", function(req,resp,next){
    ;console.log(req.url);
    Question.find({}).exec(
        function(err,questions){
            if (err){
                return next(err);
            }
            resp.json(questions);
        }
    )
})

// Create /questions/
questionPath.post("/", function(req,resp,next){
    ;console.log(req.url);
    // creation of a new object
    var question = new Question(req.body);
    question.save(function(err,question){
        if(err){
            return next(err);
        }
         //add the error handler where it need be
        resp.status(201); //201 means that the object has been created
        resp.json(question);
    })
})


/* 
THIS HAS TO BE EXPORTED LIKE THIS IN ORDER TO BE REQUIRED.
Allows other files to require('questionPath')
*/
module.exports = questionPath; 