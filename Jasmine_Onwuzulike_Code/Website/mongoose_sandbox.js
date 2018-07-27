var mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/sandbox');

var db = mongoose.connection;

db.on("error", function(err){
    console.log('Connection Error: ' + err);
});

db.once("open", function(){
    console.log("DB connection successful");

    var Schema = mongoose.Schema;
    var BarSchema = new Schema({
        name: String,
        yearsOpen: Number,
        open_weekdays: Boolean,
        website: String
    }); 

    var Bar = mongoose.model("Bar", BarSchema);
    var wob = new Bar({
        name: "WOB",
        yearsOpen: 20,
        open_weekdays: true,
        website: "https://worldofbeer.com/"
    });

    wob.save(function(err){
        if(err) console.error("Save failed " + err);
        else console.log('Saved wob');
        db.close(function(){
            console.log('connection closed');
        });
    })


})
