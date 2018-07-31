var express = require("express"); //require this package from node modules
var app = express(); //App is being assigned the return of express
var portNumber = 3002;
var questionPath = require("./question-path");
var answerPath = require("./answers-path")
var jsonParser = require("body-parser").json;
app.use(jsonParser());
//Our class project connected to the database
var mongoose = require("mongoose"); //require the package from node modules
mongoose.connect("mongodb://localhost:27017/questions"); //sets this connection to this specific database
var db = mongoose.connection; //a reference to this connection to allow us to use this connection
db.on("error", function(error){ //call this function on errors
    console.error("connection error: " + error);
});
db.once("open", function(){ //create connection when requests
    console.log("db connection successful")
});

//Let's get the app started
app.listen(portNumber,function(){

    console.log(`CLASS - Express server is listening on port: ${portNumber}` ) //inject a variable into a string w/out concat
})

//set routes (when you hit this endpoint)

app.use("/questions", questionPath)

app.use("/answers", answerPath)

// allow others to require ("questionPath")
