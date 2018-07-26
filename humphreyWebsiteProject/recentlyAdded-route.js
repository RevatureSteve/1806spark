var express = require("express");
var recentlyAddedPath = express.Router();
var Movie = require("./models").Movie;

//Get /answer (URL)

recentlyAddedPath.get("/", function(req, res, next){
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
recentlyAddedPath.post("/", function(req, res, next){
	console.log('Creating new movie');
	console.log(req.body);
	var createdMovie = new Movie(req.body);
	console.log(createdMovie);
	createdMovie.save(function(err, newMovie){
		if(err) return next(err);
		res.status(201);
		res.json(newMovie);
	});
});

module.exports = recentlyAddedPath;