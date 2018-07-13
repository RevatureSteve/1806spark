var express = require('express');
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
// Allow js files
app.use('/js', express.static('js'));

// request comes thru hit this function
app.use(function(req, resp, next){
    console.log('Hey developer on the server, I received a request!');
    console.log(req.headers);
    console.log(req.method); 
    console.log(req.url);
    next(); // go to the next function
})

app.use("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Stephen Hong\\my_git_repos\\1806spark\\stephen_hong_code\\project\\index.html');
    // next(); don't need as this function is sending the response back not next function
})