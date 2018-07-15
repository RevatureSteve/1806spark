'use strict';

var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var BudgetSchema = new Schema({
    budget: String,
    createdAt: {type: Date, default: Date.now},
    answer: String
});

var Budget = mongoose.model("Budget", BudgetSchema);

module.exports.Budget = Budget;