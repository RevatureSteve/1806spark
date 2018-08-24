var express = require('express');
var Client = require('node-rest-client').Client;
var app = express(); //returns an express application to build a server with
//callback fn for when the server has started
var jsonParser = require("body-parser").json;
var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
var xhr = new XMLHttpRequest();
app.use(jsonParser());

app.listen(3000, function () {
    console.log("your node server with express is ready!");
})

//allow files
app.use('/audio', express.static('audio'));
app.use('/images', express.static('images'));
app.use('/css', express.static('css'));
app.use('/js', express.static('js'));
app.use('/pages', express.static('pages'));


app.use("/home", function(req,resp,next){
    resp.sendFile('C:/Users/Richard/Desktop/revature_stuff/working_on/my_git_repos/1806spark/JDBC/ERS_html/pages/main.html');
})