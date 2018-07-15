var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var EntrySchema = new Schema({
    firstName: string,
    lastName: string,
    email: string,
});

var Entry = mongoose.model("Entry", EntrySchema)
module.exports.Entry = Entry;