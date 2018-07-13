//Required libraries
var express = require('express');

// Invoking libraries
var app  = express();

// Initialize server
app.listen(3000, () =>{ 
    console.log("server ready");
});

// Static folder searches
app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));
app.use('/node_modules', express.static('node_modules'));


// User data logging

app.use((req, resp, next) =>{
    console.log(req.headers);
    next();
});

app.use('/index.html',(req, resp, next) =>{
    resp.sendFile('C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
});

app.use('/',(req, resp, next) =>{
    resp.sendFile('C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
});

