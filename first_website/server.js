var express = require("express");
var app = express();
var fitnessPath = require("./fitness-path");
var portNumber = 3000;
var jsonParser = require("body-parser").json; //Why?

app.use(jsonParser()); //why?

/*
    Allows us to connect to the database
    Mongoose is the Javascript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/fitness"); // sets the configuration the specific database called fitness
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

/*
    Allows to access my HTML, CSS, and JS files
*/
app.use("/css", express.static('css'));
app.use("/images", express.static('images'));
app.use("/pages", express.static('pages'));
app.use("/js", express.static('js'));

/* 
    sets / url to index.html
*/
app.use("/home", function(req, resp, next){
    resp.sendFile("C:\\Users\\Alex Moraga\\my_git_repos\\1806spark\\first_website\\pages\\Website.html");
});

/* 
    Linking fitness-path to the /Back page
*/
app.use("/Back", fitnessPath);

app.listen(portNumber, function(){
    console.log(`Express server is listening on port ${portNumber}`);
});
