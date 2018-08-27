var express = require('express');
var app = express(); //app is being assigned the return of express()
var portNumber = 3001; 
var questionPath = require("./question-path");
var answers = require("./answers");
var jsonParser = require("body-parser").json; 
app.use(jsonParser());

/* 
    Our class project connected to the database 
*/
var mongoose = require("mongoose"); // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/qa"); // sets the configuration the specific database
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){ // call this function on errors
    console.log("connection error" + err);  // `some text with ${varName} more text!` template literal
});
db.once("open", function(){ // creates connection when requests
    console.log("db connection successful");
});


/* 
    set routes
*/
app.use("/questions", questionPath)
app.use("/answers", answers)

// Let's get the app started
app.listen(portNumber, function(){
    // console.log("Class - Express is listening on Port: " + portNumber); // The original
    console.log(`Class - Express is listening on Port: ${portNumber}!`);
                                // inject a variable into a string w/out concat
})