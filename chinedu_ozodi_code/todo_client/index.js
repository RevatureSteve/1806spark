var express = require('express');
var app = express();

let port = 3000;
app.listen(port, () => console.log('Todo Client ready on port: ' + port));

app.get('', function(req,resp,next){
    console.log('request for base template made');
    resp.sendFile("C:\\Users\\chin2\\mygitrepos\\1806spark\\chinedu_ozodi_code\\todo_client\\template.html");
});

app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));