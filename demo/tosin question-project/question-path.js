/* 
    This js file is for requests to the path /questions
*/

var express = require("express");
var questionPath = express.Router();

// Get /questions
questionPath.get("/hello", function(req, resp, next){
    console.log(req.url);
    Question.find({}).exec(
        function(err, questions){
            if(err) {
                return next(err);
            }
            resp.json(questions);
        }
    )
})

// allows others to require('questionPath')
module.exports = questionPath;