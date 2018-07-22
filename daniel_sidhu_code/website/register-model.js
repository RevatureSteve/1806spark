var mongoose = require('mongoose');

var registerSchema = mongoose.Schema({
    //_id: mongoose.Schema.Types.ObjectId, dev purposes
    username: {type: String, required: true},
    password: {type: String, required: true},
    actualname: {type: String, required: true},
    email: {type: String, required: true}
});

module.exports = mongoose.model('Register', registerSchema);