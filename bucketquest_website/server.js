var express = require('express');
var app = express();
app.listen(3001, function(){
    console.log(' Your node server with express is ready');
})
// allow CSS files to be found
app.use('/css files', express.static('css files'));

//allow the html files
app.use('/htmlPages', express.static('htmlPages'));

// requests hit here
app.use(function(req, resp, next){
    console.log('request recieved')
    console.log(req. headers)
    console.log(req. method)
    console.log(req. url)
    next();// do whatever function comes next
})

app.use(function(req,resp,next){
    console.log('the server now does something with the request')
    next();
})

app.use("/Bucketquest", function(req,resp,next){
    console.log('the server has recieved the request')
    next();
})

app.use(function(req,resp,next){
    resp.sendfile('/Users/christopherholmes/my_git_repos/1806spark/bucketquest_website/htmlPages/Bucketquest.html')
})