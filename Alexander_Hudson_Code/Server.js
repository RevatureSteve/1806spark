var express = require ("express");
var app = express();
var portNumber = 3003;
var homeRouter = require('./homePath');
var jsonParser = require("body-parser").json;
app.use(jsonParser());


var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/LucianoProductions');
var db = mongoose.connection;
db.on('error', function(err){
    console.error('connection error:'+ err);
});
db.once('open', function(){
    console.log('db connection successful');
});




app.use ("/home", function(req, resp, next){
    resp.sendFile('C:\\Users\\Savii Luciano\\my_git_repos\\1806spark\\Alexander_Hudson_Code\\index.html');
})

app.use('/CSSFiles', express.static('CSSFiles'));
app.use('/Pages', express.static('Pages'));
app.use('/JsFiles', express.static('JsFiles'));

app.use('/homePath', homeRouter);

app.listen(portNumber, function(){
    console.log('Your server with express is ready');
})
