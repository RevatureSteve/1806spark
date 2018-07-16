var express = require('express');
var app = express(); // returns an express application to build a server with
var previewRoutes = require("./routes");
var jsonParser = require('body-parser').json; // this dependency will 
                                // parse request body data that is in the form of json
app.use(jsonParser());

/*
	connection to Database
	Mongoose is the JavaScript Package used to talk to the mongo database
*/
var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/code"); // sets the configuration the specific database called code
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

                    //callback fn for when the server has started
app.listen(3001, function(){ 
    console.log('Your node server with express is ready!');
})

// Allow css static file to be found easily!
app.use('/css', express.static('css'));
// Allow my html files 
app.use('/pages', express.static('pages'));
// Allow js files
app.use('/js', express.static('js'));

// request comes thru hit this function
app.use(function(req, resp, next){
    console.log('Hey developer on the server, I received a request!');
    console.log(req.headers);
    console.log(req.method); 
    console.log(req.url);
    next(); // go to the next function
})

app.use("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Stephen Hong\\my_git_repos\\1806spark\\stephen_hong_code\\project\\index.html');
    // next(); don't need as this function is sending the response back not next function
})

app.use("/preview", previewRoutes);

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