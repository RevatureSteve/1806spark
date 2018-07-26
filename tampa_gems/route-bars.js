var express = require('express');
var barsRoute = express.Router();

barsRoute.get("/b", (req,resp, next) => {
    console.log('bars route requested');
});


module.exports = barsRoute;