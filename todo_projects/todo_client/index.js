var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('project ready on ' + port));


app.get('', function(req, resp, next){
    resp.sendFile('C:\\Users\\Steve Work PC\\my_git_repos\\1806spark\\todo_projects\\todo_client\\base.html');
});

app.use('/pages', express.static('pages'));
app.use('/css',express.static('css'));
app.use('/js',express.static('js'));