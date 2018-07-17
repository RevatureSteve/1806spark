var express = require('express');
var Stock = require('./stock-model').Stock;
var stock = express.Router();

stock.get('/', (req, resp, next)=>{
    console.log("route working");
});

stock.post('/', (req, resp, next)=>{
    console.log(req.body);
    let newStock = new Stock(req.body);
    newStock.save((err,stock)=>{
        if (err){
            return next(err);
        }
        resp.status = 201;
        resp.json(stock);
    })
}); 


module.exports = stock;