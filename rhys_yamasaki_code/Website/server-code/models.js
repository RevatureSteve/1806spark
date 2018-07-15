
var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var UserRegistrationSchema = new Schema({
    firstName: String,
    lastName: String,
    username: String,
    emailAddress: String,
    password: String,
    favoriteMovies: Array,
    favoriteActors: Array,
    profilePicture: String,
    createdAt: {type: Date, default:Date.now}
})

var MovieInfoSchema = new Schema({
    title: String,
    director: String,
    cast: Array
})

var MovieInfo = mongoose.model("movieInfo", MovieInfoSchema);
var UserRegistration = mongoose.model("userInfo", UserRegistrationSchema);

module.exports.UserRegistration = UserRegistration;
module.exports.MovieInfo = MovieInfo;