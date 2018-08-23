var express = require('express');
var app = express();
var cors = require('cors');
app.use(cors());

let port = 3000;

app.listen(port,()=> console.log('todo client ready on port' + port));



app.get('',function(req,resp,next){
    console.log('requesting home page.');
    resp.sendFile('/Users/prjctmedia/Desktop/projects/todoclient/template.html');
})
// make static content available

        //url                   //foldername
app.use('/pages',express.static('pages'));
app.use('/js',express.static('js'));


