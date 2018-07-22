var express = require('express');
var orderRoute = express.Router();

//GET order works
orderRoute.get('/', function(req, resp, next){
    resp.status(200).json({
        message: 'orders were fetched'
    });
});

//POST order works II
orderRoute.post('/', function(req, resp, next){
    //dev to test if postman works
    var order = {
        registerId: req.body.registerId,
        quanity: req.body.quanity,
    };
    resp.status(201).json({
        message: 'orders were created',
        order: order
    });
    console.log('orders posted');
});

orderRoute.get('/:orderId', function(req, resp, next){
    resp.status(200).json({
        message: 'orders details',
        orderId: req.params.orderId
    });
});



module.exports = orderRoute;