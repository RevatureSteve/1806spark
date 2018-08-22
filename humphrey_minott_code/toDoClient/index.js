
var express = require('express');
var app = express();

let port = 3000;
app.listen(port, ()=> console.log("ToDo Client ready on port: " + port))

app.get("",function(req,resp,next){

    console.log("Some is requesting the base/template html page");
    resp.sendFile("/Users/humphreyminott/my_git_repos/1806spark/humphrey_minott_code/toDoClient/template.html");
})

//make static content available   (url  ------- folder name)
app.use("/pages",express.static("pages"));
app.use("/js",express.static("js"));