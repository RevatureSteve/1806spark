var mongoose = require("mongoose");
// use a Schema to make our question object 
// follow a set rules!
var Schema = mongoose.Schema;
    // capital means a constructor: a method that will return an object
    // OOP - object oriented programming
    // class vs. object
        // class is blueprint to create objects from!
            //e.g. Person Class 
                //create john object type person
                //create mary object type person

var QuestionSchema = new Schema( {
    question: String,
    createdAt: { type: Date, default: Date.now},
    answer: String
})

var Question = mongoose.model("Question", QuestionSchema);

exports.Question = Question;  //allow to require