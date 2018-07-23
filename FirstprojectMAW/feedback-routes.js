'use strict';

var express = require("express");
var router = express.Router();
// Feedback models is for mongoose
var Feedback = require("./models").Feedback;



// GET /feedback
// Route for feedback collection
router.get("/", function(req, res, next){
	console.log('/feedback');
	// Mongo stuff below
	Feedback.find({})
				// .sort({createdAt: -1})
				.exec(function(err, feedback){
					if(err) return next(err);
					res.json(feedback);
				});
});

// POST /feedback
// Route for creating feedback
router.post("/", function(req, res, next){
	console.log('Creating new feedback');
	console.log(req.body);
	var feedback = new Feedback(req.body);
	console.log(feedback);
	feedback.save(function(err, feedback){
		if(err) return next(err);
		res.status(201);
		res.json(feedback);
	});
});

// GET /feedback/:id
// Route for specific feedback
router.get("/:fID", function(req, res, next){
	res.json(req.feedback);
});

module.exports = router;


// DELETE /questions/:qID/answers/:aID
// Delete a specific answer
//router.delete("/:qID/answers/:aID", function(req, res){
	//req.answer.remove(function(err){
		//req.question.save(function(err, question){
			//if(err) return next(err);
			//res.json(question);
		//});
	//});
//});

