var express = require('express');
var Stock = require('./stock-model').Stock;
var stock = express.Router();

stock.post('/get', (req, resp, next)=>{
    console.log(req.body);
    let body = req.body;
    Stock.find({user: body.username}).exec((err,stocks) =>{
        if(err){
            return next(err);
        }
        console.log(stocks);
        resp.json(stocks);
    });
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