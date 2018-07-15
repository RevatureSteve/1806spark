/*
    this js file is for qquests to the  path or questions
*/

var express = require('express');
var questionPath = express.Router();

questionPath.get('/', function(req, resp, next){
    console.log(req.url);
})

module.exports = questionPath;