var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Project 1 ready on port: ' + port));

app.get('',function(req,resp,next){
    resp.sendFile('/Users/becklarson-Work/Documents/my_git_repos/1806spark/Project-One/template.html');
    // resp.sendFile(path.join(__dirname, 'template.html'))
});
// make static content available
app.use('/pages', express.static('pages'));
app.use('/CSS', express.static('css'));
app.use('/JS', express.static('JS'));