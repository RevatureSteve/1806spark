var express = require('express');
var app = express();
var registerPath = require("./server-code/route-path"); // route path
//var loginPath = require("./server-code/login-path");
var jsonParser = require("body-parser").json;
var cookieParser = require('cookie-parser');
var portNumber = 3000;
var session = require("express-session");

app.use(jsonParser());


app.use(session({secret:"dsjfalksdjfsldkfjsd", resave:true, saveUninitialized:true}));

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
    // console.log(req.headers);
    // console.log(req.method);
    // console.log(req.url);
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

// app.use("/home/user", (req, resp, next) => {
//     resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\movieDetails.html");
// })



// app.use("/home/user", (req, resp, next) => {
//     resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\homeloggedin.html");
// })

// app.use("/profile", (req, resp, next) => {
//     resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\profile.html");
// })

// app.use("/actors", (req, resp, next) => {
//     resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\actors.html");
// })

// app.use("/login", (req, resp, next) => {
//     resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\login.html");
// })

// app.use("/movies", (req, resp, next) => {
//     resp.sendFile('C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\movies.html');
// })

// app.use('/register', (req, resp, next) => {
//     resp.sendFile('C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\register.html');
// })