var express = require('express');
var homePath = express.Router();
var Image = require('./model').Image;

// GET images
homePath.get("/", function (req, resp, next) {
    console.log(req.url);
    Image.find({}).exec(
        function(err, image){
            if(err) {
                return next(err);
            }
            resp.json(image);
        }
    )
})

// Create Images
homePath.post("/", function (req, resp, next) {
    console.log('New picture');
    console.log(req.url);
    var image = new Image(req.body);
    image.save(function(err, image){
        if (err) {
            return next(err);
        }
        resp.json(image);
    })
})

// allows others to require ('homePath')
module.exports = homePath;