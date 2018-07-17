var express = require("express");
var fitnessPath = express.Router();
var Fitness = require("./model").Fitness;

/*
    This allows others to require (fitnessPath)
*/
fitnessPath.get("/", function(req, resp, next){
    console.log(req.url);
    Fitness.find({})
        .exec(function(err, fitness){
            if(err) {
                return next(err);
            }
            resp.json(fitness);
        });
});

// Create a post in /Back
fitnessPath.post("We've posted your request", function(req, resp, next){
    console.log(req.url);
    var fitness = new Fitness(req.body);
    fitness.save(function(err, fitness){
        if(err){
            return next(err);
        }
        resp.status(201); // 201 means created
        resp.json(fitness);
    });
});

// allows other to require('fitnessPath')
module.exports = fitnessPath;