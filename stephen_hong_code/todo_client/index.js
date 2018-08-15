var express = require("express");
var app = express();

let port = 3000;
app.listen(port, ()=> console.log("Todo Client ready on port: " + port))

app.get("", function(req, resp, next){
    console.log("someone is requesting the base/template html page");
    resp.sendFile("C:\\Users\\Stephen Hong\\my_git_repos\\1806spark\\stephen_hong_code\\todo_client\\template.html")
})

//  make static content available
app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));