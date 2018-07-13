// required modules
var express = require('express');

var answerPath = express.Router();

answerPath.use('/', (req, resp, next) =>{
    console.log(req.url);
});

module.exports = answerPath;