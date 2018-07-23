var express = require('express');
var app = express(); // return an expres application to build a server with
                    // call back function for when the server has started
var jsonParser = require("body-parser").json; // thsi dependency will parse request body data that is in the forn of json

app.listen(3000, function() {
    console.log('your node server with express is ready');
}) 
// the code above just start the server and begin to listen


// qllow css static files to load
app.use('/css', express.static('css'));
//this will allow css folder to be loader can be place any where after the app.listen

app.use('/pages', express.static('pages'));
//this will allow pages folder to be loader can be place any where after the app.listen

// request come through hit this function 
app.use(function(req, resp, next){
console.log('hey developer, i have reciived a request');
console.log(req.headers);
console.log(req.method);
console.log(req.url);
next(); // go to the the nest function 
})

app.use(function(req, resp, next){
    console.log('i am now going to do something with the request');
    next();
    // then we are tellng express we are done
})
app.use("/hello", function(req, resp, next){
    //"/hello" will only allow this function to run if an only when the url say http://localhost:3000/hello
    console.log('the request - hello');
    next();
   
})
app.use("/home", function(req, resp, next){
    
resp.sendFile('C:\\Revature\\git_repos\\1806spark\\tampa_gems\\index.html');
//resp.sendfile('') // add javascript files
//next(): dont need this because as this function is sending the response
    
   
})


/*
    example for url params - GET Request
        query string  ?key=value e.g. ?name=steve&age=150
        url variable  person/:id where :id is a variable could be person/:name
*/
app.use("/person", function(req, resp, next){
    console.log('person request received');
    console.log('The person\'s name is: ' + req.query.name);
    console.log('The person\'s age is: ' + req.query.age);
    next();
});

app.use("/person/:id", function(req, resp, next){
    console.log('person request received');
    console.log('The Peron\'s ID: ' + req.params.id);
    if(req.params.id > 50) {
        resp.json({
            "response": "Your ID is really high",
            "ID": req.params.id
        });
    }else{
        resp.json({
            "response": "Your ID is really low",
            "ID": req.params.id,
            "movie": ["batman", "superman", "avengers", "Spiderman"]
        });
    }
});


/*
    example for request body params - POST Request
        content-type: application/json 
            data not regular plain/text
*/
var personz = function(req,resp, next){
    if(req.body){
        console.log('The color is: ' + req.body.color);
    }else{
        console.log('There is no request body -undefine');
    }
    next();
};
app.use("/personz", personz); // req.body undefine
app.use("/personz", jsonParser()); // use the new request body tool
app.use("/personz", personz); // req.body with data...yay!

// /*
//     get request example
    
// */
// app.use("/person", function(req, resp, next){
//     console.log('person request received');
//     console.log('the person\' name is: ' + req.query.name);
//     console.log('the person\' age is: ' + req.query.age);

//     next();
//     //this was used with form commented with server.js
// })
// // app.use("/person/:id", function(req, resp, next){
// //     console.log('person request received');
// //     console.log('the person\' name is: ' + req.params.id);
// //     if (req.params.id > 50) {
// //         resp.json({
// //             "response": " Your id is t really high",  "ID" 
// //         }) else {
// //             resp.json({
// //                 "response": "you id is really high", 
// //                 "ID" 
// //             })
// //         }
// //     }

// //     next();
// //     //this was used with form commented with server.js
// // })
// // /*
// //     post request example (in the body of the program)

// // */

// /*
//     example for request body paramas - post request
//     content-type: application/json
//     data not regular plain/text
// */

// app.use("/personz",personz); //req.body underline
// app.use("/personz",personz); //
// app.use("/personz",personz); //