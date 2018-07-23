var express = require('express');
var app = express(); //returns an express application
                    //callback fn for when the server has started
                    var jsonParser = require('body-parser').json;// this dependency will parse request body data that is in the form of json


app.listen(4000, function(){
    console.log('Your node server with express is ready')
})

//allow css static files to be found easily
app.use('/css', express.static('css'));
//allow html files
app.use('/pages', express.static('pages'));

//request comes thru hit this function
app.use(function(req, resp, next){     //needs request object and response object
    console.log('hey developer on the server, i received a request!')
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); // go to the next function
})

app.use(function(req, resp,next){     
    console.log('I am now going to do something with the request')
    next(); // go to the next function if there isn't one......then we are telling express we are done 
})

app.use("/hello", function(req, resp,next){     
    console.log('request received - hello')
    next(); 

})

app.use("/home", function(req, resp, next) {
    resp.sendFile('C:\\Users\\Joshua\\my_git_repos\\1806spark\\joshua_maciejewski_code\\joshua_tampa_gems\\Index.html')
    //next(); don't need as this function is sending response back not next function
})

/*
    example for url params - Get request
        first- query string ?key=value e.g. ?name=steve&age=150
        second- url variable person/:id where :id is a variable could be person/:name
*/

app.use("/person/", function(req, resp, next) {
    console.log('person request received');
    console.log('The person\'s name is: ' + req.query.name);
    console.log('The person\'s age is: ' + req.query.age);
    next();
})

app.use("/person/:id", function(req, resp, next) {
    console.log('person request received');
    console.log('The person\'s age is: ' + req.param.id);
    if(req.param.id > 50) {
        resp.json({
            "responses": "Your ID is really high",
            "ID": req.params.id
        });
    }else{
        resp.json({
            "responses": "Your ID is really low",
            "ID": req.params.id,
            "movie": ["batman", "superman", "avengers", "spiderman"]
    
        });
    }
    // next();
})



/*
    example for request body params - Post request
        content-type: application/json data,  not regular plain/txt
*/



var personz = function (req, resp, next){
    if(req.body){
        console.log('The color is: ' + req.body.color);
    }else{
        console.log('there is no request body -undefine');
    }
    next();
}

app.use("/personz", personz );  // req.body undefine
app.use("/personz", jsonParser() );  // use the new request body tool
app.use("/personz", personz );  // req.body with data....... OH YEAH

