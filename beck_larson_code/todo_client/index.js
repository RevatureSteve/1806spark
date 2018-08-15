var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo Cliend read on port: ' + port));

app.get('',function(req,resp,next){
    console.log('someone is requesting the base/template html page');
    resp.sendFile('/Users/becklarson-Work/Desktop/my_git_repos/1806spark/beck_larson_code/todo_client/template.html')
});
// make static content available
app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));