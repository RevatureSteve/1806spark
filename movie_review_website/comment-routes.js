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
    let comment = { comment: newComment, commentAuthor: newAuthor }

    if (newComment) {
        Review.findByIdAndUpdate(
            o_id,
            {
                $push: { "commentsArr": comment }
            },
            { "new": true, "upsert": true },
            function (err, managerparent) {
                if (err) throw err;
                console.log(managerparent);
            }
        );
    } else {
        var err = new Error("Not Found");
        err.status = 500;
        res.status(err.status || 500);
        res.json({
            error: {
                message: err.message
            }
        });
    }
});

module.exports = router;