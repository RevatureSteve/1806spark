var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo Client ready on port: ' + port))

app.get('', function(req, resp, next){
    console.log('someone is request the base/template html page');
    resp.sendFile('C:\\Users\\Ola\\my_git_repos\\1806spark\\tosin_onilogbo\\todo-client\\template.html')
})

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));