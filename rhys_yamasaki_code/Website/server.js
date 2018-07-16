var express = require('express');
var app = express();
var registerPath = require("./server-code/route-path"); // route path
var jsonParser = require("body-parser").json;
var portNumber = 3000;

app.use(jsonParser());

app.use('/images', express.static('images'))

app.use('/css', express.static("css"))

app.use('/scripts', express.static("scripts"))

app.listen(portNumber, function() {
    console.log(`Server is ready: ${portNumber}`);
})

var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/user");
var db = mongoose.connection;
db.on("error", (err) => {
    console.error(`connection error: ${err}`);
})
db.once("open", () => {
    console.log("db connection successful!");
})

//app.use('/pages', express.static('pages'))

app.use((req, resp, next ) => {
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next();
});

app.use("/register", registerPath);

app.use("/home", (req, resp, next) => {
    resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\Main.html");
})

app.use("/actors", (req, resp, next) => {
    resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\actors.html");
})

app.use("/login", (req, resp, next) => {
    resp.sendFile("C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\login.html");
})

app.use("/movies", (req, resp, next) => {
    resp.sendFile('C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\movies.html');
})

app.use('/register', (req, resp, next) => {
    resp.sendFile('C:\\Users\\lolitsrhys\\my_git_repos\\1806spark\\rhys_yamasaki_code\\Website\\pages\\register.html');
})