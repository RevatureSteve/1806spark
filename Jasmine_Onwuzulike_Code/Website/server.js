var express = require('express');
var app = express();

app.listen('3000', function() {
    console.log('The server is ready.')
});

app.use('/css', express.static('css'));

app.use(function(req, res, next) {
    console.log('Made it here.')
console.log(req.header);
console.log(req.method);
console.log(req.url);
next();
})


app.use(function(req, res, next) {
    console.log('Im going to do something with this response');
    next();
});

//Actual code for Spark Project

app.use('/home', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\home.html');
});

app.use('/photography', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\photography.html');
});
app.use('/login', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\login.html');

});
app.use('/forum', function(req, res, next) {
    res.sendFile('C:\\Users\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\forumn.html');
 });

 app.use('/subscribe', function(req, res, next){
     res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\subscribe.html')
 })
app.use('/person', function(req, res, next) {
    console.log('Person request received.');
    console.log('The person\'s first name is: ' + req.query.first_name);
    console.log('The person\'s last name is ' + req.query.last_name);
    console.log('The person\'s email is ' + req.query.email);
});
// app.use('', function(req, res, next) {
//     res.sendFile('')

// });
// app.use('', function(req, res, next) {
//     res.sendFile('')

// });

