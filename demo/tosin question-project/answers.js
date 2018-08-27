var express = require('express');
var answers = express.Router();

answers.get("/", function(req, resp, next){
    console.log(req.url);
});

module.exports = answers;

