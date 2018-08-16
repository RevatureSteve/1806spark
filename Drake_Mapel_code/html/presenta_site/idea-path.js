var express = require("express");
var ideaPath = express.Router();
var Idea = require("./idea-model").Idea;

ideaPath.get("/", (req, resp, next) => {
    console.log(req.url);
    Idea.find({}).exec(
        (err, idea) => {
            if (err) {
                return next(err);
            }
            resp.json(idea);
        }
    );
});

ideaPath.post("/", (req, resp, next) => {
    console.log(req.url);
    var idea = new Idea(req.body);
    idea.save( (err, idea) => {
        if (err) {
            return next(err);
        }
        resp.status(201);
        resp.json(idea);
    });
});

module.exports = ideaPath;