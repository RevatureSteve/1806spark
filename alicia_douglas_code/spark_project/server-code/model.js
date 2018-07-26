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


var UserSchema = new Schema({
    name: String,
    emailAddress: String,
    dob: Date,
    userName: String,
    password: String,
    favorites: Array
})



var Picture = mongoose.model('Picture', PictureSchema);
module.exports.Picture = Picture;


var User = mongoose.model('User', UserSchema);
module.exports.User = User;

