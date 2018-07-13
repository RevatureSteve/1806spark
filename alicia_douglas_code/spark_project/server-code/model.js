var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var PictureSchema = new Schema({
    userName: String,
    url: String,
    createdAt: {type: Date, default: Date.now},
    location: String,
    descritpion: String
});

var Picture = mongoose.model('Picture', PictureSchema);
module.exports.Picture = Picture;