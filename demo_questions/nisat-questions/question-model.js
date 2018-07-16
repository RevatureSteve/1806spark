var mongoose = require("mongoose");

//use a Schema to make our question object 
//follow rules
var Schema = mongoose.Schema;
    //capital means a Constructor:
    //i.e. a method that will return an object
    //OOP - object oriented programming
    //class vs object
    //class is a blueprint to create objects from
    //e.g. person class
    //create john object type person
    //create mary object type person

var QuestionSchema = new Schema({
  question: String,
  createdAt: {type: Date, default: Date.now},
  answer: String
})
    
var Question = mongoose.model("Question", QuestionSchema);
module.exports.Question = Question; //allows me to use require ('')
//module.exports.Movie = Movie

//var MovieSchema = new Schema({
   // name: String,
    //moviePic: String,
    //celebrotoes: [//arrays],/Array
    //employees: {
        //Object
   // }
//})