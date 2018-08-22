var express = require('express');
var app = express();
var questionPath = require('./question-path');
var answerPath = require('./answer-path');
var jsonParser = require('body-parser');
app.use(jsonParser());

var port = 3000;
var dpPort = 27017; //do not change

// Setup mongoose
var mongoose = require('mongoose');
mongoose.connect(`mongodb://localhost:${dpPort}/chinQA`);
var db = mongoose.connection; // referencse to connection
db.on("error", (err) =>{
    console.error(`connection error:`, err);
});
db.once("open", () => {
    console.log('db connection successful');
});

// Set Routes
app.use('/questions', questionPath);
app.use('/answers', answerPath);

app.listen(port, ()=>{
    console.log(`server ready on port: ${port}`);
});