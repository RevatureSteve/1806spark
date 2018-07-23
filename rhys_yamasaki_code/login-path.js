var express = require("express");
var loginPath = express.Router();
var UserRegistration = require("./models").UserRegistration;


loginPath.post('/', function(req, res) {
    UserRegistration.findOne({ email: req.body.email }, function(err, user) {
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

loginPath.get('/profile', function(req, resp) {
    if(!req.session.user) {
        return resp.status(401).send();
    }
    return resp.status(200).send();
})

loginPath.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.question.save(function(err, question){
			if(err) return next(err);
			res.json(question);
		});
	});
});

// get specific user
loginPath.get("/:uId", function(req, resp, next) {
    res.json(req.question);
});

module.exports = loginPath;