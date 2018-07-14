var express = require("express");
var app = express();
var portNumber = 3001
var getScore = require("./getScore-route");
var giveScore = require("./giveScore-route");
var jsonParser = require('body-parser');

app.use(jsonParser());

app.listen(portNumber, function(){
    console.log("Project 1 - Express server is listening on port 3001")
});

// use mongoose JS package to connect to mongo db

var mongoose = require("mongoose");    
mongoose.connect("mongodb://localhost:27017/tdb"); //projectOne DB
var db = mongoose.connection; //reference connection and allow use

//error handling
db.on("error", function(err){
    console.error("connection error:", err);
});
db.once("open", function(){
    console.log("Database Connection Successful!!");
});

app.use("/scores", getScore)
app.use("/scoreboard", giveScore)