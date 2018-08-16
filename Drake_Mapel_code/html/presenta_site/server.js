var express = require("express");
var app = express();
var ideaPath = require("./idea-path");
var jsonParser = require("body-parser").json;
app.use(jsonParser());


// database
var mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/ideas");
var db = mongoose.connection;
db.on("error", (err) => {
    console.error(`connection error: ${err}`);
});
db.once("open", () => {
    console.log("db connection successful");
});



app.use("/css", express.static("css"));
app.use("/pages", express.static("pages"));
app.use("/js", express.static("js"));

app.use("/home", (req, resp, next) => {
    console.log("ideas!");
    // change with new directory
    resp.sendFile("C:\\Users\\dralex\\Documents\\html\\presenta_site\\index.html")
})

app.use("/login", (req, resp, next) => {
    console.log("welcome");
    // change with new directory
    resp.sendFile("C:\\Users\\dralex\\Documents\\html\\presenta_site\\pages\\login.html");
})

app.use("/ideas", ideaPath);



app.listen(3001, () => {
    console.log("Your node server with express is ready!");
})