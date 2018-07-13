var express = require('express');
var app = express();
var portNumber = 3000;
var jsonParser = require("body-parser").json;
app.use(jsonParser());


// Connect to the database
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/imgDB');
var db = mongoose.connection;
db.on('error',function(err){
    console.error('connection error: ' + err);
});
db.once('open', function(){
    console.log('db connection successful');
});



app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));
app.use('/scripts', express.static('scripts'));

app.use("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Alicia\\my_git_repos\\1806spark\\alicia_douglas_code\\spark_project\\index.html')
})





app.listen(portNumber, function(){
    console.log('Your node server with express is ready!');
})

