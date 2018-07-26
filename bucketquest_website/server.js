var express = require('express');
var app = express();
var jsonParser = require('body-parser').json;
var recommendationsPath = require("./recommendations-path");
app.use(jsonParser());
//app.listen(3001, function(){
   // console.log(' Your node server with express is ready');
//})

// allow CSS files to be found
app.use('/css', express.static('css'));

app.use('/js', express.static('js'));

//allow the html files
app.use(express.static('htmlPages'));

var mongoose = require("mongoose")
//require the mongoose package

mongoose.connect("mongodb://localhost:27017/recommendations");
var db = mongoose.connection; 
// a reference to the connection so i can use it

db.once("open", function(){// creates connections when requests come through
    console.log("db connection successful")
});

/*
set routes
*/
app.use("/recommendations", recommendationsPath);

//START THE APP
app.listen(3001, function(){
    console.log(`Express server is listening on port: + ${3001}!`);
}) //starts application on this port