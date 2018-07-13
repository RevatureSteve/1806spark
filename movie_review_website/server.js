var express = require("express");
var app = express();
var reviewRoutes = require("./review-routes");
var commentRoutes = require("./comment-routes");
var jsonParser = require("body-parser").json;
app.use(jsonParser());

/*
	connection to Database
	Mongoose is the JavaScript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/reviews"); // sets the configuration the specific database called qa
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

app.use('/css', express.static('css'));
//this will allow css folder to be loader can be place any where after the app.listen

app.use('/pages', express.static('pages'));

app.use('/js', express.static('js'));

app.use('/images', express.static('images'));

app.use(function (req, resp, next) {
    console.log('request received');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); // go to the the nest function 
})

app.use(function (req, resp, next) {
    console.log('request processing');
    next();
    // then we are tellng express we are done
})

app.use("/home", function (req, resp, next) {

    resp.sendFile('C:\\Users\\marci\\my_git_repos\\1806spark\\movie_review_website\\index.html');
    //resp.sendfile('') // add javascript files
    //next(): dont need this because as this function is sending the response


})

app.use("/reviews", reviewRoutes);
app.use("/comments", commentRoutes);

app.use(function(req, res, next){
	var err = new Error("Not Found");
	err.status = 404;
	next(err);
});

app.use(function(err, req, res, next){
	res.status(err.status || 500);  // set the response status to err.status but if falsy set to 500
	res.json({
		error: {
			message: err.message
		}
	});
});

app.listen(3000, function () {
    console.log('Movie server is up');
});