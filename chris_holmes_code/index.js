var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log('Todo Client ready on port: ' + port))

app.get('', function(req,resq,next){
    console.log('someone is requesting the base/template html page')
    resp.sendFile('/Users/christopherholmes/my_git_repos/1806spark/chris_holmes_code/template.html');
});

//make static content available
///        url                    folder name
app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));