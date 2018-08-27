/* 
    This js file is for requests to the path / questions
*/
var mongoose = require("mongoose");
var questionPath = express.Router();
var Question = require('./question-model').Question;


// GET /questions/
questionPath.get("/", function(req, resp, next){
    console(req.url);
})

// GET /questions/
questionPath.get("/", function(req, resp, next){
    console(req.url);
    var question = new Question(req.body);
    question.save(function(err, question){
        if(err){ 
            return next(err);
        }
        resp.status(201);
        resp.json(question);
    })
})


// Use a Schema to make our Question object
// follow a rules!
var Schema = mongoose.Schema;
    // capital means a Constructor: a method that will return an object
    // OOP - object oriented programming
    // class vs object
    //      Class is a blueprint to create objects from!
    //              e.g. Person Class
    //                  create john object type Person
    //                  create mary object type Person

    var QuestionSchema = new Schema({

    }) 

var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question; // allows me to require ('')