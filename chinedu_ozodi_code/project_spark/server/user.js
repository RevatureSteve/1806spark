var express = require('express');
var User = require('./user-model').User;
var user = express.Router();



user.get('/', (req, resp, next)=>{
    console.log("route working");
}); 
user.post('/', (req, resp, next)=>{
    console.log(req.body);
    let newUser = new User(req.body);
    newUser.save((err,user)=>{
        if (err){
            return next(err);
        }
        resp.status = 201;
        resp.redirect('/pages/success.html');
    })
}); 


module.exports = user;