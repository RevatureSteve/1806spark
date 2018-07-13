var express = require('express');
var app = express();

app.listen(3000, function(){
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
    resp.sendFile('C:\\Users\\Joshua\\my_git_repos\\1806spark\\joshua_maciejewski_code\\website_project\\index.html')
    //next(); don't need as this function is sending response back not next function
})