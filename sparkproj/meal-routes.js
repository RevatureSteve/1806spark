'use strict';

var express = require("express");
var router = express.Router();
var Meal = require("./models").Meal;

router.get("/", function(req, res, next){
    console.log('/meals');
    
	Meal.find({})
				// .sort({createdAt: -1})
				.exec(function(err, meals){
					if(err) return next(err);
					res.json(meals);
				});
});

router.post("/", function(req, res, next){
	console.log('Creating new recipe / meal');
	console.log(req.body);
	var meals = new Meal(req.body);
	console.log(meals);
	meals.save(function(err, meals){
		if(err) return next(err);
		res.status(201);
		res.json(meals);
	});
});


router.get("/:qID", function(req, res, next){
	res.json(req.meals);
});



router.delete("/:mealID/answers/", function(req, res){
	req.answer.remove(function(err){
		req.meals.save(function(err, meals){
			if(err) return next(err);
			res.json(meals);
		});
	});
});





module.exports = router;