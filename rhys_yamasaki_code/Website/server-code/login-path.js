// var express = require('express');
// var router = express.Router();
// var User = require("./models").UserRegistration;

// router.post('/', function(req, res) {
//     User.findOne({ emailAddress: req.body.email }, function(err, user) {
//       if (!user) {
//         res.status(404).send('Invalid email or password.');
//       } else {
//         if (req.body.password === user.password) {
//           // sets a cookie with the user's info
//           req.session.user = user;
//           res.redirect('./pages/profile');
//         } else {
//           res.status(404).send('Invalid email or password.');
//         }
//       }
//     });
//   });