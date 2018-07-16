var express = require("express");
var registerPath = express.Router();
var UserRegistration = require("./models").UserRegistration;

registerPath.get("/user", function(req, resp, next) {
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

registerPath.post("/login", function(req, resp, next) {
    var email = req.body.email;
    var password = req.body.password;
    UserRegistration.findOne({emailAddress: email, password: password}, function(err, user) {
        if(err) {
            console.log(err);
            return resp.status(500).send();
        }

        if(!user) {
            return resp.status(404).send();
        }
        return resp.status('200').send();
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

module.exports = registerPath;