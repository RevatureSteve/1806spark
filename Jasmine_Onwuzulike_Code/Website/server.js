var express = require('express');
var app = express();

//db information
var mongoose = require('mongoose');
mongoose.connect("mongodb://localhost:27017/entry");
var db = mongoose.connection;
db.on("error", function(err) {
    console.log("Connection error", err)
});
db.once("connected", function() {
    console.log("Successful connection to db.")
});

//Set static folders.
var options = {
	dotfiles: 'ignore',
	etag: false,
	extensions: ['htm', 'html'],
	index: false,
	maxAge: '1d',
	redirect: false,
	setHeaders: function (res, path, stat) {
	  res.set('x-timestamp', Date.now());
	  res.status = 200;
	}
  }
app.use("/css", express.static('css'));
app.use("/pages", express.static('pages', options));
app.use("/js", express.static('js'));



// //Set home page.
app.get('/home', function(req, res, next) {
    res.sendFile('C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\home.html');
});



app.listen('3000', function() {
    console.log('The server is ready.')
});