var express = require("express");
var registerRoutes = express.Router();
var Person = require("./modelRegister").Person;



// GET /Registration Information
// Route for registration Collection
registerRoutes.get("/", function(req, res, next){
	console.log(req.url);
	Person.find({})
				// .sort({createdAt: -1})
				.exec(function(err, findPerson){
					if(err) return next(err);
					res.json(findPerson);
				});
});

// POST /New Registration
// Route for creating new registration
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

module.exports = registerRoutes;





