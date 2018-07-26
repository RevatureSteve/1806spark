/*
    This js file is for requests to the path/questions
*/

var express = require("express");
var answersPath = express.Router();

// GET /answers/
answersPath.get("/hello", function(req, resp, next){
    console.log(req.url);
})


// allows others to require('answersPath')
module.exports = answersPath;