var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var MealSchema = new Schema({
	name: String,
    url: String,
    rating: Number,
    cooktime: String,
    servings: String,
    ingredients: Array
});


var Meal = mongoose.model("Meal", MealSchema);

module.exports.Meal = Meal;
