var express = require('express');
var restaurantRoutes = express.Router();

restaurantRoutes.get('/r', (req,resp,next) => {
    console.log('restaurant route requested');
});

module.exports = restaurantRoutes;