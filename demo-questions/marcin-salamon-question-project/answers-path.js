/*
    this js file is for answer to the  path or answers
*/

var express = require('express');
var answerPath = express.Router();

answerPath.get('/', function(req, resp, next){
    console.log(req.url);
})

module.exports = answerPath;