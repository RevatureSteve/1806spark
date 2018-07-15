var express = require("express");
var registerPath = express.Router();
var UserRegistration = require("./models").UserRegistration;

// registerPath.get("/", function(req, resp, next) {
//     console.log("reached step 1");
//     console.log(req.url);
//     UserRegistration.find({})
//     .exec(function (err, registration){
//         if (err) {
//             return next(err);
//         }
//         resp.json(registration);
//     })
// })

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