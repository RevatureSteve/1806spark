// maybe download nodemon? its a possibility

//our imports
var express = require('express');
var app = express();
var portNumber = 4000;
var morgan = require('morgan');
var bodyParser = require('body-parser');//translates url or json data
var mongoose = require('mongoose');

var registerRoute = require('./register-route');
var orderRoute = require('./order-route');

mongoose.connect("mongodb://localhost:27017/registery"); // sets the configuration the specific database called qa
var db = mongoose.connection; // a reference to the connection to allow us to use the connection
db.on("error", function(err){	// call this function on errors 
	console.error("connection error:", err);
});
db.once("open", function(){ // creates connections when requests
	console.log("db connection successful");
});

app.use(morgan('dev'));//logs request and lets you move on
app.use(bodyParser.urlencoded({extended: false}));//extracts url data, true: for rich data and 
                                                                        //false: for simple body data
app.use(bodyParser.json());//extracts json data to make readable


//preventing CORS errors
    //Cross-Origin-Resourse-Sharing (security concept)
app.use(function(req, resp, next){
    resp.header('Access-Control-Allow-Origin', '*');//restricting my API from other webpages, but not atm
    resp.header('Access-Control-Allow-Headers', 
        'Origin, X-Requested-With, Content-Type, Accept, Authorization'
    );//these headers can be appended
    if(req.method === 'OPTIONS'){
        resp.header('Access-Control-Allow-Methods', 'PUT, POST, PATCH, DELETE, GET');
        return resp.status(200).json({});
    }
    next();
});

//rourtes that handle requests (my middleware)
app.use('/register-route', registerRoute);
app.use('/order-route', orderRoute);
app.use('/css', express.static('css'));
app.use('/htmlPages', express.static('htmlPages'));
app.use('/javascript', express.static('javascript'));

//404 working and none of the middleware was executed
app.use(function(req, resp, next){
    var error = new Error('Not Found');//error is already in node.js
    error.status = 404;//did not find a fitting route
    next(error);//passes this error over the original one which is confusing
});

//errors throw from every other operations thats not a 404
    //500 working
app.use(function(error, req, resp, next){
    resp.status(error.status || 500);//either 404 or 500 error
    resp.json({
        error: {
            message: error.message
        }
    });
});

//console is working on the port number
app.listen(portNumber, function(){
    //works so far with this
    console.log('express is up on port ' + portNumber);
}); 










