let express = require('express');
let app = express();

app.listen(3000, function () {
    console.log('Movie server is up');
});

app.use('/css', express.static('css'));
//this will allow css folder to be loader can be place any where after the app.listen

app.use('/pages', express.static('pages'));

app.use('/js', express.static('js'));

app.use('/images', express.static('images'));

app.use(function (req, resp, next) {
    console.log('request received');
    console.log(req.headers);
    console.log(req.method);
    console.log(req.url);
    next(); // go to the the nest function 
})

app.use(function (req, resp, next) {
    console.log('request processing');
    next();
    // then we are tellng express we are done
})

app.use("/home", function (req, resp, next) {

    resp.sendFile('C:\\Users\\marci\\my_git_repos\\1806spark\\movie_review_website\\index.html');
    //resp.sendfile('') // add javascript files
    //next(): dont need this because as this function is sending the response


})