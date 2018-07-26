//For requests to the path /recommendations
var express = require ('express');
var submissionPath = express.Router();
var Submission = require ('./recommendations-model').Submission //calling recommendations model schema: Submission

//GET /submissions
submissionPath.get("/", function(req,resp,next){  //GETs whatever is in the database (Submission)
    console.log(req.url);
    Submission.find({}).exec(
        function(err,submissions){ //execute this function after getting everything
            if(err) { // if an error happens return this error statement
                return next(err);
            }
            resp.json(submissions)
        });
})

//Create /submissions/
submissionPath.post("/", function(req,resp,next){ //posting something to the database
    console.log(req.url); //not important, just tests that js is making it this far
    var submission = new Submission(req.body); // creating new object (new submission)
    submission.save(function(err,submission){ // saves the data
        if(err){
            return next (err);
        }
        resp.status(201);
        resp.json(submission);
    })
})


module.exports = submissionPath; // so i can reference this file