//------------------- Required packages----------------------//
var express = require('express');

// This dependency will pars body data that is in the form of json
var jsonParser = require('body-parser').json;

//-------------------- Invoke packages-----------------------//
var app = express();


// Callback function for when the server starts
app.listen(3000, () => { console.log("server ready") });

// Allow css files to be found easily
app.use('/css', express.static('css'));
// Allow my html files
app.use('/pages', express.static('pages'));

// Requests his this function
app.use((req, resp, next) => {
    console.log("I received a request");
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    // Invoke next
    next();
});

app.use((req, resp, next) => {
    console.log("I am now going to do something");
    // Invoke next
    next();
});

app.use('/hello', (req, resp, next) => {
    console.log("Request received - hello");
    // Invoke next
    next();
});

app.use('/home', (req, resp, next) => {
    resp.sendFile("C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_tampa_gems\\index.html");
    // Invoke next
    // next();
});

app.use('/index.html', (req, resp, next) => {
    resp.sendFile("C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_tampa_gems\\index.html");
    // Invoke next
    // next();
});

// example for url params - GET Request
//  query string ?key=value e.g. ?name=steve&age=150
//      accessed via req.query.name
//  url variable person/:id where :id is a variable 
//      req.params.id

app.use('/person/:id', (req, resp, next) => {
    console.log('request response recieved');
    console.log('The person\'s name is: ' + req.query.name);
    console.log('The person\'s age is: ' + req.query.age);
    console.log('The person\'s id is: ' + req.params.id);
    if (req.params.id > 50) {
        resp.json({
            "response": "Your id is really high",
            'ID': req.params.id
        })
    }
    else {
        resp.json({
            "response": "Your id is really low",
            'ID': req.params.id
        })
    }
    next();
})

// Example for request body params - POST Request
//  content-type: application/json
//      data not regular plain/text

var persons = function(req, resp, next){
    if (req.body) {
        console.log(`the color is: ${req.body.color}`);
    }
    else {
        console.log(`There is no spoon...or request -undefined`);
    }
    next();
}

// request body undefined
app.use('/persons', persons);
// use the new body tool
app.use('/persons', jsonParser());
// req body with data...yay!
app.use('/persons', persons);


