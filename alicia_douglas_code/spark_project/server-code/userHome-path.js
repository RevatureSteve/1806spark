var express = require('express');
var homePath = express.Router();
var Picture = require('./model').Picture;


// GET request
homePath.get('/', function(req,resp,next){
    console.log(req.url);
})



// POST Request
homePath.post('/', function(req,resp,next){
    console.log(req.url);
})