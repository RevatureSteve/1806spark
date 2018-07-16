var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var PostsSchema = new Schema({
    name: String,
    email: String,
    newPost: String,
    createdAt: {type: Date, default: Date.now},
})

var Posts = mongoose.model("Posts", PostsSchema);
module.exports.Posts = Posts;