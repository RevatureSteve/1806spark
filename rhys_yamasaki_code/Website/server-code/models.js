
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

UserSchema.add({username: String, profilePicture: {type: String, default: "../images/OFxuvcKhqInd2RX01yK9BCfj_400x400.png"}})

var MovieInfoSchema = new Schema({
    id: Number,
    title: String,
    poster_path: String,
    overview: String,
    release_date: String
})

var MovieInfo = mongoose.model("movieInfo", MovieInfoSchema);
var UserRegistration = mongoose.model("user", UserSchema);

module.exports.UserRegistration = UserRegistration;
module.exports.MovieInfo = MovieInfo;