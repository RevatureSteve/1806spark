var mongoose = require ('mongoose');

//Use a Schema to make our Question object 
//follow a set of rules!
var Schema = mongoose.Schema;
    // capital means a Constructor: a method that will return an object
    // OOP - object oriented programming
    // Class vs Object
    //      Class is the blueprint to creat objects from!
    //          e.g. Person Class
    //              create john object type Person
    //              create mary object type Person

var QuestionSchema = new Schema({
    question: String, 
    createdAt: {type:Date, default: Date.now},
    answer: String 
});

var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question; // allow me to require ('')