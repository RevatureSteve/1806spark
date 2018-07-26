var express = require("express");
var registerRoutes = express.Router();
var Person = require("./modelRegister").Person;



// GET /questions
// Route for questions collection
registerRoutes.get("/", function(req, res, next){
	console.log(req.url);
	Person.find({})
				// .sort({createdAt: -1})
				.exec(function(err, findPerson){
					if(err) return next(err);
					res.json(findPerson);
				});
});

// POST /questions
// Route for creating questions
registerRoutes.post("/", function(req, res, next){
	console.log('Creating new Person');
	console.log(req.body);
	var createdPerson = new Person(req.body);
	console.log(createdPerson);
	createdPerson.save(function(err, newPersons){
		if(err) return next(err);
		console.log("successfully saved");
		res.status(201);
		res.json(newPersons);
		
	});
});

/* // GET /questions/:id
// Route for specific questions
addMovieRoutes.get("/:qID", function(req, res, next){
	res.json(req.newMovie);
}); */




/* // DELETE /questions/:qID/answers/:aID
// Delete a specific answer
addMovieRoutes.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.createdMovie.save(function(err, movieDB){
			if(err) return next(err);
			res.json(movieDB);
		
		});
	});
}); */



module.exports = registerRoutes;





