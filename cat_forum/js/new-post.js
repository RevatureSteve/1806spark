//this js file is for requests to the path/questions
var express = require('express');
var newPost = express.Router();
var Post = require("./post-model").Question;

//GET /questions/hello
// questionPath.get("/hello")
newPost.get("/", function(req, resp, next){
    console.log(req.url);
    Post.find({}).exec(
        function(err, questions)
        if(err) {
            return next(err);
        }
        resp.json({
            "questions":"what is life"
        });
    ));
})

//create /questions change get to post to get ?
newPost.post("/", function(req, resp, next){
    console.log(req.url);
    var post = new Post(req.body);
    //new means instantiating a new object
    post.save(function(err,post){
        if(err) {
            return next(err);//not necessary
        }
        resp.status(201);
        resp.json(question);
    })
})

//allows others to require ('questionPath')
module.exports = newPost;