/*
    This js file is for requests to the path /answers
*/

var express = require("express");
var answerPath = express.Router();

// GET /answers
answerPath.get("/hello", function(req, resp, next) {
    console.log(req.url);
});


// Allows others to require("answerPath")
module.exports = answerPath;