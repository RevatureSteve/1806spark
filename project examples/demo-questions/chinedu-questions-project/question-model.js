var mongoose = require('mongoose');

// Use Schema to make our Questions object
// follow rules (makes it structured)
var Schema = mongoose.Schema;
// ^ Capital indicates a constructor ( a method that will return an object)
//      OOP object oriented programming
//      class is the bluerint to create objects from
//          eg. Person class
//              create john object, type Person
//              create mary object, type Person

var QuestionSchema = new Schema({
    question: String,
    createdAt: {type: Date, default: Date.now},
    answer: String
});

var Question = mongoose.model("Question",QuestionSchema);

// Allow require
module.exports.Question = Question; 