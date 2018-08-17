var express = require('express');
var app = express();

let port = 3000;

app.listen(port, () => console.log('Todo Client ready on port' + port));

app.get('', function(req, resp, next){
    resp.sendFile('C:\Users\lolitsrhys\my_git_repos\1806spark\rhys_yamasaki_code\Ers-Client\template.html');
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));