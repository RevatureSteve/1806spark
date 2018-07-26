var mongoose = require("mongoose");

// Use a Schema to make our Question object follow rules
var Schema = mongoose.Schema;
        // capital means a Constructor: a method that will return an object
        // OOP - object orientated programming
        // Class vs Object
        //      Class is a blueprint to create objects from
        //              e.g. Person Class
        //                  create john object type Person
        //                  create mary object type Person


var QuestionSchema = new Schema({
    question: String,
    createdAt: {type: Date, default: Date.now},
    answer: String
});

var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question; // Allows me to require("")