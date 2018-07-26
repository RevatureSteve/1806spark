var express = require('express');
var favoritePath = express.Router();
var User = require('./model').User;


favoritePath.post('/', function(req,resp,next){
    let ObjectId = require('mongodb').ObjectId;
    let id = req.body.id;
    let o_id = new ObjectId(id);
    let newFavorite = req.body.favorite;

    User.findByIdAndUpdate(o_id,{
        $push: {'favorites': newFavorite}
    },
{'new':true, 'upsert': true},
function(err, managerParent){
    if(err) {
        throw err;
    }
    console.log(managerParent);
} )
})


module.exports = favoritePath;