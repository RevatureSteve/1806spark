var express = require('express');
var homePath = express.Router();
var Picture = require('./model').Picture;


// GET request for Picture
homePath.get('/', function (req, resp, next) {
    console.log(req.url);
    // Mongo Stuff
    Picture.find({}).exec(
        function (err, picture) {
            if (err) {
                return next(err);
            };
            resp.json(picture);
        }
    );
});




// POST Request for Picture
homePath.post('/', function (req, resp, next) {
    console.log('Creating new picture');
    console.log(req.url);
    var picture = new Picture(req.body);
    // Mongo stuff
    picture.save(function (err, picture) {
        if (err) {
            return next(err);
        };
        resp.status(201);
        resp.json(picture);
    });
});






module.exports = homePath;