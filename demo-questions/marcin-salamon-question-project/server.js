var express = require('express');
var app = express();
var portNumber = 3001;
var questionPath = require('./question-path');

var mongoose = require('mongoose');
mongoose.connect('moggodb://localhost:27017/questionAnswer');
var db = mongoose.connection;
db.on('error', function(err){
    console.error('connection error:'+ err);
})
db.once('open', function(){
    console.log('db connection successful');
});

//set routes
app.use('/questions', questionPath);

app.listen(portNumber, function(){
    console.log('CLASS - express server is listening on port: ' + portNumber + '!');
});
