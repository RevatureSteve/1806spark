var express = require("express");
var app = express();
var mealRoutes = require("./meal-routes");
var jsonParser = require("body-parser").json;
app.use(jsonParser());

app.listen(3000, function(){
	console.log("Express server is listening on port 3000");
});

var mongoose = require("mongoose");  
mongoose.connect("mongodb://localhost:27017/recipes"); 
var db = mongoose.connection; 
db.on("error", function(err){	
	console.error("connection error:", err);
});
db.once("open", function(){ 
	console.log("YOUR CONNECTION TO THE DATABASE WAS A SUCCESS.");
});


app.use("/css", express.static('css'));
app.use("/pages", express.static('pages'));
app.use("/js", express.static('js'));

app.use("/home", function(req,resp, next){
	resp.sendFile('/Users/prjctmedia/Desktop/sparkproj/pages/login.html');
	console.log("Login Page");
})


app.use("/mealsSaved", mealRoutes);

app.use(function(req, res, next){
	var err = new Error("Not Found");
	err.status = 404;
	next(err);
});

app.use(function(err, req, res, next){
	res.status(err.status || 500); 
	res.json({
		error: {
			message: err.message
		}
	});
});


