// all Questions changed to Travels
var express = require("express");
var router = express.Router();
// quwstion model is for mongoose 
var Travel = require("./myModel").Travel;



// GET /travels
// Route for travels collection
router.get("/", function(req, res, next){
	console.log('/travels');
	//mongodb stuff
	Travel.find({})
				// .sort({createdAt: -1})
				.exec(function(err, travels){
					if(err) return next(err);
					res.json(travels);
				});
});

// POST /travels
// Route for creating travels
router.post("/", function(req, res, next){
	console.log('Creating new travel');
	console.log(req.body);
	var travel = new Travel(req.body);
	console.log(travel);
	travel.save(function(err, travel){
		if(err) return next(err);
		res.status(201);
		res.json(travel);
	});
});

// GET /travels/:id
// Route for specific travels
router.get("/:qID", function(req, res, next){
	res.json(req.travel);
});




// DELETE /travels/:qID/answers/:aID
// Delete a specific answer
router.delete("/:qID/answers/:aID", function(req, res){
	req.answer.remove(function(err){
		req.travel.save(function(err, travel){
			if(err) return next(err);
			res.json(travel);
		});
	});
});



module.exports = router;