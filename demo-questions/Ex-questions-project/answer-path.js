/*
    This js file is for request to the path /answera
*/

var express = require("express");
var answerpath = express.Router();

//GET answers
answerpath.get("/", function(req,resp,nect){
    console.log(req.url);
})

// allows others to require('answerpath')
module.exports = answerpath;