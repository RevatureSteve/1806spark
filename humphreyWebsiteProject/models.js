var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var movieSchema = new Schema({
	movieTitle: String,
	releaseDate: String,
	plot: String,
	genre: String,
	moviePoster: String
});


var Movie = mongoose.model("Movies", movieSchema);

module.exports.Movie = Movie;




