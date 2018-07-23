var express = require('express');
var router = express.Router();
var MovieInfo = require("./models").MovieInfo;

router.get("/", function (req, resp, next) {
    console.log("reached step 1");
    console.log(req.url);
    MovieInfo.find({})
        .exec(function (err, movie) {
            if (err) {
                return next(err);
            }
            resp.json(movie);
        })
})

router.post("/", function (req, resp, next) {
    console.log(req.body);
    var movie = new MovieInfo(req.body);
    movie.save(function (err, user) {
        if (err) {
            return next(err);
        }
        resp.status(201);
        resp.json(movie);
    })
})

module.exports = router;