var express = require('express');
var app = express(); // returns an express application to build a server with
<<<<<<< HEAD
var jsonParser = require('body-parser').json; // this dependency will 
                                // parse request body data that is in the form of json


                    //callback fn for when the server has started
app.listen(3000, function(){ 
    console.log('Your node server with express is ready!');
})

// Allow css static file to be found easily!
app.use('/css', express.static('css'));
// Allow my html files 
app.use('/pages', express.static('pages'));

// request comes thru hit this function
app.use(function(req, resp, next){
    console.log('Hey developer on the server, I received a request!');
    console.log(req.headers);
    console.log(req.method); 
=======
var jsonParser = require('body-parser').json; // this depenedency will parse request body data that is in the form of json


// callback function for when the server has started
app.listen(3000, function () {
    console.log('Your node server with express is ready!');
})

// Allow css static file to be found easily
app.use('/css', express.static('css'));
// Allow my html files
app.use('/pages', express.static('pages'));

app.use(function (req, resp, next) {
    console.log('Hey developer on the server, I recieved a request!');
    console.log(req.headers);
    console.log(req.method);
>>>>>>> 389bd661b1467c9b599b7c6083198da9b886917f
    console.log(req.url);
    next(); // go to the next function
})

<<<<<<< HEAD
app.use(function(req, resp, next){
    console.log('I am now going to do something with the request');
    next(); // go to the next function if there isn't one 
    // then we are telling express we are done
})

app.use("/hello", function(req, resp, next){
    console.log('request received - hello');
    next(); 
})

app.use("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Steve Work PC\\my_git_repos\\1806spark\\tampa_gems\\index.html');
    // next(); don't need as this function is sending the response back not next function
})


/*
    example for url params - GET Request
        query string  ?key=value e.g. ?name=steve&age=150
        url variable  person/:id where :id is a variable could be person/:name
                e.g. person/125 or person/15
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
=======
app.use(function (req, resp, next) {
    console.log('I am now going to do something with the request');
    next(); // go to the next function if there isn't one then we are telling express we are done
})


app.use("/hello", function (req, resp, next) {
    console.log('request received - hello');
    next();
})

app.use("/home", function (req, resp, next) {
    resp.sendFile("C:\\Users\\Alicia\\my_git_repos\\1806spark\\tampa_gems\\index.html")
})



/*
    example for url params - GET Requets
        query string ?key=value e.g. ?name=steve&age=150
        url variable person/:id where :id is a variable could be person/:name
*/
app.use('/person', function (req, resp, next) {
    console.log('Perosn request received');
    console.log('The person\'s name is: ' + req.query.name);
    console.log('The person\'s age is: ' + req.query.age);
    next();
})

app.use('/person/:id', function (req, resp, next) {
    console.log('Perosn request received');
    console.log('The person\'s ID: ' + req.query.id);
    if (req.param.id > 50) {
        resp.json({
            'response': 'Your ID is really high',
            'ID': req.param.id
        })
    } else {
        resp.json({
            'response': 'Your ID is really low',
            'ID': req.param.id,
            'movie': ['batman', 'superman', 'avengers', 'spiderman']
        })
    }
    next();
})

>>>>>>> 389bd661b1467c9b599b7c6083198da9b886917f


/*
    example for request body params - POST Request
<<<<<<< HEAD
        content-type: application/json 
            data not regular plain/text
*/
var personz = function(req,resp, next){
    if(req.body){
        console.log('The color is: ' + req.body.color);
        console.log('The color is: ' + req.body.dog);
    }else{
        console.log('There is no request body -undefine');
    }
    next();
};
app.use("/personz", personz); // req.body undefine
app.use("/personz", jsonParser()); // use the new request body tool
app.use("/personz", personz);
=======
        content-type: application/json
            data not regular plain/text
*/

var personz = function(req,resp,next){
    if (req.body){
        console.log('The color is: ' + req.body.color);
    } else{
        console.log('There is no request body -undefined');
    }
    next();
}

app.use('/personz', personz);  // req.body undefined
app.use('/personz', jsonParser()); // use the new request body tool
app.use('/personz', personz);   // req.body with data...yay
>>>>>>> 389bd661b1467c9b599b7c6083198da9b886917f

