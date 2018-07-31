/*
This js file is for requests to the path/questions
*/

var express = require("express")

var questionPath = express.Router();

var Questions = require("./question-model").Questions

//GET /questions
questionPath.get("/", function(request,response,next){

        console.log(request.url)
        question.find({}).exec(
            function(error,questions){
                if(error){
                    return next(error)
                }
                response.json(questions);
            }
        )

})

//Create (Post) questions
questionPath.post("/", function(request,response,next){

        console.log(request.url);

        var question = new Questions(request.body);
        question.save(function(error,question){
            if(error) {
                return next(error);
            }
            response.status(201);
            response.json(question);
        })

})



module.exports = questionPath;