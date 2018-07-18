//Required libraries
var express = require('express');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var user = require('./user');
var stock = require('./stock');

// Invoking libraries
var app  = express();

// Initialize mongoose
var dpPort = 27017; //do not change

// Setup mongoose
//Create/access users db
mongoose.connect(`mongodb://localhost:${dpPort}/users`);
var db = mongoose.connection;

// Handle errors with sending a request 
db.on('error',(error)=>{
    console.error(error);
});
// Check if connection successful
db.once('open',()=>{
    console.log('db connection successful');
})


// Static folder searches
app.use('/css', express.static('css'));
app.use('/pages', express.static('pages'));
app.use('/node_modules', express.static('node_modules'));
app.use('/javascript', express.static('javascript'));

// Body parsing
app.use(bodyParser.urlencoded({
    extended: true
}));

app.use(bodyParser.json());

// User data logging

app.use((req, resp, next) =>{
    // console.log(req.headers);
    next();
});


//Routes
app.use('/user',user);
app.use('/stock',stock);
// More use cases
app.use('/index.html',(req, resp, next) =>{
    resp.sendFile('C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
    // resp.sendFile('C:\\Users\\chinedu\\mygitrepos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
});

app.use('/',(req, resp, next) =>{
    resp.sendFile('C:\\Users\\Chinedu\\my_git_repos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
    // resp.sendFile('C:\\Users\\chinedu\\mygitrepos\\1806spark\\chinedu_ozodi_code\\project_spark\\index.html');
});

// Initialize server
app.listen(3000, () =>{ 
    console.log("server ready");
});
