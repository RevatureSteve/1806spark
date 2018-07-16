var express = require('express');
var router = express.Router();

router.get('/', function(req, res) {
    console.log('/login');
    res.send("Signed up for an account!")
});


router.post('/', function(req, res) {
    console.log(req.body);
})
module.exports = router;
