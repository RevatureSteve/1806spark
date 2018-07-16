var express = require("express");
var app = express();
var portNumber = 3001;
var getScore = require("./getScore-route");
var giveScore = require("./giveScore-route");
var jsonParser = require('body-parser');

app.listen(portNumber, function () {
    console.log("Project 1 - Express server is listening on port 3001")
})

app.use('/project1css', express.static('project1css'));
app.use('/project1', express.static('project1'));
app.use('/project1js', express.static('project1js'));

app.use(jsonParser());

app.use(function (req, resp, next) {
    console.log('hey developer on teh server, I recieved a request');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); //go to next function

})
app.use('/home', function (req, resp, next) { //add extra \\ so it doesn't read "escape \"//
resp.sendFile('C:\\Users\\tyler\\my_git_repos\\1806spark\\tyler_project_one\\project1\\project1Index.html');
})

var verifyUandP = function (req, resp, next) {
        if (req.body) {
            console.log('The color is:' + req.body.color);
        } else {
            console.log('There is no');
        }
        next();
    };

    // use mongoose JS package to connect to mongo db

    var mongoose = require("mongoose");
    mongoose.connect("mongodb://localhost:27017/tdb"); //projectOne DB
    var db = mongoose.connection; //reference connection and allow use

    //error handling
    db.on("error", function (err) {
        console.error("connection error:", err);
    });
    db.once("open", function () {
        console.log("Database Connection Successful!!");
    });

    app.use("/verifyUandP", jsonParser());
    app.use("/verifyUandP", verifyUandP);
    // app.use("/project1/quiz.html", getScore)
    app.use("/quiz", getScore, function(req,resp,next){

        resp.sendFile("C:\\Users\\tyler\\my_git_repos\\1806spark\\tyler_project_one\\project1\\quiz.html");
    })
    // app.use("/scoreboard", giveScore)

  