var mongoose = require("mongoose")

// Use a Schema to make our question object follow a set of rules
var Schema = mongoose.Schema

    //When you see capital means a constructor (constructor is a special method that will return an object)
    //OOP object oriented programming
    //Class verse Object
    //Class is the blueprint to creat objects from!
        // e.g. Person Class
            //Create john object type person
            //Create mary object person

var QuestionSchema = new Schema({
    question: String,
    createdAt: { type: Date, default: Date.now},
    answer: String


})

var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question;