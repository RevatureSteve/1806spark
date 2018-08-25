var express = require("express");
var app = express();

let portNum = 3000;


app.listen(portNum, ()=> console.log('Ready on port: ' + portNum)); 

app.get('', function(req, resp, next){
    resp.sendFile('C:\\Users\\Savii Luciano\\my_git_repos\\1806spark\\Alexander_Hudson_Code\\ERSProject1\\template.html');
});


app.use('/Pages', express.static('Pages'));
app.use('/css', express.static('css'));
app.use('/js', express.static('js'));
