var express = require('express');
var router = express.Router();
var Entry = require('./model').Entry;


router.get('/', function(req, res) {
    console.log('/login');
});


router.post('/', function(req, res, next) {
    console.log("Creating a new entry.")
    console.log(req.body);
  var entry = new Entry(req.body)
    entry.save(function(err, entry) {
     if (err) return next(err);
     res.json(entry);
     console.log(entry);

 })

});

module.exports = router;
