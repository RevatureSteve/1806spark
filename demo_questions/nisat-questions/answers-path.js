//this js file is for requests to the path/answers
var express = require('express');
var answersPath = express.Router();

//GET /questions/hello
// questionPath.get("/hello")
answersPath.get("/hello", function(req, resp, next){
    console.log(req.url);
});

//allows others to require ('questionPath')
module.exports = answersPath;