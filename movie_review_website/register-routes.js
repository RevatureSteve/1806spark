'use strict';

var express = require("express");
var router = express.Router();
var Login = require("./userInfoModel").Login;

// GET /logins
// Route for logins collection
router.get("/", function (req, res, next) {
	Login.find({})
		// .sort({createdAt: -1})
		.exec(function (err, logins) {
			if (err) return next(err);
			res.json(logins);
		});
});

// POST /logins
// Route for creating logins
router.post("/", function (req, res, next) {
	var login = new Login(req.body);
	console.log(login);
	login.save(function (err, login) {
		if (err) return next(err);
		res.status(201);
		res.json(login);
	});
});

// GET /logins/:id
// Route for specific logins
router.get("/:qID", function (req, res, next) {
	res.json(req.login);
});


// DELETE /logins/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function (req, res) {
	req.answer.remove(function (err) {
		req.login.save(function (err, login) {
			if (err) return next(err);
			res.json(login);
		});
	});
});

module.exports = router;