var express = require('express');
var app = express(); //app is being assigned the return of express()
//makes port number dynamic instead of hardcoding port 3000
var portNumber = 3001;
var questionPath = require("./question-path");
var answersPath = require("../nisat-questions/answers-path");
var jsonParser = require("body-parser").json;
app.use(jsonParser());
//our class project is now connected to the database questionAnswer

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/questionAnswer");
var db = mongoose.connection;
db.on("error", function(err){
    console.error("connection error:", err);
});
db.once("open", function(){
    console.log("db connection successful");
});


app.use("/questions", questionPath);
app.use("/answers", answersPath);

//let's get the app started
app.listen(portNumber, function(){
   // console.log("CLASS - Express server is listening on port: " + portNumber);// original way to concat string + var
    console.log(`CLASS - Express server is listening on port: ${portNumber}!`);//inject a variable into a string w/o concat
// template literal = ` back tic to the left of 1
} )