var express = require('express');
var app = express();//returns an express application to build a server with
                    //callback fn for when the server has started
var jsonParser = require('body-parser').json;//this dependency will parse request body data that is in the form of json

app.listen(3000, function(){
    console.log("your node server with express is ready!");
})

//allow css style files to be found easy
app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));

// request come through it hits this function
app.use(function(req, resp, next){
    console.log('hey developer on the server, I received a request');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next();//go to the next function
})
app.use(function(req, resp, next){
    console.log('I am now going to do somthing with the request');
    next();//go to the next fuction if there isn't one 
    //then we are telling express we are done
})
app.use('/hello', function(req, resp, next){
    console.log('request recieved - hello');
    next();
})
app.use('/home', function(req, resp, next){
    resp.sendFile('/Users/becklarson-Work/my_git_repos/1806spark/tampa_gems/index.html');
})

//example for url params - GET Request
app.use('/person', function(req, resp, next){
    console.log('person request recived');
    console.log('The person\'s name is: ' + req.query.name); 
    next();
})


app.use('/person/:id', function(req, resp, next){
    console.log('person request recived');
    console.log('The person\'s ID:' + req.params.id); 
    if(req.param.id > 50){
        resp.json({
            "response": "Your ID is really high",
            "ID": req.param.id
        });
    }else{
        resp.json({
            "response": "Your ID is really low",
            "ID": req.param.id,
            "movie": ["batman", "superman", "avengers", "spiderman"]
        });
    }
   
})


//example for request body parmas - POST Request
// application/json data...not regular data plain/text

var personz = function(req, resp, next){
    if(req.body){
        console.log('the color is: ' + req.body.color);
    }
    else{
        console.log('there is no request body -undefine');
    }
    
    next();
}

app.use("/personz", personz);//req.body undefine
app.use("/personz", jsonParser());//use the new request body tool
app.use("/personz", personz);//req.body  with data...yay!
   

