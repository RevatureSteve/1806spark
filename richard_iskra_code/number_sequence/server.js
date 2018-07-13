var express = require('express');
var app = express(); //returns an express application to build a server with
//callback fn for when the server has started
app.listen(3000, function () {
    console.log("your node server with express is ready!");
})
//allow files
app.use('/audio', express.static('audio'));
app.use('/image', express.static('image'));
app.use('', express.static('jpg'));
app.use('/css', express.static('css'));
app.use('/js', express.static('js'));
app.use('.', express.static('.'));
app.use('/pages', express.static('pages'));

//request comes thru hit this function
app.use(function (req, resp, next) {
    console.log('Hey developer on the server, I received a request!')
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); //go to the next function
})

app.use(function (req, resp, next) {
    console.log('I am now going to do something with the request')
    next(); //go to the next function. if there isnt one then we are telling express we are done
})

app.use("/home", function(req,resp,next){
    resp.sendFile('C:/Users/Richard/Desktop/revature_stuff/working_on/my_git_repos/1806spark/richard_iskra_code/number_sequence/pages/home.html');
})