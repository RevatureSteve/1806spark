var express = require("express");
var app = express(); // app is being assigned the return of express()
var portNumber = 3001;
var questionPath = require("./question-path");
var answersPath = require("./answers")
var jsonParser = require("body-parser").json;
app.use(jsonParser());

/* 
    Our class project connected to the database questionAnswer
*/

var mongoose = require("mongoose"); // require the package from node_modulus
mongoose.connect("mongodb://localhost:27017/questionAnswer"); // sets the configuration the specific database called
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){ // call this function on errors
    console.error("connection error:" + err); // or ${err} some text inside the {}, this is called template literal
});
db.once("open", function(){ // creates connection when requests
    console.log("db connection successful");
});

/*
    set routes
*/
app.use("/questions", questionPath)
app.use("/answers", answersPath)
   
// Let's get the app started
app.listen(portNumber, function () {
    //console.log("CLASS - Express server is listening on port: " + portNumber + "!"); //The orginal 
    console.log(`CLASS - Express server is listening on port: ${portNumber}!`);
                                        // inject a variable into a string w/out concat
})