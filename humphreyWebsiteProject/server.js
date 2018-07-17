var express = require("express");
var app = express();
var jsonParser = require("body-parser").json;
app.use(jsonParser());

var addMovieRoutes = require("./plusAdd-routes.js");
var recentlyAddedPath = require("./recentlyAdded-route.js");


app.listen(3001,function(){

    console.log("Server is ready with express")

})

//Allow use of static css files & HTML files
app.use("/css",express.static("css"));
app.use("/pages", express.static("pages"))
app.use("/images", express.static("images"))
app.use("/javascript", express.static("javascript"))


var mongoose = require("mongoose");  // require the package from node_modules
mongoose.connect("mongodb://localhost:27017/addMovies"); // sets the configuration the specific database called qa
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});


app.use(function(request,response,next){

    console.log("Hey developer, I have received a request")

    next();

})

//request Handler
app.use(function(request,response,next){

    console.log("Hey developer on the server, I have received a request!")
    console.log(request.headers)
    console.log(request.method)
    console.log(request.url)
    next(); //go to the next function
    })
    
    app.use(function(request,response,next){
    
        console.log("I am now going to do something with the request")
        next(); //go to the next function if there isn't one then we are telling express we are done
    })
    
    
    
    app.use("/home",function(request,response,next){
    
        response.sendFile("/Users/humphreyminott/my_git_repos/1806spark/humphreyWebsiteProject/index.html")
    })

    app.use("/addMovies", addMovieRoutes,function(request,response,next){
    
    })

    // app.use("/pages/recentlyAdded.html", recentlyAddedPath)