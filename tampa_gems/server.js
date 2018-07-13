console.log("hello");
var express = require("express")
var app = express()
var jsonParser = require("body-parser").json //this dependency

app.listen(3000,function(){
    console.log("Your node server with express is ready")
})

//Allow css static files to be found easily
app.use("/css", express.static("css"));

// Allow my html files
app.use("/pages", express.static("pages"))

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

app.use("/hello",function(request,response,next){

    console.log("request recieved - hello")
    next(); 
})

app.use("/home1",function(request,response,next){

    console.log("request recieved - hello")
    next(); 
})

app.use("/home1",function(request,response,next){

    response.sendFile("/Users/humphreyminott/my_git_repos/1806spark/tampa_gems/index.html")
    
})


app.use("/person",function(request,response,next){
    
    console.log("person request received")
    console.log("The person's name is: " + request.query.name);
    console.log("The person's age is: " + request.query.age);
    console.log("The person's ID: " + request.params.id);
    next();
})

/*
Example for body parameters - Get Request
query string k=value e.g. name=steveage=50
URL variable
*/

app.use("/person/:id",function(request,response,next){
    console.log("The person's ID: " + request.params.id);
    if(request.params.id > 50){
        response.json({
            "response": "your response is really high",
            "ID":request.params.id,
            "movie": ["batman","superman","avengers"]
        });
    }else { 
            response.json({
                "response": "your response is really low",
                "ID":request.params.id
            })
    }
    next();
})

/*
Example for URL parameters - Post Request
Take on some application Json data
content-type: application/json data not regular plain/text
*/
var personez = function(request,response,next){
    console.log("personz requested")
    if(request.body){
        console.log("The color is: " + request.body.color)
    } else {
        console.log("There is no request body");
    }
next();
}

app.use("/personz", personez); //request body undefine
app.use("/personz", jsonParser()); //use the new request body call
app.use("/personz", personez); //
