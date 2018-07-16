
var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var UserSchema = new Schema({
    firstName: String,
    lastName: String,
    emailAddress: String,
    password: String,
    favoriteMovies: Array,
    favoriteActors: Array,
    createdAt: {type: Date, default:Date.now}
})

UserSchema.add({username: String, profilePicture: String})

var MovieInfoSchema = new Schema({
    title: String,
    director: String,
    cast: Array
})

var MovieInfo = mongoose.model("movieInfo", MovieInfoSchema);
var UserRegistration = mongoose.model("user", UserSchema);

module.exports.UserRegistration = UserRegistration;
module.exports.MovieInfo = MovieInfo;