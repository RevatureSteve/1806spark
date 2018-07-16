var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var PictureSchema = new Schema({
    userName: String,
    url: String,
    createdAt: {type: Date, default: Date.now},
    location: String,
    descritpion: String,
    comments: Array
});



var CommentSchema = new Schema({
    url: String,
    userName: String,
    createdAt: {type: Date, default: Date.now},
    comment: String
})



var Picture = mongoose.model('Picture', PictureSchema);
module.exports.Picture = Picture;


var Comment = mongoose.model('Comment', CommentSchema);
module.exports.Comment = Comment;

