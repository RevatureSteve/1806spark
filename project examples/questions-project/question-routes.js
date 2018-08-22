'use strict';

var express = require("express");
var router = express.Router();
var Question = require("./models").Question;



// GET /questions
// Route for questions collection
router.get("/", function(req, res, next){
	console.log('/questions');
	Question.find({})
				// .sort({createdAt: -1})
				.exec(function(err, questions){
					if(err) return next(err);
					res.json(questions);
				});
});

// POST /questions
// Route for creating questions
router.post("/", function(req, res, next){
	console.log('Creating new question');
	console.log(req.body);
	var question = new Question(req.body);
	console.log(question);
	question.save(function(err, question){
		if(err) return next(err);
		res.status(201);
		res.json(question);
	});
});

// GET /questions/:id
// Route for specific questions
router.get("/:qID", function(req, res, next){
	res.json(req.question);
});




// DELETE /questions/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.question.save(function(err, question){
			if(err) return next(err);
			res.json(question);
		});
	});
});



module.exports = router;
















