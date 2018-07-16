var express = require('express');
var homePath = express.Router();
var Posts = require('./model').Posts;

homePath.get("/", function(req, resp, next){
    console.log(req.url);
    Posts.find({}).exec(
        function(err, posts){
            if(err) {
                return next(err);
            }
            resp.json(posts);
        }
    )
})

homePath.post("/", function(req, resp, next){
    console.log("new post");
    console.log(req.url);
    var posts = new Posts(req.body);
    posts.save(function(err, posts){
        if(err) {
            return next(err);
        }
        resp.status(201);
        resp.json(posts);
    });
});

module.exports = homePath;
