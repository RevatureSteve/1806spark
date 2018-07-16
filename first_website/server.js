var express = require("express");
var app = express();
var portNumber = 3000;

app.listen(portNumber, function(){
    console.log(`Express server is listening on port ${portNumber}`);
});

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/fitness");
var db = mongoose.connection;
db.on("error", function(err){
    console.error("connection error:", err);
});
db.once("open", function(){
    console.log("db connection is successful");
});

/*
    Allows us to connect to the database
    Mongoose is the Javascript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");


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


