var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo Client ready on port: ' + port));

app.get('', function(req, resp, next){
    console.log('someone is requesting stuff');
    resp.sendFile('C:\\Users\\marci\\my_git_repos\\1806spark\\marcin_salamon_code\\todo_project\\ToDo_client\\index.html');
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));
