var express = require('express');
var app = express(); //app is being assigned the return of express
var portNumber = 3000;
var questionPath = require('./server-code/question-path');
var answerPath = require("./server-code/answer-path");
var jsonParser = require("body-parser").json;
app.use(jsonParser());


//Starting app on port 3000. 
app.listen(portNumber, function(){
	//console.log("CLASS - Express server is listening on port" + portNumber +"!");
    console.log(`CLASS - Express server is listening on port: ${portNumber}!`);
                                               //inject a variable into a string w/o concat.
                                                //called a template literal.
});

/* CONNECT TO THE DATABASE HERE */
var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/questionAnswer");
var db = mongoose.connection;
db.on("error",function(err){
    console.error("-CONNECTION ERROR-CONNECTION ERROR-CONNECTION ERROR-"+ err);
});
db.once("open",function(){
    console.log("-DB CONNECTION SUCCESSFUL -");
})


//creating a new endpoint



/* SET ROUTES HERE */
//get this first one and send it here.
app.use("/questions",questionPath);
app.use("/answers",answerPath);