var mongoose = require("mongoose");

// Use a Schema to make our Question object
// follow a set rules!
var Schema = mongoose.Schema;
       // capital means a Constructor: a method that will return an object
       // oop - object oriented programming
       // Class vs Object
       //      class is a blueprint to create objects from!
       //            e.g person class
       //               create john object person
       //                create mary object person 

var QuestionSchema = new Schema({
    quesiton: String,
    createdAt: { type: Date, default: Date.now},
    answer: String 
});


/*  var FoodSchema = new Schema({
    name: String,
    foodImage: String,
    food: Array
})
*/
var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question; // allows me to require('')