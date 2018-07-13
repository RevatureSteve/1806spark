'use strict';

var express = require("express");
var router = express.Router();
var Review = require("./models").Review;

// GET /reviews
// Route for reviews collection
router.get("/", function (req, res, next) {
    console.log('/comments');
    Review.find({})
        // .sort({createdAt: -1})
        .exec(function (err, reviews) {
            if (err) return next(err);
            res.json(reviews);
        });
});

// POST /reviews
// Route for creating reviews
router.post("/", function (req, res, next) {
    let ObjectId = require('mongodb').ObjectId;
    let id = req.body.id;
    let o_id = new ObjectId(id);

    console.log('Creating new comment');
    console.log(req.body.id);
    // Review.updateOne({_id : o_id}, {$push: {"commentsArr": 
    //     {"comment": "new review", "commentAuthor": "unknown"}}})
 
    
    let testComment = {comment: "new comment", commentAuthor: "unknown"};
    console.log(testComment); this code does not work right now between brackets
    Review.update(
        { _id: o_id },
        {
            $push: { commentsArr: testComment }
        }
    ); this code does not work rn
    console.log('successful find');
    res.json(Review.find({ _id: o_id }));
    
    // reviewToComment.commentsArr[reviewToComment.commentsArr.length]
    //     = { "comment": req.body.comment, "commentAuthor": "undefined yet" };

    // var review = new Review(req.body);
    // console.log(review);
    // review.save(function(err, review){
    // 	if(err) return next(err);
    // 	res.status(201);
    // 	res.json(review);
    // });
});

// GET /reviews/:id
// Route for specific reviews
router.get("/:qID", function (req, res, next) {
    res.json(req.review);
});


// DELETE /reviews/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function (req, res) {
    req.answer.remove(function (err) {
        req.review.save(function (err, review) {
            if (err) return next(err);
            res.json(review);
        });
    });
});

module.exports = router;
















