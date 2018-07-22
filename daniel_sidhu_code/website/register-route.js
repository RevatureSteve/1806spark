// .save is a method stores it in the database
// .exec is a method that executes a search for a match of a string
//.then is a method used to get back a result
//.catch is a method used to 'catch an error'


var express = require('express');
var registerRoute = express.Router();
var mongoose = require('mongoose');

var Register = require('./register-model');

//GET route working
//grabs all my data from my data base
//suburl, func handler(e.g. get)
registerRoute.get('/', function (req, resp, next) {
    Register.find()
        .select('_id username password actualname email')
        .exec()
        .then(docs => {
            //console.log(docs); dev purposes
            var response = {
                count: docs.length,
                registers: docs
            };
            resp.status(200).json(response);
        })
        .catch(err => {
            console.log(err);
            resp.status(500).json({
                error: err
            });
        });

    /*resp.status(200).json({
        message: 'handling GET requests to my register page'
        //use this bit here for dev purposes
    }); */
    console.log('GET register done');
});

//POST route working II
//posts new registration data
registerRoute.post('/', function (req, resp, next) {
    /*dev to test if postman works
    var register = {
        username: req.body.username,
        password: req.body.password,
        actualname: req.body.actualname,
        email: req.body.email
    }; */
    /*var register = new Register({
        _id: new mongoose.Types.ObjectId(),
        username: req.body.username,
        password: req.body.password,
        actualname: req.body.actualname,
        email: req.body.email
    });*/
    console.log(req.body);
    let register = new Register(req.body);//new Resgister is my constrctor
    register
        .save()
        .then(result => {
            console.log('A new register added');
            console.log(result);
            console.log('POST register done');
            resp.status(201).json({
                message: 'new register in' + result,
                createdRegister: result
                //this is a sort of console.log for my postman
            });
        })
        .catch(err => {
            console.log(err);
            resp.status(500).json({
                error: err
            });
        });
    //console.log('POST register done');
});


//using this to test if the postman GET funtion works 
    //with ID's being typed after '/register-route'
//working II
//used to grab specific information from my database 
    //thats why the colon is there, to show it is dynamic
registerRoute.get('/:registerId', function (req, resp, next) {
    var id = req.params.registerId;//the .params lets me retrieve the type of parameter e.g registerId
    Register.findById(id)
        .exec()
        .then(doc => {
            console.log('from the Database', doc);
            if (doc) {
                resp.status(200).json(doc);
            } else {
                resp.status(404).json({ message: 'no valid entry found for Id' });
            }

        })
        .catch(err => {
            console.log(err);
            resp.status(500).json({ error: err });
        });
    /* if (id === 'special') {
        resp.status(200).json({
            message: 'special ID found',
            id: id
        });
    } else {
        resp.status(200).json({
            message: 'you passed an ID'
        });
    } */
    console.log('GET registerId done');
});

//PATCH route working
//used to update any certain registration data based off of id
registerRoute.patch('/:registerId', function (req, resp, next) {
    var id = req.params.registerId;
    var updateOps = {};
    for (var ops of req.body) {
        updateOps[ops.propName] = ops.value;
    }
    Register.update({ _id: id }, { $set: updateOps })
    .exec()
    .then(result => {
        console.log(result);
        resp.status(200).json({result});
    })
    .catch(err => {
        console.log(err);
        resp.status(500).json({
            error: err
        });
    });
    // resp.status(200).json({
    //     message: 'updated register'
    //  used this for dev purposes
    // });
    console.log('PATCH register done');
});

//DELETE route working
//delete registration data based off of id
registerRoute.delete('/:registerId', function (req, resp, next) {
    var id = req.params.registerId;
    Register.remove({ _id: id })
        .exec()
        .then(result => {
            resp.status(200).json(result);
        })
        .catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            });
        });

    /*resp.status(200).json({
        message: 'deleted register'
        //used for dev purposes
    }); */
    console.log('DELETE register done');
});


module.exports = registerRoute;