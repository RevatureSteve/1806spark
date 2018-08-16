var express = require('express');
var app = express();

let port  = 3000;
app.listen(port, function() {
    console.log("Starting");
});

app.get("/", function(req, res) { 
    console.log();
    res.sendFile("C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\ToDoClient\\template.html")
})
   
app.use("/pages", express.static("pages"));
app.use("/js", express.static("/js"));