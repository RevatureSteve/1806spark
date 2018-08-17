var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('project one client on port'));

app.get('', function(req, resp, next){
    console.log('Project one is requesting the base/index.html page')
    resp.sendfile('C:\\Revature\\git_repos\\1806spark\\chester_gillfillian_code\\projectOneFront\\pages\\index.html')
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));
app.use('/css', express.static('css'));
