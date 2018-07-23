
var express = require("express");
var addMovieRoutes = express.Router();
var Movie = require("./models").Movie;



// GET recently added movies
// Route for Pundit movie collection
addMovieRoutes.get("/", function(req, res, next){
	console.log(req.url);
	Movie.find({})
				// .sort({createdAt: -1})
				.exec(function(err, findMovie){
					if(err) return next(err);
					res.json(findMovie);
				});
});

// POST new movies
// Route for adding movies to database
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

module.exports = addMovieRoutes;





