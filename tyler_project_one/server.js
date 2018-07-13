console.log('hello');
var express = require('express');
var app = express() //returns an express application to build a server with
var jsonParser = require('body-parser').json;
//callback function for when the server has started
app.listen(3001, function(){
    console.log('your node server with express is ready');

})
//allow css static files to be found easily//
app.use('/project1css', express.static('project1css'));
//html files in folder pages//
app.use('/project1', express.static('project1'));

app.use(function(req, resp, next){
    console.log('hey developer on teh server, I recieved a request');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); //go to next function

})
app.use(function(req, resp, next){
    console.log('Give request to next function....im now going to do something');
    next(); //go to next function if no next then express knows we're done
})

app.use("/hello" ,function(req, resp, next){
    console.log('request recieved - hello');
    next(); //go to next request
    
})
app.use('/home', function(req, resp, next){ //add extra \\ so it doesn't read "escape \"//
    resp.sendFile('C:\\Users\\tyler\\my_git_repos\\1806spark\\tyler_project_one\\project1.html');
})

var verifyUandP = function(req, resp, next){
    if(req.body){
        console.log('The color is:' + req.body.color);
    }else{
        console.log('There is no');
    }
    next();
};
app.use("/verifyUandP", jsonParser());
app.use("/verifyUandP", verifyUandP);
