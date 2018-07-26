var express = require('express');
var commentsPath = express.Router();
var Picture = require('./model').Picture;


commentsPath.post('/', function(req,resp,next){
    let ObjectId = require('mongodb').ObjectId;
    let id = req.body.id;
    let o_id = new ObjectId(id);
    let newComment = req.body.comment;

    Picture.findByIdAndUpdate(o_id,{
        $push: {'comments': newComment}
    },
{'new':true, 'upsert': true},
function(err, managerParent){
    if(err) {
        throw err;
    }
    console.log(managerParent);
} )
})


module.exports = commentsPath;