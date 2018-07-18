var express = require("express");
var app = express();
var portNum = 1313;
var commentPath = require("./comment_path");
var jsonParser = require("body-parser").json;
app.use(jsonParser());

/*Connection to database*/

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/jungleComments");
var db = mongoose.connection;
db.on("error", function (err) {
	console.log(`Connection error: ${err}`);
});
db.once("open", function () {
	console.log("Db connection successful");
});

app.use("/html", express.static("html"));
app.use("/css", express.static("css"));
app.use("/js", express.static("js"));

app.use("/home", function (req, resp, next) {
	resp.sendFile("C:\\Users\\eddie_000\\my_git-repos\\1806spark\\league_champions\\index.html");
});

app.use("/jungle", commentPath);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
	var err = new Error("Not Found");
	err.status = 404;
	next(err);
});

// Error Handler
// if error occurs express calls this function
app.use(function (err, req, res, next) {
	res.status(err.status || 500);  // set the response status to err.status but if falsy set to 500
	res.json({
		error: {
			message: err.message
		}
	});
});

app.listen(portNum, function () {
	console.log(`Server port ${portNum} is ready. Any request?`);
});