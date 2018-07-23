var express = require("express");
var app = express();
var myRoute = require("./routingPath.js");
var jsonParser = require("body-parser").json;
app.use(jsonParser());

/*
	connection to Database
	Mongoose is the JavaScript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/new"); // sets the configuration the specific database called qa
//////////////////////////////////////27017/qa this is port number and database name and change your database name rcommend used default port number
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

app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));
app.use('/scripts', express.static('scripts'));
app.use('/image', express.static ('imgage'))


/*
	set / url to index.html
*/
app.use('/home', function(req, resp, next){
	//resp.sendFile('C:\\Revature\\PROJECTS\\projectOne\\index.html');
	resp.sendFile('C:\\Revature\\git_repos\\1806spark\\project\\projectone\\index.html');
	 
})

app.use('/submit', myRoute); 

// app.use("/index.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\PROJECTS\\projectOne\\index.html")
// })

// app.use("/login.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\login.html")
// })

// app.use("/about.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\pages\\about.html")
// })
// app.use("/contact.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\pages\\contact.html")
// })

// app.use("/login.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\pages\\login.html")
// })

// app.use("/peerReview.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\pages\\peerReview.html")
// })

// app.use("/signUp.html", function(req, resp, next) {
// 	resp.sendFile("C:\\Revature\\git_repos\\1806spark\\project\\projectone\\pages\\signUp.html")
// })






// app.use(function(req, res, next){
// 	res.header("Access-Control-Allow-Origin", "*");
// 	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
// 	if(req.method === "OPTIONS") {
// 		res.header("Access-Control-Allow-Methods", "PUT,POST,DELETE");
// 		return res.status(200).json({});
// 	}
// 	next();
// });

//app.use("/", myRoute);

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