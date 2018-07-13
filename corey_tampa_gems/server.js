var express = required("express");
var app = express(); // returns an express application to build a server
                    //callback fn for whenno the server has started
                    var jsonParser = require("body-parser").json
app.listen(3000, function(){
    console.log("Your node server with express is ready!");
});

// // Allow css static file to be foun easily!
 app.use("/css", express.static("css"));
// Allow my html file 
 app.use("/pages", express.static("pages"));

// //request comes thru hit this function
// app.use(function(req, resp, next){
// console.log('Hey developer on the server, I received a request!');
// console.log(req.headers);
// console.log(req.method);
// console.log(req.url);
// next(); //go to the next function
// });

// app.use(function(req, resp, next){
// console.log('I am now going to do something with the request');
// next(); // go to the next function if there isn't one 
// //then we are telling express we are done
// });

// app.use("/hello", function(req, resp, next){
// console.log('request received - hello');
// next();
// });

app.use("/home", function(req, resp, next){
resp.sendFile("C:\\Users\\HP\\my_git_repos\\1806spark\\corey_tampa_gems\\index.html");
//next(); don't need as this function is sending the response back not next function
    });

/*
example for url params - GET Request
*/    
    // app.use("/person", function(req, resp, next){
    //     console.log("person request received");
    //     console.log("The person's name is: " + req.query.name);
    //     console.log("The person's age is: " + req.query.age);

    //     next();
    // });

    /*
example for url params - POST Request
*/ 