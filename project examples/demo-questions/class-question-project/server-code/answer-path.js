/*
    This js file is for requests to the path /questions
*/

var express = require("express");
var answerPath = express.Router();

// GET /answer/hello
answerPath.get("/hello", function(req, resp, next){
    console.log(req.url);
})


// allows others to require('answerPath' )
module.exports = answerPath; 