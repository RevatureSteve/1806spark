var express = require("express");
var commentPath = express.Router();
var Comment = require("./comment_model").Comment;

//GET Comment

commentPath.get("/", function (req, resp, next) {
    console.log("GET -/jungle");
    Comment.find({}).exec(function (err, comments) {
        if (err) {
            return next(err);
        }
        resp.json(comments);
    });
});

//Create Comment

commentPath.post("/", function (req, resp, next) {
    console.log('POST -Creating new comment');
    console.log(req.body);
    var comment = new Comment(req.body);
    console.log(comment);

    comment.save(function (err, comment) {
        if (err) {
            return next(err);
        }
        resp.status(201);
        resp.json(comment);
    });
});

module.exports = commentPath;