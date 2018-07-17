var express = require("express");
var registerPath = express.Router();
var UserRegistration = require("./models").UserRegistration;

registerPath.get("/users", function(req, resp, next) {
    console.log("reached step 1");
    console.log(req.url);
    UserRegistration.find({})
    .exec(function (err, registration){
        if (err) {
            return next(err);
        }
        resp.json(registration);
    })
})


registerPath.post("/", function(req, resp, next){
    console.log(req.body);
    var user = new UserRegistration(req.body);
    user.save(function(err, user) {
        if(err) {
            return next(err);
        }
        resp.status(201);
        resp.json(user);
    })
})


registerPath.post('/', function(req, res) {
    User.findOne({ emailAddress: req.body.email }, function(err, user) {
      if (!user) {
        res.status(404).send('Invalid email or password.');
      } else {
        if (req.body.password === user.password) {
          // sets a cookie with the user's info
          req.session.user = user;
          res.redirect('./pages/profile');
        } else {
          res.status(404).send('Invalid email or password.');
        }
      }
    });
  });



module.exports = registerPath;