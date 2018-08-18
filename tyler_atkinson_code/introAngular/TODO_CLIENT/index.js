var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo Client ready on port: ' + port))

app.get('', function(req,resp,next){

    console.log("blah blah");
    resp.sendFile('C:\\Users\\tyler\\my_git_repos\\1806spark\\tyler_atkinson_code\\introAngular\\TODO_CLIENT\\template.html')
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('pages'));