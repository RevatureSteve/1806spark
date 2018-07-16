'use strict';

var express = require("express");
var router = express.Router();
// Preview models is for mongoose
var Preview = require("./models").Preview;

// GET /preview
// Route for preview collection
router.get("/", function(req, res, next){
	console.log('/preview');
	Preview.find({})
				// .sort({createdAt: -1})
				.exec(function(err, preview){
					if(err) return next(err);
					res.json(preview);
				});
});

// POST /preview
// Route for creating preview
router.post("/", function(req, res, next){
	console.log('Creating new question');
	console.log(req.body);
	var preview = new Preview(req.body);
	console.log(preview);
	preview.save(function(err, preview){
		if(err) return next(err);
		res.status(201);
		res.json(preview);
	});
});











// GET /preview/:id
// Route for specific preview
// router.get("/:qID", function(req, res, next){
// 	res.json(req.preview);
// });


// DELETE /questions/:qID/answers/:aID
// Delete a specific answer
// router.delete("/:qID/answers/:aID", function(req, res){
// 	req.answer.remove(function(err){
// 		req.question.save(function(err, question){
// 			if(err) return next(err);
// 			res.json(question);
// 		});
// 	});
// });



module.exports = router;
















