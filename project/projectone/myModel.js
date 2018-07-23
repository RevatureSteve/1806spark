var mongoose = require("mongoose");
//use a schema to make our question object follow a set of rules!
var Schema = mongoose.Schema;
        //when you se a capital mean a constructor : a mehtod that will return an oblject
        //OOP object oriented programming 
        //class verse object
        // class is the blue print to create object
        //e.g person class
        // create john pbject type of people 
        // create mary pbject type of people 

var TravelSchema = new Schema({
    
    author: String,
    comment: String
})

// var MovieSchema = new Schema({
//     Name: String,
//     MoviePic: String,
//     Celebrities : Array,
//     Employee: Object
// })

var Travel = mongoose.model("Travel", TravelSchema);
//var Movies = mongoose.model("movie", QuestionSchema);

module.exports.Travel = Travel; // allow me to require('')