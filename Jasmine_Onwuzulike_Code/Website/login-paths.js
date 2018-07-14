var express = require('express');
var router = express.Router();

router.get('/', function(req, res,next) {
    console.log("/photography");
    res.sendFile("C:\\Users\\Jasmine C Onwuzulike\\My_Git_Repos\\1806spark\\Jasmine_Onwuzulike_Code\\Website\\Pages\\photography.html");
});

//export this router to use in server.js
module.exports = router;