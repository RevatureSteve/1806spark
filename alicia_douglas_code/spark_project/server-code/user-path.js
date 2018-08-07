var express = require('express');
var userPath = express.Router();
var User = require('./model').User;


// GET request for User
userPath.get('/', function (req, resp, next) {
    console.log(req.url);
    // Mongo Stuff
    User.find({}).exec(
        function (err, user) {
            if (err) {
                return next(err);
            };
            resp.json(user);
        }
    );
});




// POST Request for user
userPath.post('/', function (req, resp, next) {
    console.log('Creating new user');
    console.log(req.url);
    var user = new User(req.body);
    // Mongo stuff
    user.save(function (err, user) {
        if (err) {
            return next(err);
        };
        resp.status(201);
        resp.json(user);
    });
});






module.exports = userPath;