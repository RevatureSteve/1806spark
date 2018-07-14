var express = require('express');
var app = express();
var loginPath = require("./login-paths");



// //Static pages.
 app.use("/css", express.static('css'));
app.use('/', express.static(__dirname + '/pages'));
app.use('/', express.static(__dirname + '/js'));



//Set home page.
app.get('/home', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\home.html');
});

//Use photography route.
app.use('/login', loginPath);


app.listen('3000', function() {
    console.log('The server is ready.')
});