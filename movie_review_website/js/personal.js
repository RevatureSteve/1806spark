
var url = 'http://localhost:3000/reviews';
window.onload = function () {
// legacy test code that pushes an item into the database
    let data = {
        "header": "Greatest movie of the season",
        "author": "Mr Fantastic",
        "movieTitle": "Ant-Man and the Wasp",
        "reviewBody": "Absolute masterpiece 10/10",
        "commentsArr": ["great movie", "I concur!" ],
        "commentsAuthors": ["Mrs. Fantastic", "Random Dude"]
    }

    console.log(data);

    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}! Must be converted to JSON
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(data => data.json()).then(q => {
        console.log('post');

    });
    //*/
}