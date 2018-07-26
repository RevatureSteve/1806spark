var mongoose = require('mongoose');
var Schema = mongoose.Schema;// adds structure to non structured database, makes it easier
var SubmissionSchema = new Schema({ 
    submission: String, //the submission , type is string
    type:String,// the type of submission for this project, also a string
    createdAt: {type:Date, default: Date.now}, // when it was created

});

var Submission = mongoose.model("Submission", SubmissionSchema);// giving a variable to the scheoma i just create
module.exports.Submission = Submission; //allows me to call the schema somewhere else