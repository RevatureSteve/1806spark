var express = require("express");
var app = express();
var portNumber = 3030;
var homeRouter = require("./homePath");
var jsonParser = require('body-parser').json;
app.use(jsonParser());

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/cats');
var db = mongoose.connection;
db.on('error', function(err){
    console.error('connection error:'+ err);
});
db.once('open', function(){
    console.log('NISAT SUCCESS')
});

app.use("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Nisat\\my_git_repos\\1806spark\\cat_forum\\forum.html');
})

app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));
app.use('/js', express.static('js'));

app.use('/homePath', homeRouter);

app.listen(portNumber, function(){
    console.log('your server express is ready');
})


