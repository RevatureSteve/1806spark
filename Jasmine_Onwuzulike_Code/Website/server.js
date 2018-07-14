var express = require('express');
var app = express();
var loginPath = require("./login-paths");



//Static pages.
app.use('/css', express.static('css'));
app.use('/js', express.static('js'))
app.use('/photo_cats', express.static('photo_cats'));
app.use('/pages', express.static('pages'));


//Set home page.
app.use('/home', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\home.html');
});

app.get('/login', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\login.html');
})

//Use photography route.
app.use('/login', loginPath);


app.listen('3000', function() {
    console.log('The server is ready.')
});