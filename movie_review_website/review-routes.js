'use strict';

var express = require("express");
var router = express.Router();
var Review = require("./models").Review;

// GET /reviews
// Route for reviews collection
router.get("/", function(req, res, next){

	Review.find({})
				// .sort({createdAt: -1})
				.exec(function(err, reviews){
					if(err) return next(err);
                    res.json(reviews);
				});
});

// POST /reviews
// Route for creating reviews
router.post("/", function(req, res, next){
	var review = new Review(req.body);
	review.save(function(err, review){
		if(err) return next(err);
		res.status(201);
		res.json(review);
	});
});

// GET /reviews/:id
// Route for specific reviews
router.get("/:qID", function(req, res, next){
	res.json(req.review);
});


// DELETE /reviews/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.review.save(function(err, review){
			if(err) return next(err);
			res.json(review);
		});
	});
});

module.exports = router;