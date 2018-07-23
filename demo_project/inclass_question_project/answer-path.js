var express = require("express");
var answerPath = express.Router();

answerPath.get("/hellooo", function(req, resp, next){
    console.log(req.url);
})


//allow other to require(answer-path)
module.exports = answerPath;