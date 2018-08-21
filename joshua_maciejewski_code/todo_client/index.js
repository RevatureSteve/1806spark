var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo client read on port: ' + port))

app.get('', function(req,resp,next){
    console.log('someone is request the base/template html page')
    resp.sendFile('C:\\Users\\Joshua\\my_git_repos\\1806spark\\joshua_maciejewski_code\\todo_client\\template.html')
});

//make static content available 
app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));


