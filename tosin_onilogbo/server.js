var express = require("express");
var app = express();
var albumRoutes = require("./albums-routes");
var jsonParser = require("body-parser").json;
app.use(jsonParser());

/*
	connection to Database
	Mongoose is the JavaScript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/albums"); // sets the configuration the specific database called qa
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

/*
	Allow static content

	Can set options object as 2nd argument to change response
*/
var options = {
	dotfiles: 'ignore',
	etag: false,
	extensions: ['htm', 'html'],
	index: false,
	maxAge: '1d',
	redirect: false,
	setHeaders: function (res, path, stat) {
	  res.set('x-timestamp', Date.now());
	  res.status = 200;
	}
  }
app.use("/css", express.static('css'));
app.use("/pages", express.static('pages', options));
app.use("/js", express.static('js'));

/*
	set / url to index.html
*/
app.use("/home", function(req,resp, next){
	resp.sendFile('C:\\Users\\Ola\\my_git_repos\\1806spark\\tosin_onilogbo\\projecttitle.html');
});

app.use("/reviews", albumRoutes);

// app.use(function(req, res, next){
// 	res.header("Access-Control-Allow-Origin", "*");
// 	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
// 	if(req.method === "OPTIONS") {
// 		res.header("Access-Control-Allow-Methods", "PUT,POST,DELETE");
// 		return res.status(200).json({});
// 	}
// 	next();
// });

//app.use("/questions", questionRoutes);

// catch 404 and forward to error handler
app.use(function(req, res, next){
	var err = new Error("Not Found");
	err.status = 404;
	next(err);
});

// Error Handler
// if error occurs express calls this function
app.use(function(err, req, res, next){
	res.status(err.status || 500);  // set the response status to err.status but if falsy set to 500
	res.json({
		error: {
			message: err.message
		}
	});
});


app.listen(3000, function(){
	console.log("Express server is listening on port 3000");
});















