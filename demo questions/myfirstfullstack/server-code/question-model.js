var mongoose = require('mongoose');

// use a Schema to make our Question Object
// follow a rule set.
var Schema = mongoose.Schema;
        //Capital means a Constructor: method that will return an object.
        //OOP - Object Oriented Programming
        //Class VS Object
        // Class is a blueprint to create objects from!
        //              E.G. Person Class
        //                  creates john object type Person
        //                  create mary object type Person

    var QuestionSchema = new Schema({

        picture: String,
        name: String,
        rating: Number,
        ingredients: String, //might have to do brackets idk yet.

        
    })
    /* var ExampleSchema = new Schema({

        picture: String,
        name: String,
        rating: Number,
        ingredients: Array, //might have to do brackets idk yet.

        
    }) */

    var Question = mongoose.model("Question",QuestionSchema);
/*     var Example = mongoose.model("Example",ExampleSchema); */


    module.exports.Question = Question;