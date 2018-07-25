var express = require('express');
var app = express();
var portNumber = 3001;
var questionPath = require("./question-path")
var answerPath = require("./answer-path")
var jsonParser = require("body-parser").json;
app.use(jsonParser());

// app.use("/hello", function(req,resp,next) {   --end point
//     console.log('hello!');
// })

//our class project is now connected to the database question answer

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/questionAnswer");
var db = mongoose.connection;
db.on("error", function(err){
    console.log("connection error:", err)
});
db.once("open", function(){
    console.log("db connection successful")
})


//set routes
app.use("/questions", questionPath)
app.use("/answers", answerPath)

//let's get the app started
app.listen(portNumber, function(){
    // console.log("My - Express server is listening on port" + portNumber)  //original
    console.log(`My - Express server is listening on port: ${portNumber}`) //inject a variable into a string w/o concat
})

