var express = require("express");

var app = express();

app.listen(3001,function(){

    console.log("Server is ready with express")

})

//Allow use of static css files & HTML files
app.use("/css",express.static("css"));
app.use("/pages", express.static("pages"))
app.use("/images", express.static("images"))
app.use("/javascript", express.static("javascript"))

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
    
        console.log("request recieved - hello")
        next(); 
    })
    
    app.use("/home",function(request,response,next){
    
        response.sendFile("/Users/humphreyminott/my_git_repos/1806spark/humphreyWebsiteProject/index.html")
    })