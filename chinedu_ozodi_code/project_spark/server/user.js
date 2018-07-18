var express = require('express');
var User = require('./user-model').User;
var user = express.Router();



user.post('/login', (req, resp, next)=>{
    console.log("attempting to log in...");
    console.log(req.body);
    let body = req.body;
    User.find({username: body.username, password: body.password}).exec((err,login) =>{
        if(err){
            return next(err);
        }
        console.log('Login attempt return:');
        console.log(login);
        resp.json(login);
    });
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