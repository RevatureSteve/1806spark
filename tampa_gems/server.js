var express = require('express');
<<<<<<< HEAD
<<<<<<< HEAD

var app = express(); // returns an express application to build a server with.

var jsonParser = require('body-parser').json; // this dependency will parse request body data that is in the form of json.

// listen on port 3000, and a function callback to allow you to know server has started.
app.listen(3001,function(){
    console.log('your node server with express is ready!')
});

// allow css static files to be found easily //

app.use("/css", express.static('css'));
//allows my html files
app.use("/pages", express.static('pages'));

//request comes through this function 
app.use(function(req, resp, next){
console.log('Hey developer on server-side, I received a request.')
console.log(req.headers);
console.log(req.method);
console.log(req.url);

    next(); //go to the next function
});

app.use(function(req,resp,next){
console.log('I am now going to do something with the request');
next();
 //go to the next function if there isnt one then we are telling express we are done.nod

});
app.use("/hello" , function(req,resp,next){
console.log('request received - hello');

 
});

app.use("/home", function(req,resp,next){

    resp.sendFile('/Users/prjctmedia/my_git_repos/1806spark/tampa_gems/pages/index.html')


});


/*

example for url params - GET request

query string - ?key=value e.g. ?name=steve&age=150
url variable person/:id where :id is a variable could be a person/ :name

*/
app.use("/person",function(req,resp,next){
    console.log('person request received');
    console.log("The person's name is:" + req.query.name);
    console.log("The person's name is:" + req.query.age);
    next();

});
app.use("/person/:id",function(req,resp,next){
    console.log('person request received');
    console.log("The person's name is:");
    console.log("The person's ID is: " + req.params.id);
    if(req.params.id > 50) {
        resp.json({
            "response":"your id is really high",
=======
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
var app = express(); // returns an express application to build a server with
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
    console.log(req.url);
    next(); // go to the next function
})

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
<<<<<<< HEAD
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
            "ID": req.params.id
        });
    }else{
        resp.json({
<<<<<<< HEAD
<<<<<<< HEAD
            "response":"your id is really low",
            "ID": req.params.id,
            "movie":["billy","bobby"]
        });
        
    }
    next();
});

/*

example for url params - POST request

*/ 
var personz = function(req,resp,next){
    if(req.body){
        console.log('the color is: '+ req.body.color);
    }else{
        console.log(' there is no request body -undefine');
    }
    next();
};

app.use("/personz",personz); //req.body undefine
app.use("/personz",jsonParser()); //use the new request body tool
app.use("/personz",personz); //req.body with data
=======
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
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
        console.log('The color is: ' + req.body.dog);
    }else{
        console.log('There is no request body -undefine');
    }
    next();
};
app.use("/personz", personz); // req.body undefine
app.use("/personz", jsonParser()); // use the new request body tool
app.use("/personz", personz);
<<<<<<< HEAD
>>>>>>> 150ae089dc796e1fd85d51541da637eb19e228a4
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4

