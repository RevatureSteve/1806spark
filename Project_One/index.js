var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Reimbursement Client ready on port: ' + port));

app.get('', function(req, resp, next){
    console.log('someone is requesting the base/template html page');
    resp.sendFile('C:\\Users\\Alex Moraga\\my_git_repos\\1806spark\\Project_One\\HTML\\mainscreen.html')
})

// make static content available
app.use('/CSS', express.static('css'));
app.use('/IMAGES', express.static('images'));
app.use('/HTML', express.static('html'));
app.use('/JS', express.static('js'));