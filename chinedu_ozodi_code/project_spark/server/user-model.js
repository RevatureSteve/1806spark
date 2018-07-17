var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var UserSchema = new Schema({
    username: String,
    createdAt: {type: Date, default: Date.now},
    email: String,
    password: String
});

var User = mongoose.model('User',UserSchema);

module.exports.User = User;