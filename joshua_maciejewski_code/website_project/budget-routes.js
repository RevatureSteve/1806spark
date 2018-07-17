'use strict';

var express = require('express');
var router = express.Router();
//question models is for mongoose
var Budget1 = require('./models').Budget1;


//GET /questions
// Route for questions collection
router.get('/', function(req, res, next){
    console.log('/budgets');
    Budget1.find({})
            .exec(function(err, budget) {
                if(err) return next(err);
                res.json(budget);
            });
});


// POST /questions
// Route for creating questions
router.post("/", function (req, res, next) {
    console.log('Creating new question');
    console.log(req.body);
    var budget = new Budget1(req.body);
    console.log(budget);
    budget.save(function(err, budget) {
        if(err) return next(err);
        res.status(201)
        res.json(budget)
    });
});


// GET /questions/:id
// Route for specific questions
router.get("/:qID", function(req, res, next){
	res.json(req.budget);
});




// DELETE /questions/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){ //might need to change this
		req.budget.save(function(err, budget){
			if(err) return next(err);
			res.json(budget);
		});
	});
});



module.exports = router;