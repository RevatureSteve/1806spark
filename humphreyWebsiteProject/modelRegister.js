var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var personSchema = new Schema({
	firstName: String,
	lastName: String,
	email: String,
	username: String,
	password: String
});


var Person = mongoose.model("NewPerson", personSchema);

module.exports.Person = Person;




