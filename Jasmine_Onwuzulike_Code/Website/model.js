
var mongoose = require("mongoose");
var Schema = mongoose.Schema;


var EntrySchema = new Schema({
	first_name: String,
    last_name: String,
    email: String
});


var Entry = mongoose.model("Entry", EntrySchema);

module.exports.Entry = Entry;













