'use strict';

var express = require("express");
var router = express.Router();
var Comment = require("./models").Comment;

// GET /Comments
// Route for Comments collection
router.get("/", function(req, res, next){
	console.log('/Comments');
	Comment.find({})
				// .sort({createdAt: -1})
				.exec(function(err, comments){
					if(err) return next(err);
					res.json(comments);
				});
});

// POST /Comments
// Route for creating Comments
router.post("/", function(req, res, next){
	console.log('Creating new Comment');
	console.log(req.body);
	var comment = new Comment(req.body);
	console.log(Comment);
	comment.save(function(err, comment){
		if(err) return next(err);
		res.status(201);
		res.json(comment);
	});
});

// GET /Comments/:id
// Route for specific Comments
router.get("/:qID", function(req, res, next){
	res.json(req.comment);
});




// DELETE /Comments/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.comment.save(function(err, comment){
			if(err) return next(err);
			res.json(comment);
		});
	});
});



module.exports = router;
















