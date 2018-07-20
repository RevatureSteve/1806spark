

//Shows quotes.
document.getElementById('getQuote').addEventListener("click", getAQuote);
function getAQuote() {
    let collection = ["Photography si the story I fail to put into words.",
    "In photography there is a reality so subtle that it becomes more real than reality.",
    "Taking an image, freezing a moment, reveals how rich reality truly is.",
    "There is one thing the photograph must contain, the humanity of the moment.",
    "We are making photographs to understand what our lives mean to us."
   ];
   //Getting a random number
let ran = collection[Math.floor(Math.random() * collection.length)]; 
console.log(ran);
document.getElementById('quotes').innerHTML = ran;
};