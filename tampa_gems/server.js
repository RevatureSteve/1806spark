
var express = require('express');
var app = express();
var jsonParser = require('body-parser').json;
var path = require('path');

var barsRoutes = require('./route-bars');
var restaurantsRoutes = require('./route-restaurant');

app.listen(3000, function(){ console.log("hello, node server w/ express has started!");})

app.use(function(req,resp, next){
    console.log('Server has received an HTTPRequest - 1st stage');
    // console.dir(req); // log request to console but maybe we want to send this request to a database logging system?
    // console.log(req.body);
    // console.log("Base URL: " + req.baseUrl);
    // console.log(req.ip);
    console.log('The request\'s headers: ');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next();
})
app.use(function(req,resp, next){
    console.log('Handling the HTTPRequest - 2nd stage');
    
    next();
})
app.use('/diff', function(req,resp, next){
    console.log('Handling the HTTPRequest send to diff - 2nd stage');
    
    next();
})
app.use('/diff/:id', function(req,resp, next){
    console.log('Handling the HTTPRequest send to diff ' + 'id: ' + req.params.id + ' - 2nd stage');
    
    next();
})

// https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=harry+potter
app.use('/query', function(req,resp, next){
    console.log('The color is ' + req.query.color);
    next();
})

var jsonCheck = function(req, resp, next){
    if(req.body){
        console.log("The color is " + req.body.color);
    }else{
        console.log("No body found");
    }
    next();
}



app.use('/home', function(req, resp, next) {
    // resp.send('index.html');
    // resp.end('index.html');
    // resp.write('index.html');
    // resp.sendFile('/Users/steveace6/my_git_repos/1806spark/tampa_gems/index.html');
    resp.sendFile(path.join(__dirname+'/pages/index.html'));
    // resp.json({"response": "hello json"});
})

// 0 - completed
app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'))


// 1 -url params for GET!
app.use('/diff/:id', function(req,resp, next){
    console.log('Handling the HTTPRequest send to diff ' + 'id: ' + req.params.id + ' - 2nd stage');
    resp.json({
        "response": "your id: " + req.params.id,
    })
    // next();
})


// 2 -request body params for POST!
// var jsonParser = require('body-parser').json;

app.use('/param', jsonCheck);
app.use('/param', jsonParser())
app.use('/param', jsonCheck);
/*
    bars routes
*/

app.use('/bars', barsRoutes);

/*
    restaurant routes
*/
app.use('/restaurant', restaurantsRoutes);
