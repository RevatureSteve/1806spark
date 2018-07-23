var express = require('express');
var app = express(); //app is being assign  the return of express()
var portNumber = 3001; //this is making the port  
var questionPath = require("./question-path");
var answerPath = require("./answer-path");

// let the app get started

app.listen(portNumber, function () {
    // listen the application on port 3000 when server running
    //the purpose of the function is to 
    //console.log("in class express server is listening on port 3000" + portNumber); // the original
    console.log(`inclass express server is listening on port 3001: ${portNumber}!`);
    //injecting variable into a string using the `` key above teh tab button
    // call contemplate literal ``
})

/// check note in original pproject 
var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/inClassQuestion");

var db = mongoose.connection;
db.on("error", function (err) {
    console.log("connection error", err);
})

db.once("open", function () {
    console.log("db connection successful")
})

/**
 *  set router
 */

 app.use("/question", questionPath); 
 app.use("/answer", answerPath); 
























































// //create an enpoint this was just for a test
// app.use("/hello", function(req, resp, next){
//     console.log('hello');
// })