var express = require('express');
var app = express(); //returns an express application to build a server with
//callback fn for when the server has started
var scorePath = require("./numseqRoute.js")
var jsonParser = require("body-parser").json;
app.use(jsonParser());

app.listen(3000, function () {
    console.log("your node server with express is ready!");
})

var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/ns"); // sets the configuration the specific database called qa
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:" + err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

app.use("/mode1", scorePath)

//allow files
app.use('/audio', express.static('audio'));
app.use('/image', express.static('image'));
app.use('/css', express.static('css'));
app.use('/js', express.static('js'));
app.use('/pages', express.static('pages'));


app.use("/home", function(req,resp,next){
    resp.sendFile('C:/Users/Richard/Desktop/revature_stuff/working_on/my_git_repos/1806spark/richard_iskra_code/number_sequence/pages/home.html');
})