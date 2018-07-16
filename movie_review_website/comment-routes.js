'use strict';

var express = require("express");
var router = express.Router();
var Review = require("./models").Review;

router.post("/", function (req, res, next) {
    let ObjectId = require('mongodb').ObjectId;
    let id = req.body.id;
    let o_id = new ObjectId(id);

    let newComment = req.body.comment;
    let newAuthor = req.body.commentAuthor;

    Review.findByIdAndUpdate(
        o_id,
        {
            $push: { "commentsArr": newComment }
        },
        { "new": true, "upsert": true },
        function (err, managerparent) {
            if (err) throw err;
            console.log(managerparent);
        }
    );
    Review.findByIdAndUpdate(
        o_id,
        {
            $push: { "commentsAuthors": newAuthor }
        },
        { "new": true, "upsert": true },
        function (err, managerparent) {
            if (err) throw err;
            console.log(managerparent);
        }
    );
});

module.exports = router;