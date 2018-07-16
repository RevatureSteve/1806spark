var express = require("express");
var app = express();
var portNum = 3007;
var jsonParser = require("body-parser").json;
app.use(jsonParser());

app.listen(portNum, function(){
    console.log("your node server with express is ready!");
})

//allow css style files to be found easy
app.use('/css', express.static('css'));
app.use('/app.js', express.static('app.js'));
app.use('/images', express.static('images'));

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
app.use('/home', function(req, resp, next){
    resp.sendFile('/Users/becklarson-Work/my_git_repos/1806spark/Project-1/index.html');
})

