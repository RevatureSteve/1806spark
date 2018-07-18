var express = require('express');
var app = express();
var registerPath = require("./server-code/route-path"); // route path
//var loginPath = require("./server-code/login-path");
var jsonParser = require("body-parser").json;
var cookieParser = require('cookie-parser');
var portNumber = 3000;
var session = require("express-session");

app.use(jsonParser());


app.use(session({secret:"dsjfalksdjfsldkfjsd", resave:true, saveUninitialized:true, cookie: {secure: true}}));

app.use(session({
    genid: function(req) {
      return genuuid() 
    },
    secret: 'keyboard cat'
  }))

  app.get('/', function(req, res, next) {
    if (req.session.views) {
      req.session.views++
      res.setHeader('Content-Type', 'text/html')
      res.write('<p>views: ' + req.session.views + '</p>')
      res.write('<p>expires in: ' + (req.session.cookie.maxAge / 1000) + 's</p>')
      res.end()
    } else {
      req.session.views = 1
      res.end('welcome to the session demo. refresh!')
    }
  })

app.use('/images', express.static('images'));

app.use('/css', express.static("css"));

app.use('/scripts', express.static("scripts"));

app.use('/pages', express.static("pages"));

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/user");
var db = mongoose.connection;
db.on("error", (err) => {
    console.error(`connection error: ${err}`);
})
db.once("open", () => {
    console.log("db connection successful!");
})

app.listen(portNumber, function() {
    console.log(`Server is ready: ${portNumber}`); 
})


app.use((req, resp, next ) => {
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    console.log(req.cookies);
    console.log(req.session);
    next();
});

app.use("/register", registerPath);
//app.use("/login", loginPath);
// app.use("/login", loginPath);

app.use("/home", (req, resp, next) => {
    resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\Main.html");
})