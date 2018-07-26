var mongoose = require("mongoose");

// Use a Schema to make our Question object
// follow a set of rules!
var Schema = mongoose.Schema;
        // capital means a Constructor 
        // OOP - object orientated programming
        // Class verse Object
        //      Class is the blueprint to create objects from!
        //              e.g. Person Class
        //                  create john object type Person
        //                  create mary object type Person

var QuestionSchema = new Schema({
    question: String,
    createdAt: { type: Date, default: Date.now},
    answer: String
});

/*var MoviesSchema = new Schema({
    question: String,
    createdAt: { type: Date, default: Date.now},
    answer: String
});*/


var Question = mongoose.model("Question", QuestionSchema);
//var Question = mongoose.model("Movies", MovieSchema);
module.exports.Question = Question; // allow me to require('')
//module.exports.Movie = Movie;     // allow me to require('')