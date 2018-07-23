



var express = require("express");
var answerPath = express.Router();

//GET /answers/
answerPath.get("/answer", function(req,resp,next){
    console.log("Answer Path Accessed!");
    console.log(req.url);
})

module.exports = answerPath;