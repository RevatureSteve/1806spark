var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var StockSchema = new Schema({
    type: String,
    stock: String,
    user:  String,
    createdAt: {type: Date, default: Date.now},
    amount: Number,
    price: Number
});

var Stock = mongoose.model('Stock',StockSchema);

module.exports.Stock = Stock;