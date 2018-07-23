var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var ImageSchema = new Schema({
    fileName: String,
    createdAt: {type: Date, default: Date.now},
    url: String,
})

var Image = mongoose.model("Image", ImageSchema);
module.exports.Image = Image;
