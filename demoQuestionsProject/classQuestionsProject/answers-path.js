
var express = require("express");

var answerPath = express.Router();

//Get /answer (URL)

answerPath.get("/", function(request,response,next){

    console.log(request.url)
})

module.exports = answerPath;

