console.log('hello');
var express = require('express');
var app = express() //returns an express application to build a server with
//callback function for when the server has started
var jsonParser = require('body-parser').json;  //this dependency will parse request body data that is in the form of json//

app.listen(3000, function(){
    console.log('your node server with express is ready');

})
//allow css static files to be found easily//
app.use('/css', express.static('css'));
//html files in folder pages//
app.use('/pages', express.static('pages'));

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
    resp.sendFile('C:\\Users\\tyler\\my_git_repos\\1806spark\\tampa_gems\\index.html');
})


////////////URL PArameters//////////////// GET Request query string ?key=value ex. ?name=steve&age=150
// url variable person/ :id where :id :id is a variable could be person/:name

app.use("/person", function(req, resp, next){
    console.log('person request received');
    console.log("the person\'s name is:" + req.query.name);
    console.log("the person\'s age is:" + req.query.age);
    next();

})

app.use("/person/:id", function(req, resp, next){
    console.log('person request received');
    console.log("the persons id: " + request.params.id);
    if(req.param.id > 50){
        resp.json({
            "response": "Your id is really high",
            "ID": req.params.id
    });
}else{
    resp.json({
        "response": "Your id is really low",
        "ID": req.params.id,
        "movie": ["batman", "superman", "avengers", "spiderman"]
    });
}
    next();

})

// POSt request content type: application/json data not regular plain text



var personz = function(req,resp, next){
    if(req.body){
        console.log('The color is: ' + req.body.color);
    }else{
        console.log('There is no request body -undefine');
    }
   
    next();
};
app.use("/personz", personz); ///req body undefined skip this on project
app.use("/personz", jsonParser()); /// use the new request body tool
app.use("/personz", personz); /// 


////////////////request body parameters/////////////////POST request//////