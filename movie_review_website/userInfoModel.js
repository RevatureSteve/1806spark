'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var LoginSchema = new Schema({
    username: String,
    password: String,
    email: String
});

var Login = mongoose.model("Login", LoginSchema);

module.exports.Login = Login;