'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var BudgetSchema1 = new Schema({
    expense: String,
    createdAt: {type: Date, default: Date.now},
    amount: String
});

var Budget1 = mongoose.model("Budget", BudgetSchema1);

module.exports.Budget1 = Budget1;


// var mongoose = require("mongoose");
// var Schema = mongoose.Schema;

// var BudgetSchema = new Schema({
//     budget: String,
//     createdAt: {type: Date, default: Date.now},
//     answer: String
// });

// var Budget = mongoose.model("Budget", BudgetSchema);

// module.exports.Budget = Budget;