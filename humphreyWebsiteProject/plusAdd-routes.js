
var express = require("express");
var addMovieRoutes = express.Router();
var Movie = require("./models").Movie;



// GET /questions
// Route for questions collection
addMovieRoutes.get("/", function(req, res, next){
	console.log(req.url);
	Movie.find({})
				// .sort({createdAt: -1})
				.exec(function(err, findMovie){
					if(err) return next(err);
					res.json(findMovie);
				});
});

// POST /questions
// Route for creating questions
addMovieRoutes.post("/", function(req, res, next){
	console.log('Creating new movie');
	console.log(req.body);
	var createdMovie = new Movie(req.body);
	console.log(createdMovie);
	createdMovie.save(function(err, newMovie){
		if(err) return next(err);
		console.log("successfully saved");
		res.status(201);
		res.json(newMovie);
		
	});
});

// GET /questions/:id
// Route for specific questions
addMovieRoutes.get("/:qID", function(req, res, next){
	res.json(req.newMovie);
});




// DELETE /questions/:qID/answers/:aID
// Delete a specific answer
addMovieRoutes.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.createdMovie.save(function(err, movieDB){
			if(err) return next(err);
			res.json(movieDB);
		
		});
	});
});



module.exports = addMovieRoutes;





