/*
this js file is for requests to the path /answers
*/

var express = require('express');
var answerPath = express.Router();

//Get /answers/
answerPath.get("/", function(req, resp, next){
    console.log(req.url);
})

//allows others to require ('answerPath')
module.exports = answerPath